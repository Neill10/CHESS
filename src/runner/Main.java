package runner;
import pieces.*;

public class Main {

    public static void main(String[] args) {
        Board b = new Board();

        b.fillBoard();
        b.assignBoard();
        b.printBoard();
        b.printTiles();
        System.out.println(b.getBoard()[0][0].getPiece().possibleMoves());
        b.createFrame();
    }
}
