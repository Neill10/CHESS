package pieces;
import Saver.Saver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.time.Period;
import java.util.ArrayList;

public class Board implements Serializable {
    private BoardTile[][] board;
    public static final int LEN = 8;
    private boolean playerTurn;
    private ArrayList<Piece> playerTeam;
    //true == white's move, false == black's move
    private Piece selectedPiece;//piece that moving
    private BoardTile selectedTile;//boardtile that is being moved to
    public static final JFrame FRAME = new JFrame();
    private ArrayList<Piece> whiteP;
    private ArrayList<Piece> blackP;
    private String saveFile;

    public Board(String fileName)
    {
        saveFile = fileName;
        playerTurn = true;
        blackP = new ArrayList<Piece>();
        whiteP = new ArrayList<Piece>();
        fillBoard();
    }

    //assigns all piece's board object to this board object
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
        System.out.println("assign board ran");
    }

    //sets a default board
    public void fillBoard()
    {
        playerTurn = true;
        FRAME.getContentPane().removeAll();
        Board.FRAME.invalidate();
        Board.FRAME.validate();
        Board.FRAME.repaint();

        board = new BoardTile[LEN][LEN];

        //assigns all boardTile's board variable to this board
        for (int i = 0; i < LEN; i++) {
            for (int y = 0; y < LEN; y++) {
                if ((i + y) % 2 == 0) {
                    board[i][y] = new BoardTile(i, y, true);
                    board[i][y].setAssociatedBoard(Board.this);
                } else {
                    board[i][y] = new BoardTile(i, y, false);
                    board[i][y].setAssociatedBoard(Board.this);
                }

            }
        }
        standardSetUp();
        assignBoard();
        createFrame();
        System.out.println("fill board ran");
        Board.FRAME.invalidate();
        Board.FRAME.validate();
        Board.FRAME.repaint();
    }

    public void standardSetUp()
    {
        //Queens
        Queen qB = new Queen(0,3,false);
        Queen qW = new Queen(7,3,true);
        board [0][3].setPiece(qB);
        board [7][3].setPiece(qW);

        // Rooks
        Rook rBL = new Rook(0,0,false);
        Rook rBR = new Rook(0,7,false);
        Rook rWL = new Rook(7,0,true);
        Rook rWR = new Rook(7,7,true);
        board [0][0].setPiece(rBL);
        board [0][7].setPiece(rBR);
        board [7][0].setPiece(rWL);
        board [7][7].setPiece(rWR);

        // Knights
        Knight nBL = new Knight(0,1,false);
        Knight nBR = new Knight(0,6,false);
        Knight nWL = new Knight(7,1,true);
        Knight nWR = new Knight(7,6,true);
        board [0][1].setPiece(nBL);
        board [0][6].setPiece(nBR);
        board [7][1].setPiece(nWL);
        board [7][6].setPiece(nWR);

        //Bishops
        Bishop bBL = new Bishop(0,2,false);
        Bishop bBR = new Bishop(0,5,false);
        Bishop bWL = new Bishop(7,2,true);
        Bishop bWR = new Bishop(7,5,true);
        board [0][2].setPiece(bBL);
        board [0][5].setPiece(bBR);
        board [7][2].setPiece(bWL);
        board [7][5].setPiece(bWR);

        //Kings
        King kB = new King(0,4,false);
        King kW = new King(7,4,true);
        board [0][4].setPiece(kB);
        board [7][4].setPiece(kW);

        //Pawns
        for(int i = 0; i < 8; i++)
        {
            Pawn pB = new Pawn(1,i,false);
            board[1][i].setPiece(pB);
            Pawn pW = new Pawn(6,i,true);
            board[6][i].setPiece(pW);
        }

        blackP = new ArrayList<Piece>();
        blackP.add(nBL);
        blackP.add(nBR);
        blackP.add(rBL);
        blackP.add(rBR);
        blackP.add(kB);
        blackP.add(qB);
        blackP.add(bBL);
        blackP.add(bBR);
        for(int i = 0; i < board[1].length;i++)
        {
            blackP.add(board[1][i].getPiece());
        }
        whiteP = new ArrayList<Piece>();
        whiteP.add(nWL);
        whiteP.add(nWR);
        whiteP.add(rWL);
        whiteP.add(rWR);
        whiteP.add(kW);
        whiteP.add(qW);
        whiteP.add(bWL);
        whiteP.add(bWR);
        for(int i = 0; i < board[6].length;i++)
        {
            whiteP.add(board[6][i].getPiece());
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

    public void createFrame()
    {
        //prompts user to choose a team
        JDialog jd = new JDialog(FRAME);
        jd.setLayout(new FlowLayout());
        jd.setBounds(500, 300, 100, 150);

        JLabel jLabel = new JLabel("Pick a Team");
        JButton black = new JButton("Black");
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayerTeam(blackP);
                jd.setVisible(false);
                System.out.println("You have selected black Team");
                SAMbot();
                FRAME.repaint();
            }
        });
        JButton white = new JButton("White");
        white.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlayerTeam(whiteP);
                jd.setVisible(false);
                System.out.println("You have selected White team");

            }
        });

        jd.add(jLabel);
        jd.add(black);
        jd.add(white);
        jd.setVisible(true);

        int x = 10;
        int y = 10;
        for(int i = 0; i < LEN ; i++) {

            for(int a = 0 ; a < LEN;a++) {
                JButton button = board[a][i].createTileButton();
                button.setBounds(x,y,80,80);
                FRAME.add(button);
                y += 80;
            }
            x += 80;
            y = 10;
        }
        //JOptionPane.showMessageDialog(FRAME,pickTeam);
        FRAME.add(resetGameButton());
        FRAME.setSize(800,700);
        FRAME.setResizable(false);
        FRAME.setLayout(null);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        FRAME.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                //saving class here
                Saver.saveToFile(Board.this,getSaveFile());
                //and then dispose frame
                FRAME.dispose();
            }
        });

    }

    public JButton resetGameButton()
    {
        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(675,25,100,50);
        resetButton.addActionListener((ActionEvent e) ->  {
            fillBoard();
        });
        /*
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillBoard();
                assignBoard();
                System.out.println("Board reset");
                FRAME.invalidate();
                FRAME.revalidate();
                FRAME.repaint();
            }
        });

         */
        return resetButton;
    }

    public boolean alive(ArrayList<Piece> pieces)
    {
        boolean alive = false;
        for(Piece p : pieces)
        {
            if(p.getPieceName().equals("king"))
            {
                alive = true;
                break;
            }
        }
        return alive;
    }


    public void setPlayerTeam(ArrayList<Piece> playerTeam) {
        this.playerTeam = playerTeam;
    }

    public ArrayList<Piece> getPlayerTeam() {
        return playerTeam;
    }

    public ArrayList<Piece> enemyTeam()
    {
        if(playerTeam.equals(whiteP))
        {
            return blackP;
        }
        else
        {
            return whiteP;
        }
    }

    /*
    public void setPlayerTeam(boolean playerTeam) {
        this.playerTeam = playerTeam;
    }

    public boolean isPlayerTeam() {
        return playerTeam;
    }

     */

    public void setPlayerTurn(boolean playerTurn)
    {
       this. playerTurn = playerTurn;
    }

    public void setSelectedAll(boolean selected)
    {
        for(BoardTile[] tiles : board)
        {
            for(BoardTile tile : tiles)
            {
                tile.setSelected(selected);
            }
        }
    }

    //the bot moves by using the Super Advanced Movement algorithm (aka S.A.M)
    public void SAMbot()
    {
        //this algorithm gets a random piece from the bot's team, and picks a random move the piece can move

        //picks a random piece from bot pieces
        int i = (int) (Math.random() * blackP.size());
        //i = (int) Math.random() * blackP.size();
        Piece randomP = whiteP.get(i);
        if(playerTeam.equals(whiteP)) {
            randomP = blackP.get(i);
        }

        //will only move piece that can move
        while(randomP.possibleMoves().size() == 0)
        {
            i = (int) (Math.random() * blackP.size());
            System.out.println(i);
            randomP = blackP.get(i);
            System.out.println(randomP);
        }

        //finds the boardTile connected to the random piece
        JLabel randomPieceLabel = new JLabel();
        for(BoardTile[] tiles : board)
        {
            for(BoardTile tile : tiles)
            {
                if(tile.isOccupied() && tile.getPiece().equals(randomP))
                {
                    randomPieceLabel = tile.getjLabel();
                    System.out.println(randomPieceLabel);
                    tile.removeAll();
                }
            }
        }

        //finds a random move of the random Piece
        ArrayList<BoardTile> randomMoves = randomP.possibleMoves();
        i = (int)(Math.random() * randomMoves.size());
        BoardTile newTile = randomMoves.get(i);
        //removes jlabel at location and adds moved piece jLabel to new tile
        newTile.removeJLabel();

        System.out.println(newTile + " bruhhhhhh");
        randomP.move(newTile.getPOSITIONX(),newTile.getPOSITIONY());

        newTile.setjLabel(randomPieceLabel);
        newTile.add(randomPieceLabel);


        System.out.println(whiteP);
        System.out.println(blackP);
        System.out.println(randomP + "moved to " + newTile.getPOSITIONX() +", " + newTile.getPOSITIONY());
    }

    public ArrayList<Piece> getBlackP() {
        return blackP;
    }

    public ArrayList<Piece> getWhiteP() {
        return whiteP;
    }

    public void setSelectedPiece(Piece selectedPiece) {
        this.selectedPiece = selectedPiece;
    }

    public Piece getSelectedPiece() {
        return selectedPiece;
    }

    public void setSelectedTile(BoardTile selectedTile) {
        this.selectedTile = selectedTile;
    }

    public String getSaveFile() {
        return saveFile;
    }

    public BoardTile getSelectedTile() {
        return selectedTile;
    }

    public boolean isPlayerTurn()
    {
        return playerTurn;
    }

    public BoardTile[][] getBoard() {
        return board;
    }
}
