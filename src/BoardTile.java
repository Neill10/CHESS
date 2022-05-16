public class BoardTile {
    private boolean whiteSquare;
    private final int postionX;//(1,2,3,4,5,6,7,8)
    private final int postionY;//(a,b,c,d,e,f,g,h)
    private Piece piece;


    public BoardTile(int x, int y, boolean white)
    {
        postionX = x;
        postionY = y;
        whiteSquare = white;
    }
    public BoardTile(Piece piece, int x, int y, boolean white)
    {
        this.piece = piece;
        postionX = x;
        postionY = y;
        whiteSquare = white;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isWhiteSquare() {
        return whiteSquare;
    }

    public int getPostionX() {
        return postionX;
    }

    public int getPostionY() {
        return postionY;
    }

}
