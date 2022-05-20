package pieces;



import java.util.*;
public class Queen extends Piece {

    public Queen(int x, int y,boolean white)
    {
        super("Queen",x,y,white);
    }

    /*
    @Override
    public boolean move(int x, int y)//returns true if successfully moved.
    {
        return true;
    }

     */

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        return null;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Q";
    }
}
