package com.example.mino;

import java.awt.Color;

public class Mino_L1 extends Mino {

    public Mino_L1() {
        create(Color.orange);
    }

    public void setXY(int x, int y) {

        // o
        // o
        // o o

        // b1
        // b0
        // b2 b3

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    public void getDirection1() {
        // o
        // o
        // o o

        // b1
        // b0
        // b2 b3

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y - Block.SIZE;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y + Block.SIZE;
        temp[3].x = b[0].x + Block.SIZE;
        temp[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }

    public void getDirection2() {
        //
        // o o o
        // o

        //
        // b2 b0 b1
        // b3

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x + Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x - Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y + Block.SIZE;

        updateXY(2);
    }

    public void getDirection3() {
        // o o
        // x o
        // x o

        // b3 b2
        // xx b0
        // xx b1

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y + Block.SIZE;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y - Block.SIZE;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y - Block.SIZE;

        updateXY(3);

    }

    public void getDirection4() {
        // x x o
        // o o o
        //

        // xx xx b3
        // b1 b0 b2
        //

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x - Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x + Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x + Block.SIZE;
        temp[3].y = b[0].y - Block.SIZE;

        updateXY(4);
    }

}
