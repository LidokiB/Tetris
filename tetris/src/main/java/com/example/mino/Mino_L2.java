//Finir l'implémentation de ce Mino

package com.example.mino;

import java.awt.Color;

public class Mino_L2 extends Mino {

    public Mino_L2() {
        create(Color.blue);
    }

    public void setXY(int x, int y) {

        // x o
        // x o
        // o o

        // xx b1
        // xx b0
        // b2 b3

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    public void getDirection1() {
        // x o
        // x o
        // o o

        // xx b1
        // xx b0
        // b2 b3

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y - Block.SIZE;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y + Block.SIZE;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y + Block.SIZE;

        updateXY(1);
    }

    public void getDirection2() {
        // o
        // o o o
        //

        // b3
        // b1 b0 b2
        //

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x - Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x + Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x - Block.SIZE;
        temp[3].y = b[0].y - Block.SIZE;

        updateXY(2);
    }

    public void getDirection3() {
        // o o
        // o x
        // o x

        // b3 b2
        // b0
        // b1

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x;
        temp[1].y = b[0].y + Block.SIZE;
        temp[2].x = b[0].x;
        temp[2].y = b[0].y - Block.SIZE;
        temp[3].x = b[0].x + Block.SIZE;
        temp[3].y = b[0].y - Block.SIZE;

        updateXY(3);

    }

    public void getDirection4() {
        //
        // o o o
        // x x o

        //
        // b2 b0 b1
        // xx xx b3

        temp[0].x = b[0].x;
        temp[0].y = b[0].y;
        temp[1].x = b[0].x + Block.SIZE;
        temp[1].y = b[0].y;
        temp[2].x = b[0].x - Block.SIZE;
        temp[2].y = b[0].y;
        temp[3].x = b[0].x + Block.SIZE;
        temp[3].y = b[0].y + Block.SIZE;

        updateXY(4);
    }

}
