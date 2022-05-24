package runner;
import pieces.*;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();

        b.fillBoard();
        b.assignBoard();//assigns all the pieces inside to b, so they can reference boardTiles.
        b.printBoard();
        //b.printTiles();
        /*
        System.out.println("rBL:" + b.getBoard()[0][0].getPiece().possibleMoves());//arraylist<boardTile>
        System.out.println("rWL:" + b.getBoard()[7][0].getPiece().possibleMoves());
        System.out.println("bBL:" + b.getBoard()[0][2].getPiece().possibleMoves());
        System.out.println("qB:" + b.getBoard()[0][3].getPiece().possibleMoves());
        System.out.println("nBL" + b.getBoard()[0][1].getPiece().possibleMoves());
        System.out.println("nWL" + b.getBoard()[7][1].getPiece().possibleMoves());
        System.out.println("kBL" + b.getBoard()[0][4].getPiece().possibleMoves());
        System.out.println("kWL" + b.getBoard()[7][4].getPiece().possibleMoves());
        System.out.println("P10:" + b.getBoard()[1][0].getPiece().possibleMoves());
        System.out.println(b.getBoard()[1][0].getPiece().move(3,0));//pawn test (THIS WAS DUPLICATING PIECES!!! resolved by setting piece to null)
        System.out.println(b.getBoard()[1][0].isOccupied());
        
         */
        b.createFrame();
    }
}
