package com.example.mino;

import java.awt.Color;

public class Mino_Z2 extends Mino {

    public Mino_Z2() {
        create(Color.green);
    }

    public void setXY(int x, int y) {
        //
        // x o o
        // o o

        //
        // xx b0 b1
        // b3 b2

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x + Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    public void getDirection1() {
        //
        // x o o
        // o o

        //
        // xx b0 b1
        // b3 b2

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x + Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y + Block.SIZE;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }

    public void getDirection2() {
        // o
        // o o
        // x o

        // b3
        // b2 b0
        // xx b1

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y + Block.SIZE;
        temp[2].x = b[0].x - Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y - Block.SIZE;

        updateXY(2);
    }

    public void getDirection3() {
        getDirection1();
    }

    public void getDirection4() {
        getDirection2();
    }

}
