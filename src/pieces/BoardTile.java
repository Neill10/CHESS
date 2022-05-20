package pieces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class BoardTile extends JButton {
    private boolean whiteSquare;
    private final int POSITIONX;//(1,2,3,4,5,6,7,8)
    private final int POSITIONY;//(a,b,c,d,e,f,g,h)
    private Piece piece;


    public BoardTile(int x, int y, boolean white)
    {
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
    }
    public BoardTile(Piece piece, int x, int y, boolean white)
    {
        this.piece = piece;
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
    }

    public void setPossibleMoves()
    {
        piece.possibleMoves();
    }

    public JButton createTileButton()
    {
        JButton tile = new JButton("Tile");
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked");
            }
        });
        tile.setVisible(true);
        return tile;
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
