package Tester;

import javax.swing.*;
import java.awt.*;

public class JFrameTest {
    /*
    public pieces.BoardTile[][] board;
    public final int SIZE = 8;

    board = new pieces.BoardTile[SIZE][SIZE];
    for (int row = 0; row < SIZE; row++) {
        for (int column = 0; column < SIZE; column++) {
            board[row][column] = new boardTile();
            boardPanel.add(board[row][column]);
        }
    }

     */
    public static void main(String[] args){
        JFrameTest test = new JFrameTest();
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create JFrame Example");
        frame.setVisible(true);
        JPanel sample = test.createFilePanel();
        sample.setVisible(true);
        frame.add(sample);
        sample.setSize(100,100);
    }

    public JPanel createFilePanel() {
        JPanel filePanel = new JPanel(new GridLayout(1, 0));
        for (int i = 0; i < 8; i++) {
            char fileChar = (char) ('A' + i);
            filePanel.add(new JLabel(String.valueOf(fileChar), SwingConstants.CENTER));
        }
        return filePanel;
    }
    public JPanel createRankPanel() {
        JPanel rankPanel = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 8; i++) {
            int row = 8 - i;
            rankPanel.add(new JLabel(String.valueOf(row)));
        }
        return rankPanel;
    }

}