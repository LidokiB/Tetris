package com.example.mino;

import java.awt.Color;
import java.awt.Graphics2D;

import com.example.main.KeyHandler;
import com.example.main.PlayManager;

public class Mino {
    public Block b[] = new Block[4];
    public Block temp[] = new Block[4];
    public int autoDropCounter = 0;
    public int direction = 1; // There are four directions (1/2/3/4)
    public boolean leftCollision, rightCollision, bottomCollision;
    public boolean active = true;

    public void create(Color c) {
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        temp[0] = new Block(c);
        temp[1] = new Block(c);
        temp[2] = new Block(c);
        temp[3] = new Block(c);
    }

    public void setXY(int x, int y) {
    }

    public void updateXY(int direction) {

        checkRotationCollision();

        if (!leftCollision && !rightCollision && !bottomCollision) {
            this.direction = direction;

            b[0].x = temp[0].x;
            b[0].y = temp[0].y;
            b[1].x = temp[1].x;
            b[1].y = temp[1].y;
            b[2].x = temp[2].x;
            b[2].y = temp[2].y;
            b[3].x = temp[3].x;
            b[3].y = temp[3].y;
        }
    }

    public void getDirection1() {
    }

    public void getDirection2() {
    }

    public void getDirection3() {
    }

    public void getDirection4() {
    }

    public void checkMovementCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check Frame collision
        // Left wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].x == PlayManager.left_x)
                leftCollision = true;
        }

        // Right wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].x + Block.SIZE == PlayManager.right_x)
                rightCollision = true;
        }

        // Bottom wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].y + Block.SIZE == PlayManager.top_y)
                bottomCollision = true;
        }
    }

    public void checkRotationCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check Frame collision
        // Left wall
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].x < PlayManager.left_x)
                leftCollision = true;
        }

        // Right wall
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].x + Block.SIZE > PlayManager.right_x)
                rightCollision = true;
        }

        // Bottom wall
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].y + Block.SIZE > PlayManager.top_y)
                bottomCollision = true;
        }

    }

    public void update() {

        // Move the mino
        if (KeyHandler.upPressed) {

            // controls the rotation

            switch (direction) {
                case 1:
                    getDirection2();
                    break;
                case 2:
                    getDirection3();
                    break;
                case 3:
                    getDirection4();
                    break;
                case 4:
                    getDirection1();
                    break;
            }

            KeyHandler.upPressed = false;
        }

        checkMovementCollision();

        if (KeyHandler.downPressed) {
            // if the Mino is not touching the bottom, it can go down
            if (!bottomCollision) {
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;

                // When moved down, reset the autoDropCounter
                autoDropCounter = 0;
            }

            KeyHandler.downPressed = false;
        }
        if (KeyHandler.leftPressed) {
            // if the Mino is not touching the left wall, it can go down
            if (!leftCollision) {
                b[0].x -= Block.SIZE;
                b[1].x -= Block.SIZE;
                b[2].x -= Block.SIZE;
                b[3].x -= Block.SIZE;
            }

            KeyHandler.leftPressed = false;
        }
        if (KeyHandler.rightPressed) {
            // if the Mino is not touching the right wall, it can go down
            if (!rightCollision) {
                b[0].x += Block.SIZE;
                b[1].x += Block.SIZE;
                b[2].x += Block.SIZE;
                b[3].x += Block.SIZE;
            }

            KeyHandler.rightPressed = false;
        }

        if (bottomCollision)
            active = false;
        else {
            autoDropCounter++; // the counter increases every frame
            if (autoDropCounter == PlayManager.dropInterval) {
                // the mino goes down
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;
                autoDropCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        int margin = 1;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x + margin, b[0].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[1].x + margin, b[1].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[2].x + margin, b[2].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[3].x + margin, b[3].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    }

}
