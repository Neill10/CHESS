package runner;
import pieces.*;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/saver1.txt";
        Board b = new Board(fileName);
        b.printBoard();
        System.out.println(b.getSave());

        fileName = "src/saver2.txt";
        Board b2 = new Board(fileName);

        b2.printBoard();
        System.out.println(b.getSave());

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
        //System.out.println(b.getBoard()[1][0].getPiece().move(3,0));//pawn test (THIS WAS DUPLICATING PIECES!!! resolved by setting piece to null)
        //b.getBoard()[1][0].setPiece(null);//removes pawn
        /*
        Piece rook = b.getBoard()[0][0].getPiece();
        rook.move(6,0);
         */
    }
}
