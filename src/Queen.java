public class Queen extends Piece{

    @Override
    public boolean move(Board b, int x, int y)
    {
        boolean team = isWhite();
        //location at (x,y) is empty
        if(!b.getBoard()[x][y].isOccupied())
        {

            return true;
        }
        return false;
    }
}
