import java.util.*;
public class Queen extends Piece{

    public Queen(String pieceName, int x, int y,boolean canJump,boolean captured,boolean white)
    {
        super(pieceName,x,y,canJump,captured,white);
    }
    @Override
    public boolean move(Board b, int x, int y)//returns true if successfully moved.
    {
        boolean team = isWhite();
        //location at (x,y) is empty
        if(!b.getBoard()[x][y].isOccupied())
        {

            return true;
        }
        else
        {
            if(b.getBoard()[x][y].getPiece().isWhite() != team) //compares the piece's (at index x+1 y+1 of board) team to the current moving piece(queen) team.
            {
                System.out.println("You have captured enemy's with your queen");
                b.getBoard()[x][y].setPiece(this);

            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Q";
    }
}
