public class BoardTile {
    private boolean whiteSquare;
    private boolean occupied;
    private int postionX;//(1,2,3,4,5,6,7,8)
    private int postionY;//(a,b,c,d,e,f,g,h)

    public boolean isOccupied() {
        return occupied;
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
