public class BoardTile {
    private boolean whiteSquare;
    private boolean occupied;//?
    private int postionX;//(1,2,3,4,5,6,7,8)
    private int postionY;//(a,b,c,d,e,f,g,h)
    private Piece piece;

    public BoardTile(int x, int y, boolean white, boolean occupied)
    {
        postionX = x;
        postionY = y;
        whiteSquare = white;
        this.occupied = occupied;
    }
    public BoardTile(Piece piece, int x, int y, boolean white, boolean occupied)
    {
        this.piece = piece;
        postionX = x;
        postionY = y;
        whiteSquare = white;
        this.occupied = occupied;
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
