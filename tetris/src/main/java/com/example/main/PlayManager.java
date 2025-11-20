package com.example.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import com.example.mino.Block;
import com.example.mino.Mino;
import com.example.mino.Mino_Bar;
import com.example.mino.Mino_L1;
import com.example.mino.Mino_L2;
import com.example.mino.Mino_Square;
import com.example.mino.Mino_T;
import com.example.mino.Mino_Z1;
import com.example.mino.Mino_Z2;

import java.awt.Font;

public class PlayManager {

    // Main Play Area
    // We declare 1 block = 30px -> 12 blocks horizontally / 20 blocks vertically
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    // the top and bottom is reversed the screen start to the most up left position
    // and goes down and right
    // a greater value in the y axis means lower on the screen
    public static int top_y;
    public static int bottom_y;

    // Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    // Others
    public static int dropInterval = 60; // mino drops in every 60 frames

    public PlayManager() {
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2); // 1280/2 - 360/2 = 460
        right_x = left_x + WIDTH; // 460 + 360 = 820
        bottom_y = 50;
        top_y = bottom_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
        MINO_START_Y = bottom_y + Block.SIZE;

        // Set the starting Mino
        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    private Mino pickMino() {

        // Pick a random Mino
        Mino mino = null;
        int i = new Random().nextInt(7);

        switch (i) {
            case 0:
                mino = new Mino_Bar();
                break;
            case 1:
                mino = new Mino_L1();
                break;
            case 2:
                mino = new Mino_L2();
                break;
            case 3:
                mino = new Mino_Square();
                break;
            case 4:
                mino = new Mino_T();
                break;
            case 5:
                mino = new Mino_Z1();
                break;
            case 6:
                mino = new Mino_Z2();
                break;
        }

        return mino;
    }

    public void update() {
        currentMino.update();
    }

    public void draw(Graphics2D g2) {

        // Draw Play Area Frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, bottom_y - 4, WIDTH + 8, HEIGHT + 8);

        // Draw new Mino Frame
        int x = right_x + 100;
        int y = top_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT", x + 60, y + 60);

        // Draw the currentMino
        if (currentMino != null) {
            currentMino.draw(g2);
        }
    }

}
