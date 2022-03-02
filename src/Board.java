public class Board {
    private String knight;
    private String king;
    private String queen;
    private String bishop;
    private String pawn;
    private String rook;

    private String[][] board = {
            {rook,knight,bishop,king,queen,bishop,knight,rook},
            {pawn,pawn,pawn,pawn,pawn,pawn,pawn,pawn},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {" "," "," "," "," "," "," "," "},
            {pawn,pawn,pawn,pawn,pawn,pawn,pawn,pawn},
            {rook,knight,bishop,king,queen,bishop,knight,rook}
    };
}
