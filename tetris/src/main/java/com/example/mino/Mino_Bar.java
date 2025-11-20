package com.example.mino;

import java.awt.Color;

public class Mino_Bar extends Mino {

    public Mino_Bar() {
        create(Color.cyan);
    }

    public void setXY(int x, int y) {

        // o
        // o
        // o
        // o

        // b1
        // b0
        // b2
        // b3

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x;
        b[3].y = b[0].y + 2 * Block.SIZE;
    }

    public void getDirection1() {
        // o
        // o
        // o
        // o

        // b1
        // b0
        // b2
        // b3

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y - Block.SIZE;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y + Block.SIZE;
        temp[3].x = b[0].x;
        temp[3].y = b[0].y + 2 * Block.SIZE;

        updateXY(1);
    }

    public void getDirection2() {
        //
        //
        // o o o o
        //

        //
        //
        // b1 b0 b2 b3
        //

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x - Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x + Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x + 2 * Block.SIZE;
        temp[3].y = b[0].y;

        updateXY(2);
    }

    public void getDirection3() {
        getDirection1();
    }

    public void getDirection4() {
        getDirection2();
    }

}
