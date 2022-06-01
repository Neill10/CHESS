package pieces;



import java.util.*;
public class Queen extends Piece {

    public Queen(int x, int y,boolean white)
    {
        super("queen",x,y,white);
    }

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        //creates a temp bishop and rook piece at the location of queen and just adds their possible moves to the queenpossible moves

        ArrayList<BoardTile> bishopPossibleMoves = new ArrayList<BoardTile>();
        Bishop b = new Bishop(getPositionX(),getPositionY(),isWhite());//this might cause some problems when checking if a boardTile is empty.
        b.setBoard(getAssociatedBoard());
        bishopPossibleMoves = b.possibleMoves();



        ArrayList<BoardTile> rookPossibleMoves = new ArrayList<BoardTile>();
        Rook r = new Rook(getPositionX(),getPositionY(),isWhite());
        //System.out.println(getPositionX());
        //System.out.println(getPositionY());



        r.setBoard(getAssociatedBoard());
        rookPossibleMoves = r.possibleMoves();

        ArrayList<BoardTile> queenPossibleMoves = new ArrayList<BoardTile>();
        for(BoardTile tile : bishopPossibleMoves)
        {
            queenPossibleMoves.add(tile);
        }
        for(BoardTile tile : rookPossibleMoves)
        {
            queenPossibleMoves.add(tile);
        }
        setPossibleMoves(queenPossibleMoves);
        return queenPossibleMoves;
    }


    @Override
    public String toString()
    {
        return super.toString() + "Q";
    }
}
