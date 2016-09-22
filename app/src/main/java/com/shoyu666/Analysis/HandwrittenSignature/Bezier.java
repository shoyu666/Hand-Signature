package com.shoyu666.Analysis.HandwrittenSignature;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * bezier曲线绘制
 */
public class Bezier {
    private Point controlPointOne;
    private Point controlPointTwo;
    private int drawSteps;
    private Point endPoint;
    private Point startPoint;

    public Bezier(Point startPoint, Point controlPointOne, Point controlPointTwo, Point endPoint) {
        this.startPoint = startPoint;
        this.controlPointOne = controlPointOne;
        this.controlPointTwo = controlPointTwo;
        this.endPoint = endPoint;
        this.drawSteps = (int) ((startPoint.distanceTo(controlPointOne) + controlPointOne.distanceTo(controlPointTwo)) + controlPointTwo.distanceTo(endPoint));
    }

    public void draw(Canvas canvas, Paint paint, float startWidth, float endWidth) {
        float widthDelta = endWidth - startWidth;
        for (int i = 0; i < this.drawSteps; i++) {
            float t = ((float) i) / ((float) this.drawSteps);
            float tt = t * t;
            float ttt = tt * t;
            float u = 1.0f - t;
            float uu = u * u;
            float uuu = uu * u;
            float x = (((uuu * this.startPoint.getX()) + (((3.0f * uu) * t) * this.controlPointOne.getX())) + (((3.0f * u) * tt) * this.controlPointTwo.getX())) + (this.endPoint.getX() * ttt);
            float y = (((uuu * this.startPoint.getY()) + (((3.0f * uu) * t) * this.controlPointOne.getY())) + (((3.0f * u) * tt) * this.controlPointTwo.getY())) + (this.endPoint.getY() * ttt);
            paint.setStrokeWidth((ttt * widthDelta) + startWidth);
            canvas.drawPoint(x, y, paint);
        }
    }
}