package runner;
import pieces.*;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();

        b.fillBoard();
        b.assignBoard();//assigns all the pieces inside to b, so they can reference boardTiles.
        b.printBoard();
        //b.printTiles();
        System.out.println("rBL:" + b.getBoard()[0][0].getPiece().possibleMoves());//arraylist<boardTile>
        System.out.println("bBL:" + b.getBoard()[0][2].getPiece().possibleMoves());
        System.out.println("QB:" + b.getBoard()[0][3].getPiece().possibleMoves());
        System.out.println(b.getBoard()[0][2].getPiece().move(3,0));//bishop test

        //b.createFrame();
    }
}
