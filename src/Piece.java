import java.util.*;
public class Piece {
    private boolean white;
    private boolean captured;
    private boolean canJump;
    private int postionX;//(1,2,3,4,5,6,7,8)
    private int postionY;//(a,b,c,d,e,f,g,h)
    private String pieceName;

    public Piece(String pieceName, int x, int y,boolean canJump,boolean captured,boolean white)
    {
        this.pieceName = pieceName;
        postionX = x;
        postionY = y;
        this.canJump =  canJump;
        this.captured = captured;
        this.white = white;

    }
    //just a stand in
    public boolean move(Board b, int x, int y){
        return false;
    }

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
