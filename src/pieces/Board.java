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

    public Board()//creates a new board
    {
        board = new BoardTile[LEN][LEN];

        for(int i = 0; i < LEN;i++)
        {
            for (int x = 0; x < LEN;x++)
            {
                if(x % 2 == 1)
                {
                    board[i][x] = new BoardTile(i+1,x+1,true);
                }
                else {
                    board[i][x] = new BoardTile(i+1,x+1,false);
                }
            }
        }
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
        //assigns empty boardtile spaces
        for(int i = 0; i < LEN; i++)
        {
            for(int y = 0 ; y < LEN ; y++)
            {
                if((i + y) % 2 == 0)
                {
                    board[i][y] = new BoardTile(i,y,false);
                }
                else
                {
                    board[i][y] = new BoardTile(i,y,true);
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
        Queen qW = new Queen(8,4,true);

        board [0][3] = new BoardTile(qB,0,3,true);
        board [7][3] = new BoardTile(qW,7,3,false);


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
        board [0][0] = new BoardTile(rBL,0,0,false);
        board [0][7] = new BoardTile(rBR,0,7,true);
        board [7][0] = new BoardTile(rWL,7,0,true);
        board [7][7] = new BoardTile(rWR,7,7,false);

        /*
        // Knights
        board [0][1] = "N";
        board [0][6] = "N";
        board [7][1] = "N";
        board [7][6] = "N";

        //Bishops
        board [0][2] = "B";
        board [0][5] = "B";
        board [7][2] = "B";
        board [7][5] = "B";

        //Kings
        board [0][4] = "K";
        board [7][4] = "K";


        //Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = "P";
            board[6][i] = "P";
        }

         */

    }
    public void printBoard()
    {
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
                        System.out.print(" WX ");
                    }
                    else
                    {
                        System.out.print(" BX ");

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
        JButton button = board[0][0].createTileButton();
        button.setBounds(50,100,95,30);
        f.add(button);

        try {
            Image img = ImageIO.read(new File("src/Assets/blackSquare.png"));
            button.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        /*
        File image = new File("src/Assets/blackSquare.png\"");
        try {
            ImageIO.read(image);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

         */
        //f.setIconImage();
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public BoardTile[][] getBoard() {
        return board;
    }


}
