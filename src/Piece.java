public class Piece {
    private boolean white;
    private boolean captured;
    private boolean canJump;
    private int postionX;//(1,2,3,4,5,6,7,8)
    private int postionY;//(a,b,c,d,e,f,g,h)

    //problemos with this
    public boolean move(Board b, int x, int y){
        return false;
    }

    //getter methods
    public boolean isWhite()
    {
        return white;
    }

    public boolean isCaptured() {
        return captured;
    }

    public int getPostionX() {
        return postionX;
    }

    public int getPostionY() {
        return postionY;
    }


}
