package com.shoyu666.Analysis.HandwrittenSignature;

/**
 * 自定义点
 */
public class Point {
    private long time;
    private float x;
    private float y;

    public Point(float x, float y, long time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 当前点相对于起始点的 速度=距离/时间
     * @param start
     * @return
     */
    public float velocityFrom(Point start) {
        return distanceTo(start) / ((float) (this.time == start.time ? 1 : this.time - start.time));
    }

    /**
     * 当前点到start点的距离
     * @param start
     * @return
     */
    protected float distanceTo(Point start) {
        float dX = this.x - start.getX();
        float dY = this.y - start.getY();
        return (float) Math.sqrt((double) ((dX * dX) + (dY * dY)));
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }


    public String toString() {
        return "(" + this.x + ", " + this.y + ") @ " + this.time;
    }
}