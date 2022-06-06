package pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class BoardTile extends JButton implements Serializable {
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
        //sets up initial look
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
                if (!selected)
                {//shows possible move
                    if(isOccupied())
                    {
                        if(pieceInPlayerTeam())
                        {

                            //resets board tiles, so it doesn't leave behind highlighted tiles
                            for(BoardTile[] tiles : associatedBoard.getBoard())
                            {
                                for(BoardTile tile : tiles)
                                {
                                    if (tile.isWhiteSquare())
                                    {
                                        tile.setIcon(new ImageIcon("src/Assets/whiteSquare.png"));

                                    }
                                    else
                                    {
                                        tile.setIcon(new ImageIcon("src/Assets/greenSquare.png"));

                                    }
                                }
                            }
                            associatedBoard.setSelectedPiece(getPiece());
                            associatedBoard.setSelectedTile(BoardTile.this);
                            System.out.print(associatedBoard.getSelectedPiece());

                            //System.out.println(piece.getPositionX() + "," + piece.getPositionY());
                            ArrayList<BoardTile> highlight = makeTilePossible();
                            //highlighted tiles

                            for(BoardTile tile : highlight)
                            {
                                tile.setIcon(new ImageIcon("src/Assets/yellowSquare.png"));
                                if(tile.isOccupied())
                                {
                                    tile.setIcon(new ImageIcon("src/Assets/redSquare.png"));
                                }
                            }

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
                }
                else
                {
                //selected is true you can move
                Piece selectedPiece = associatedBoard.getSelectedPiece();
                //limelighting tiles
                ArrayList<BoardTile> dehighlight = selectedPiece.getPossibleMoves();
                for(BoardTile tile : dehighlight)
                {
                    if (tile.isWhiteSquare())
                    {
                        tile.setIcon(new ImageIcon("src/Assets/whiteSquare.png"));

                    }
                    else
                    {
                        tile.setIcon(new ImageIcon("src/Assets/greenSquare.png"));

                    }
                }
                BoardTile selectedTile = associatedBoard.getSelectedTile();//tiles that piece is moving to
                //deletes one icon
                removeJLabel();
                jLabel = selectedTile.getjLabel();
                System.out.println(jLabel);

                add(jLabel);

                selectedTile.removeJLabel();
                selectedPiece.move(getPOSITIONX(),getPOSITIONY());
                System.out.println(selectedPiece + " has moved to (" + POSITIONX +", "+  POSITIONY +")");
                associatedBoard.setSelectedAll(false);
                //pawn promotion: has to be put here since move methods run before this (and this replaces icons)

                System.out.println(selectedTile);
                //changes pawn to a queen if it on back rank
                if(isOccupied() && getPiece().getPieceName().equals("pawn") && getPOSITIONX() == 0 || isOccupied() && getPiece().getPieceName().equals("pawn") &&getPOSITIONX() == 7 )
                {
                    if(getPOSITIONX()== 0)
                    {
                        Board b = associatedBoard;
                        Queen promoteWhite = new Queen(getPOSITIONX(), getPOSITIONY(), true);
                        promoteWhite.setBoard(b);
                        b.getBoard()[getPOSITIONX()][getPOSITIONY()].setPiece(promoteWhite);//sets the pawn piece into null
                        System.out.println("promoted");
                        selectedTile.removeJLabel();
                        b.getPlayerTeam().add(promoteWhite);
                        removeJLabel();
                        jLabel = new JLabel(new ImageIcon("src/Assets/queenWhite.png"));
                        add(jLabel);
                    }
                    else if(getPOSITIONX() == 7)
                    {

                        Board b = associatedBoard;
                        Queen promoteBlack = new Queen(getPOSITIONX(), getPOSITIONY(), false);
                        promoteBlack.setBoard(b);
                        b.getBoard()[getPOSITIONX()][getPOSITIONY()].setPiece(promoteBlack);//sets the pawn piece into null
                        System.out.println("promoted");
                        selectedTile.removeJLabel();

                        removeJLabel();
                        jLabel = new JLabel(new ImageIcon("src/Assets/queenBlack.png"));
                        add(jLabel);
                    }
                    else
                    {
                        System.out.println("something went wrong");
                    }
                }
                //flips turn
                //associatedBoard.setPlayerTurn(!associatedBoard.isPlayerTurn());

                boolean enemy = associatedBoard.alive(associatedBoard.enemyTeam());
                if(enemy == false)
                {
                    System.out.println("YOU WON!");
                    System.exit(0);
                }
                associatedBoard.SAMbot();
                boolean player = associatedBoard.alive(associatedBoard.getPlayerTeam());
                if(player == false)
                {
                    System.out.println("YOU LOST!");
                    System.exit(0);
                }

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

        setVisible(true);
        return this;
    }

    public boolean pieceInPlayerTeam()
    {
        boolean inPlayerTeam = false;
        for(Piece p : associatedBoard.getPlayerTeam())
        {
            if(piece.equals(p))
            {
                inPlayerTeam = true;
            }
        }
        return inPlayerTeam;
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
            removeAll();
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
