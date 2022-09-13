package unicourse.first_task;

import java.awt.*;

public class Rectangle extends Figure implements IFigure {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle(Point topLeftPos, int width, int height) {
        this.topLeft = topLeftPos;
        this.topRight = new Point(this.topLeft.x + width, this.topLeft.y);
        this.bottomLeft = new Point(this.topLeft.x, this.topLeft.y + height);
        this.bottomRight = new Point(this.topRight.x, this.topRight.y + height);
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return Double.toString(width) + " : " + Double.toString(height);
    }

    public boolean isSquare() {
        return this.width == this.height;
    }

    public double diagonal() {
        return Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
    }
}
