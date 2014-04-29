package edu.berkeley.ischool.aep;

/**
 * Understands a shape with four sides at right angles.
 */
public class Rectangle {
    private final int width;
    private final int length;

    public Rectangle(int width, int length) {

        this.width = width;
        this.length = length;
    }

    public int area() {
        return width * length;
    }
}
