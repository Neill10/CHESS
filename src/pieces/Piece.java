package pieces;

import javax.swing.*;
import java.io.File;
import java.io.*;
import java.util.*;
public abstract class Piece implements Serializable {
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

    //public abstract? void move(int x, int y);//returns if piece successfully moved
    public void move(int x, int y) {
        possibleMoves = possibleMoves();
        for(BoardTile tile : getPossibleMoves())
        {
            if(tile.getPOSITIONX() == x && tile.getPOSITIONY() == y)
            {
                BoardTile[][] b = board.getBoard();
                b[getPositionX()][getPositionY()].setPiece(null);

                if(b[x][y].isOccupied()) {
                    getEnemyTeam().remove(b[x][y].getPiece());
                }

                b[x][y].setPiece(this);//replacing any pieces at new location
                b[x][y].getPiece().setPositionX(x);
                b[x][y].getPiece().setPositionY(y);
                board.setSelectedAll(false);
                //future implementation should try to add saving moves
                //board.getSave().writeToFile();

                System.out.println("piece moved");
            }
        }
    }

    public ArrayList<Piece> getTeam()
    {
        if(isWhite()) {
            return getAssociatedBoard().getWhiteP();
        }
        else
        {
            return getAssociatedBoard().getBlackP();
        }

    }

    public ArrayList<Piece> getEnemyTeam()
    {
        if(isWhite()) {
            return getAssociatedBoard().getBlackP();
        }
        else
        {
            return getAssociatedBoard().getWhiteP();
        }
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

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean inBounds(int num)
    {
        return num >= 0 && num < 8;
    }

    public Board getAssociatedBoard() {
        return board;
    }

    public String getPieceName()
    {
        return pieceName;
    }

    public void setPossibleMoves(ArrayList<BoardTile> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public ArrayList<BoardTile> getPossibleMoves()
    {
        return possibleMoves;
    }

    public Icon getIcon()
    {
        if(isWhite())
        {
            return new ImageIcon("src/Assets/" + getPieceName() + "White.png");
        }
        else
        {
            return new ImageIcon("src/Assets/" + getPieceName() + "Black.png");
        }
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
}
