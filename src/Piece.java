import java.util.*;
public abstract class Piece {
    private boolean white;
    private boolean captured;
    private int postionX;//(1,2,3,4,5,6,7,8)
    private int postionY;//(a,b,c,d,e,f,g,h)
    private String pieceName;

    public Piece(String pieceName, int x, int y,boolean captured,boolean white)
    {
        this.pieceName = pieceName;
        postionX = x;
        postionY = y;
        this.captured = captured;
        this.white = white;

    }

    public abstract boolean move(Board b, int x, int y);

    public abstract ArrayList<BoardTile> possibleMoves();

    //getter methods
    public boolean isWhite()
    {
        return white;
    }

    public boolean isCaptured() {
        return captured;
    }

    public int getPostionX() {
        return postionX;
    }

    public int getPostionY() {
        return postionY;
    }
    /*
    public String[] possibleMoves()
    {

    }

     */

    public String toString()
    {
        return "piece";
    }


}
