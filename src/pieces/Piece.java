package pieces;

import java.util.*;
public abstract class Piece {
    private boolean white;
    private int positionX;//(a,b,c,d,e,f,g,h)(ROW)
    private int positionY;//(1,2,3,4,5,6,7,8)(COL)
    private String pieceName;
    private ArrayList<BoardTile> possibleMoves;
    private Board board;//associated board

    public Piece(String pieceName, int x, int y,boolean white)
    {
        this.pieceName = pieceName;
        positionX = x;
        positionY = y;
        this.white = white;
        possibleMoves = new ArrayList<BoardTile>();
    }

    //public abstract boolean move(int x, int y);//returns if piece successfully moved
    public boolean move(int x, int y) {
        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                return true;
            }
        }
        return false;
    }
    public abstract ArrayList<BoardTile> possibleMoves();

    public void setBoard(Board board) {
        this.board = board;
    }

    //getter methods
    public boolean isWhite()
    {
        return white;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String toString()
    {

        if(white)
        {
            return "W";
        }
        else
        {
            return "B";
        }
    }

    public Board getAssociatedBoard() {
        return board;
    }

    public void setPossibleMoves(ArrayList<BoardTile> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public ArrayList<BoardTile> getPossibleMoves()
    {
        return possibleMoves;
    }

}
