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
        if(selected)
        {

        }
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
                tile.add(new JLabel(new ImageIcon("src/Assets/"+ pieceName + "White.png")));
            }
            else
            {
                tile.add(new JLabel(new ImageIcon("src/Assets/"+ pieceName + "Black.png")));
            }
        }
        tile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(isOccupied() );
            }
        });
        if((getPOSITIONX() + getPOSITIONY()) % 2 == 0) {
            try {
                Image img = ImageIO.read(new File("src/Assets/whiteSquare.png"));
                tile.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("no whiteSquare file found");
            }
        }
        else
        {
            //black tiles is basically vietnam for white pieces (also the user)

            try {
                Image img = ImageIO.read(new File("src/Assets/greenSquare.png"));
                tile.setIcon(new ImageIcon(img));
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
