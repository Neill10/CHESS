package pieces;

import javax.swing.*;
import java.util.*;
import javax.swing.*;

public class BoardTile extends JButton {
    private boolean whiteSquare;
    private final int POSTIONX;//(1,2,3,4,5,6,7,8)
    private final int POSTIONY;//(a,b,c,d,e,f,g,h)
    private Piece piece;


    public BoardTile(int x, int y, boolean white)
    {
        POSTIONX = x;
        POSTIONY = y;
        whiteSquare = white;
    }
    public BoardTile(Piece piece, int x, int y, boolean white)
    {
        this.piece = piece;
        POSTIONX = x;
        POSTIONY = y;
        whiteSquare = white;
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

    public int getPOSTIONX() {
        return POSTIONX;
    }

    public int getPOSTIONY() {
        return POSTIONY;
    }

}
