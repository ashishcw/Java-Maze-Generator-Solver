package org.ashish.maze_generator_solver.model;

import java.awt.*;
import java.util.UUID;

public abstract class GameBaseObjectCore {
    protected UUID id;
    protected int xPos, yPos;
    protected int row, col;
    protected int sizeWidth, sizeHeight;
    protected Rectangle hitBox;
    protected float xVelocity, yVelocity;
    protected String name;
    protected boolean isActiveInScene;
    protected Color color;



    public abstract void tick();
    public abstract void render(Graphics g);

    public GameBaseObjectCore(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public UUID getId() {
        return id;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(int sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public int getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(int sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActiveInScene() {
        return isActiveInScene;
    }

    public void setActiveInScene(boolean activeInScene) {
        isActiveInScene = activeInScene;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
