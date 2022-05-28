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
        ArrayList<BoardTile> moves = piece.possibleMoves();

        associatedBoard.setSelectedAll(false);//sets all boardTiles selected default is false
        for (BoardTile tilePossible : moves) {
            tilePossible.setSelected(true);
            System.out.println(tilePossible + " " + tilePossible.getSelected());
        }
        return moves;
    }

    public JButton createTileButton()
    {
        //sets up inital look
        if(isOccupied()) {
            String pieceName = piece.getPieceName();
            boolean pieceColor = piece.isWhite();
            if(pieceColor)
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "White.png"));
                add(jLabel);
            }
            else
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "Black.png"));
                add(jLabel);
            }
        }
        //updates board based on user clicks
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent clicked) {
                if (!selected) {//shows possible move
                    if(isOccupied()) {
                        if(associatedBoard.isWhiteTurn() == piece.isWhite())
                        {
                            associatedBoard.setSelectedPiece(getPiece());
                            associatedBoard.setSelectedTile(BoardTile.this);
                            System.out.print(associatedBoard.getSelectedPiece());

                            //System.out.println(piece.getPositionX() + "," + piece.getPositionY());
                            ArrayList<BoardTile> moves = makeTilePossible();

                            for (BoardTile[] tiles : associatedBoard.getBoard()) {
                                for (BoardTile tile : tiles) {
                                    if(tile.isOccupied()) {
                                        if (tile.getPiece().equals(piece)) {
                                            System.out.print("*****");
                                        }
                                        else
                                        {
                                            System.out.print(tile.getSelected() + " ");
                                        }
                                    }
                                    else
                                    {
                                        System.out.print(tile.getSelected() + " ");
                                    }

                                }
                                System.out.println();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("no piece at :");
                        System.out.println("(" + POSITIONX + "," + POSITIONY + ")");
                    }
                } else {//selected is true you can move
                    Piece selectedPiece = associatedBoard.getSelectedPiece();
                    System.out.println(selectedPiece);
                    BoardTile selectedTile = associatedBoard.getSelectedTile();
                    //deletes one icon
                    removeJLabel();
                    selectedPiece.move(getPOSITIONX(),getPOSITIONY());
                    System.out.println(selectedPiece + " has moved to (" + POSITIONX +", "+  POSITIONY +")");
                    associatedBoard.setSelectedAll(false);
                    //adds the moved piece icon
                    jLabel = selectedTile.getjLabel();
                    add(jLabel);
                    selectedTile.removeJLabel();
                    //flips turn
                    associatedBoard.setWhiteTurn(!associatedBoard.isWhiteTurn());
                    Board.FRAME.invalidate();
                    Board.FRAME.validate();
                    Board.FRAME.repaint();
                    /*
                    Piece rook = associatedBoard.getBoard()[0][0].getPiece();
                    rook.move(6,0);
                     */
                }
            }
        });
        if((getPOSITIONX() + getPOSITIONY()) % 2 == 0) {
            try {
                icon = new ImageIcon("src/Assets/whiteSquare.png");
                setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no whiteSquare file found");
            }
        }
        else
        {
            try {
                icon = new ImageIcon("src/Assets/greenSquare.png");
                setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no greenSquare file found");
            }
        }

        //tile.setRolloverEnabled(true);
        //setOverLay(tile);
        setVisible(true);
        return this;
    }


    public JLabel getjLabel() {
        return jLabel;
    }

    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public void removeJLabel()
    {
        if(isOccupied()) {
            remove(jLabel);
        }
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
