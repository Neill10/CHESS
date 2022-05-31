package pieces;



import java.util.*;
public class King extends Piece {
    private boolean check;
    private boolean firstMove;
    public King(int x, int y,boolean white)
    {
        super("king",x,y,white);
        firstMove = true;
    }

    @Override
    public void move(int x, int y) {
        setFirstMove(false);
        super.move(x, y);
    }

    @Override
    public ArrayList<BoardTile> possibleMoves() {
        ArrayList<BoardTile> kingPossibleMoves = new ArrayList<BoardTile>();
        int[][] offsets = {
                {1, 0},//bot
                {0, 1},//right
                {-1, 0},//up
                {0, -1},//left
                {1, 1},//bot right
                {-1, 1},//top right
                {-1, -1},//top left
                {1, -1}//bot left
        };
        for (int[] o : offsets) {
            if(inBounds(o[0] + getPositionX()) && inBounds(o[1] + getPositionY())) {
                BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                    kingPossibleMoves.add(currentTile);
                } else if (!currentTile.isOccupied()) {
                    kingPossibleMoves.add(currentTile);
                }
            }
        }
        kingPossibleMoves = removeEnemyCheckTiles(kingPossibleMoves);
        return kingPossibleMoves;
    }

    public ArrayList<BoardTile> removeEnemyCheckTiles(ArrayList<BoardTile> kingPossibleMoves) {
        //need to remove piece after king captures and need to re-evaluate how possible piece is moved. also need to fix pawn captures
        if(getPieceName().equals("king") && getAssociatedBoard().isWhiteTurn() != isWhite())//stops a recursive method from happening
        {
            ArrayList<BoardTile> king = new ArrayList<BoardTile>();
            int[][] offsets = {
                    {1, 0},//bot
                    {0, 1},//right
                    {-1, 0},//up
                    {0, -1},//left
                    {1, 1},//bot right
                    {-1, 1},//top right
                    {-1, -1},//top left
                    {1, -1}//bot left
            };
            for (int[] o : offsets) {
                if(inBounds(o[0] + getPositionX()) && inBounds(o[1] + getPositionY())) {
                    BoardTile currentTile = getAssociatedBoard().getBoard()[o[0] + getPositionX()][o[1] + getPositionY()];
                    if (currentTile.isOccupied() && isWhite() != currentTile.getPiece().isWhite()) {
                        king.add(currentTile);
                    } else if (!currentTile.isOccupied()) {
                        king.add(currentTile);
                    }
                }
            }
            for(int x = 0; x < king.size();x++)
            {
                for (int p = 0; p < kingPossibleMoves.size(); p++) {
                    if (king.get(x).equals(kingPossibleMoves.get(p))) {
                        kingPossibleMoves.remove(p);//removes from king possible moves
                        p--;
                        break;
                    }

                }
            }
            /*
            for (int x = 0; x < kingPossibleMoves.size(); x++) {
                for (int p = 0; p < king.size(); p++) {
                    if (king.get(p).equals(kingPossibleMoves.get(x))) {
                        kingPossibleMoves.remove(x);//removes from king possible moves
                    }

                }
            }

             */
        }
        else {
            ArrayList<BoardTile> enemyPieceCheck = new ArrayList<BoardTile>();
            ArrayList<Piece> enemyPieces = getEnemyTeam();

            for (int i = 0; i < enemyPieces.size(); i++) {
                //accidental recursive method. call other kings possibleMoves which will then call this method,calling this kings method and so on
                ArrayList<BoardTile> pieceMoves = enemyPieces.get(i).possibleMoves();
                System.out.println(enemyPieces.get(i) +"   "+ pieceMoves);

                for (int x = 0; x < pieceMoves.size(); x++) {
                    for (int p = 0; p < kingPossibleMoves.size(); p++) {
                        if (pieceMoves.get(x).equals(kingPossibleMoves.get(p))) {
                            kingPossibleMoves.remove(p);//removes from king possible moves
                            p--;
                            break;
                        }
                    }
                }
            }
        }
        /*
        for(int i = 0; i < enemyPieces.size();i++)
        {

            ArrayList<BoardTile> pieceMoves = enemyPieces.get(i).possibleMoves();
            for(int x = 0; x < pieceMoves.size(); x++)
            {
                for(int z = 0; z < enemyPieceCheck.size();z++)
                {
                    //if(enemyPieceCheck.get(z).equals())
                }
            }
            enemyPieceCheck.addAll(pieceMoves);
        }
        System.out.println(enemyPieceCheck);
        for (int i = 0; i < kingPossibleMoves.size();i++)
        {
            for(int x = 0; x < enemyPieceCheck.size();x++)
            {
                if(enemyPieceCheck.get(x).equals(kingPossibleMoves.get(i)))
                {
                    System.out.println("tile removed");
                    kingPossibleMoves.remove(i);
                    i--;
                    break;
                }
            }
        }

         */
        return kingPossibleMoves;

    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }
    @Override
    public String toString()
    {
        return super.toString() + "K";
    }
}
