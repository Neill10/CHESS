package pieces;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class BoardTile extends JButton {
    private boolean whiteSquare;
    private final int POSITIONX;//(1,2,3,4,5,6,7,8)
    private final int POSITIONY;//(a,b,c,d,e,f,g,h)
    private Piece piece;
    private boolean selected;//changes functionality of possible tiles of a piece.
    private JLabel jLabel;
    private Icon icon;



    public BoardTile(int x, int y, boolean white)
    {
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
        selected = false;
    }
    public BoardTile(Piece piece, int x, int y, boolean white)
    {
        this.piece = piece;
        POSITIONX = x;
        POSITIONY = y;
        whiteSquare = white;
        selected = false;
    }

    public void selectedPiece()//should  refer to the board from piece unless i want to have a board variable in this class
    {
        Board b = piece.getAssociatedBoard();

        b.setDeselect();//sets all boardTiles to deselected
        ArrayList<BoardTile> moves = piece.possibleMoves();
        for (BoardTile tilePossible : moves) {
            System.out.print(tilePossible);
            tilePossible.setSelected(true);
            tilePossible.setBackground(Color.BLUE);
            //tilePossible.setIcon(new ImageIcon("src/Assets/blackSquare.png"));//icon not setting???
        }

    }

    public void setSelected(boolean select)
    {
        selected = select;
    }

    public void setPossibleMoves()
    {
        piece.possibleMoves();
    }

    public JButton createTileButton()
    {
        JButton tile = new JButton();
        if(isOccupied()) {
            String pieceName = piece.getPieceName();
            boolean pieceColor = piece.isWhite();
            if(pieceColor)
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "White.png"));
                tile.add(jLabel);
            }
            else
            {
                jLabel = new JLabel(new ImageIcon("src/Assets/"+ pieceName + "Black.png"));
                tile.add(jLabel);
            }
        }
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isOccupied())
                {
                    //tile.remove(jLabel);
                    selectedPiece();
                    System.out.println("bruh");
                }
                else
                {
                    System.out.print("no piece at :");
                    System.out.println("(" + POSITIONX + "," + POSITIONY +")");
                }
            }
        });
        if((getPOSITIONX() + getPOSITIONY()) % 2 == 0) {
            try {
                icon = new ImageIcon("src/Assets/whiteSquare.png");
                tile.setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no whiteSquare file found");
            }
        }
        else
        {
            //black tiles is basically vietnam for white pieces (also the user)

            try {
                icon = new ImageIcon("src/Assets/greenSquare.png");
                tile.setIcon(icon);
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no greenSquare file found");
            }


            /*
            try {
                Image img = ImageIO.read(new File("src/Assets/blackSquare.png"));
                tile.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no blackSquare file found");
            }
             */


        }
        //tile.setRolloverEnabled(true);
        //setOverLay(tile);
        tile.setVisible(true);
        return tile;
    }


    public void setOverLay(JButton b)
    {
        if(isOccupied())
        {
            b.setIcon(piece.getIcon());
            //System.out.println("TILE ICON SET");
        }
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

    public boolean getSelected()
    {
        return selected;
    }

    public boolean isWhiteSquare() {
        return whiteSquare;
    }

    public int getPOSITIONX() {
        return POSITIONX;
    }

    public int getPOSITIONY() {
        return POSITIONY;
    }

    public String toString()
    {
        return "(" + POSITIONX +"," + POSITIONY + ")";
    }


}
