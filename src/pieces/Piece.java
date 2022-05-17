package pieces;

import java.util.*;
public abstract class Piece {
    private boolean white;
    private int postionY;//(1,2,3,4,5,6,7,8)(COL)
    private int postionX;//(a,b,c,d,e,f,g,h)(ROW)
    private String pieceName;
    private ArrayList<BoardTile> possibleMoves;
    private Board board;

    public Piece(String pieceName, int x, int y,boolean white)
    {
        this.pieceName = pieceName;
        postionX = x;
        postionY = y;
        this.white = white;


    }

    public abstract boolean move(Board b, int x, int y);

    public abstract ArrayList<BoardTile> possibleMoves();

    //getter methods
    public boolean isWhite()
    {
        return white;
    }

    public int getPostionX() {
        return postionX;
    }

    public int getPostionY() {
        return postionY;
    }

    public String toString()
    {
        return "piece";
    }


}
