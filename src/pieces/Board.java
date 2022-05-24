package pieces;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Board {
    private BoardTile[][] board;
    public static final int LEN = 8;
    private boolean turn;//true == white's move, false == black's move

    public Board()
    {
        board = new BoardTile[LEN][LEN];

        for(int i = 0; i < LEN; i++)
        {
            for(int y = 0 ; y < LEN ; y++)
            {
                if((i + y) % 2 == 0)
                {
                    board[i][y] = new BoardTile(i,y,true);
                }
                else
                {
                    board[i][y] = new BoardTile(i,y,false);
                }

            }
        }
        turn = true;
    }

    public void assignBoard()
    {
        for(int i = 0; i < LEN; i++)
        {
            for(int x = 0 ; x < LEN ; x++)
            {
                if(board[i][x].isOccupied())
                board[i][x].getPiece().setBoard(this);
            }
        }
    }

    public void fillBoard()
    {
        /*
        Piece Naming convention:
        piecetype + color + location(if more than one)
        Ex: White rook on the left side would be : rWL
         */
        //for testing
        //assigns empty boardtile spaces``
        for(int i = 0; i < LEN; i++)
        {
            for(int y = 0 ; y < LEN ; y++)
            {
                if((i + y) % 2 == 0)
                {
                    board[i][y] = new BoardTile(i,y,true);
                }
                else
                {
                    board[i][y] = new BoardTile(i,y,false);
                }

            }
        }

        //Queens
        /*
        Queen qW = new Queen(1,4,true);
        Queen qB = new Queen(8,4,false);

        board [0][3] = new BoardTile(qW,1,4,true);
        board [7][3] = new BoardTile(qB,8,4,false);
         */
        Queen qB = new Queen(0,3,false);
        Queen qW = new Queen(7,3,true);
        /////////////////////////////////////////////////////////point of change
        board [0][3].setPiece(qB);
        board [7][3].setPiece(qW);

        // Rooks
        /*
        Rook rWL = new Rook(1,1,true);
        Rook rWR = new Rook(1,8,true);
        Rook rBL = new Rook(8,1,true);
        Rook rBR = new Rook(8,8,true);
        board [0][0] = new BoardTile(rWL,1,1,true);
        board [0][7] = new BoardTile(rWR,1,8,true);
        board [7][0] = new BoardTile(rBL,8,1,true);
        board [7][7] = new BoardTile(rBR,8,8,true);
         */
        Rook rBL = new Rook(0,0,false);
        Rook rBR = new Rook(0,7,false);
        Rook rWL = new Rook(7,0,true);
        Rook rWR = new Rook(7,7,true);
        board [0][0].setPiece(rBL);
        board [0][7].setPiece(rBR);
        board [7][0].setPiece(rWL);
        board [7][7].setPiece(rWR);


        // Knights
        /*
        board [0][1] = "N";
        board [0][6] = "N";
        board [7][1] = "N";
        board [7][6] = "N";

         */
        Knight nBL = new Knight(0,1,false);
        Knight nBR = new Knight(0,6,false);
        Knight nWL = new Knight(7,1,true);
        Knight nWR = new Knight(7,6,true);
        board [0][1].setPiece(nBL);
        board [0][6].setPiece(nBR);
        board [7][1].setPiece(nWL);
        board [7][6].setPiece(nWR);
        /*

        //Bishops
        board [0][2] = "B";
        board [0][5] = "B";
        board [7][2] = "B";
        board [7][5] = "B";
        */

        Bishop bBL = new Bishop(0,2,false);
        Bishop bBR = new Bishop(0,5,false);
        Bishop bWL = new Bishop(7,2,true);
        Bishop bWR = new Bishop(7,5,true);

        board [0][2].setPiece(bBL);
        board [0][5].setPiece(bBR);
        board [7][2].setPiece(bWL);
        board [7][5].setPiece(bWR);

        /*
        //Kings
        board [0][4] = "K";
        board [7][4] = "K";
        */
        King kB = new King(0,4,false);
        King kW = new King(7,4,true);
        board [0][4].setPiece(kB);
        board [7][4].setPiece(kW);
        /*
        //Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "P";
            board[6][i] = "P";
        }
         */
        //pawns
        for(int i = 0; i < 8; i++)
        {
            Pawn pB = new Pawn(1,i,false);
            board[1][i].setPiece(pB);
            Pawn pW = new Pawn(6,i,true);
            board[6][i].setPiece(pW);
        }

    }
    public void printTiles()
    {
        System.out.println("-------------------------------");
        System.out.println("tiles with no pieces");

        for(int i = 0; i < LEN; i++)
        {
            for(int x = 0; x < LEN;x++)
            {
                if (board[i][x].isWhiteSquare())
                {
                    System.out.print(" W ");
                }
                else
                {
                    System.out.print(" B ");

                }
            }
            System.out.print("\n");
        }
    }
    public void printBoard()
    {
        System.out.println("Board with pieces");
        for(int i = 0; i < LEN; i++)
        {
            for(int x = 0; x < LEN;x++)
            {
                if(board[i][x].getPiece() != null)
                {
                    System.out.print(" " + board[i][x].getPiece().toString() + " ");//piece in boardTile in board
                }
                else {
                    if (board[i][x].isWhiteSquare())
                    {
                        System.out.print(" W  ");
                    }
                    else
                    {
                        System.out.print(" B  ");

                    }

                }

            }
            System.out.print("\n");
        }
    }
    public void createFrame(){
        JFrame f = new JFrame("Board");
        /*
        final JTextField tf= new JTextField();
        tf.setBounds(50,50, 150,20);

        JButton b = new JButton("Click Here");
        b.setBounds(50,100,95,30);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to Javatpoint.");
            }
        });
        f.add(b);
        f.add(tf);
         */
        int x = 10;
        int y = 10;
        for(int i = 0; i < LEN ; i++) {

            for(int a = 0 ; a < LEN;a++) {
                JButton button = board[a][i].createTileButton();
                button.setBounds(x,y,80,80);
                f.add(button);
                y += 80;
            }
            x += 80;
            y = 10;
        }


        /*
        JButton button = board[0][0].createTileButton();
        button.setBounds(50,100,95,30);
        f.add(button);

        try {
            Image img = ImageIO.read(new File("src/Assets/blackSquare.png"));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

         */
        f.setSize(700,700);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void setTurn(boolean turn)
    {
       this. turn = turn;
    }

    public void setDeselect()
    {
        for(BoardTile[] tiles : board)
        {
            for(BoardTile tile : tiles)
            {
                tile.setSelected(false);
            }
        }
    }

    public boolean getTurn()
    {
        return turn;
    }

    public BoardTile[][] getBoard() {
        return board;
    }


}
