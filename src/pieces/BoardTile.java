package pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class BoardTile extends JButton {
    private boolean whiteSquare;
    private final int POSITIONX;//(1,2,3,4,5,6,7,8)
    private final int POSITIONY;//(a,b,c,d,e,f,g,h)
    private Piece piece;
    private boolean selected;//changes functionality of possible tiles of a piece.
    //selected(true) means that tile can be moved to. deselected(false) would be default meaning that it shows possible moves
    private JLabel jLabel;
    private Icon icon;
    private Board associatedBoard;



    public BoardTile(int x, int y, boolean white)
    {
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
        selected = false;
    }
    public BoardTile(Piece piece, int x, int y, boolean white)
    {
        this.piece = piece;
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
        selected = true;
    }

    public void selectedPiece(JButton tile)
    {
        if(!selected) {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Board b = piece.getAssociatedBoard();

                    b.setSelectedAll(false);//sets all boardTiles selected
                    ArrayList<BoardTile> moves = piece.possibleMoves();
                    for (BoardTile tilePossible : moves) {
                        System.out.print(tilePossible);
                        tilePossible.setSelected(true);
                    }
                }
            });
        }
        else
        {
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {//clicked on after selected = true
                    piece.move(getPOSITIONX(),getPOSITIONY());
                    piece.getAssociatedBoard().setSelectedAll(false);
                }
            });
            System.out.println("piece moved");
        }
        /*

        Board b = piece.getAssociatedBoard();

        //b.setDeselectAll();//sets all boardTiles to deselected
        ArrayList<BoardTile> moves = piece.possibleMoves();
        for (BoardTile tilePossible : moves) {
            System.out.print(tilePossible);
            tilePossible.setSelected(true);

            Icon tileIcon = tilePossible.getIcon();
            //tilePossible.remove(tileIcon);
            tilePossible.setBackground(Color.BLUE);
            tilePossible.setIcon(tileIcon);

            //tilePossible.setIcon(new ImageIcon("src/Assets/blackSquare.png"));//icon not setting???
        }

         */
        /*
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent moving) {

            }
        });
         */
    }

    public ArrayList<BoardTile> makeTilePossible()
    {
        System.out.println(associatedBoard);
        ArrayList<BoardTile> moves = piece.possibleMoves();
        System.out.println(moves);

        associatedBoard.setSelectedAll(false);//sets all boardTiles selected default is false
        for (BoardTile tilePossible : moves) {
            tilePossible.setSelected(true);
            System.out.println(tilePossible + " " +tilePossible.getSelected());
        }


        return moves;
    }

    public JButton createTileButton()
    {
        JButton tile = new JButton();
        if(isOccupied()) {
            String pieceName = piece.getPieceName();
            boolean pieceColor = piece.isWhite();
            if(pieceColor)
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "White.png"));
                tile.add(jLabel);
            }
            else
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "Black.png"));
                tile.add(jLabel);
            }
        }
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clicked) {
                if (!selected) {
                    if(isOccupied()) {
                        associatedBoard.setSelectedPiece(getPiece());
                        System.out.print(associatedBoard.getSelectedPiece());

                        System.out.println(piece.getPositionX() +","+ piece.getPositionY());
                        ArrayList<BoardTile> moves = makeTilePossible();
                        System.out.println("  made tiles possible to move to");

                        for(BoardTile[] tiles : associatedBoard.getBoard())
                        {
                            for(BoardTile tile : tiles)
                            {
                                System.out.print(getSelected()+" ");
                            }
                            System.out.println();
                        }
                    }
                    else
                    {
                        System.out.print("no piece at :");
                        System.out.println("(" + POSITIONX + "," + POSITIONY + ")");
                    }
                } else {//selected is true
                    Piece selectedPiece = associatedBoard.getSelectedPiece();
                    selectedPiece.move(getPOSITIONX(),getPOSITIONY());
                    System.out.println(selectedPiece + " has moved to (" + POSITIONX +", "+  POSITIONY +")");
                    associatedBoard.setSelectedAll(false);
                }
            }
        });
        if((getPOSITIONX() + getPOSITIONY()) % 2 == 0) {
            try {
                icon = new ImageIcon("src/Assets/whiteSquare.png");
                tile.setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no whiteSquare file found");
            }
        }
        else
        {
            try {
                icon = new ImageIcon("src/Assets/greenSquare.png");
                tile.setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no greenSquare file found");
            }
        }

        //tile.setRolloverEnabled(true);
        //setOverLay(tile);
        tile.setVisible(true);
        return tile;
    }


    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public void removeLabel()
    {
        remove(jLabel);
    }
    public void setOverLay(JButton b)
    {
        if(isOccupied())
        {
            b.setIcon(piece.getIcon());
            //System.out.println("TILE ICON SET");
        }
    }

    public void setSelected(boolean select)
    {
        selected = select;
    }

    public void setPossibleMoves()
    {
        piece.possibleMoves();
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOccupied() {
        return piece != null;
    }



    public Piece getPiece() {
        return piece;
    }

    public boolean getSelected()
    {
        return selected;
    }

    public void setAssociatedBoard(Board associatedBoard) {
        this.associatedBoard = associatedBoard;
    }

    public boolean isWhiteSquare() {
        return whiteSquare;
    }

    public int getPOSITIONX() {
        return POSITIONX;
    }

    public int getPOSITIONY() {
        return POSITIONY;
    }

    public String toString()
    {
        return "(" + POSITIONX +"," + POSITIONY + ")";
    }


}
