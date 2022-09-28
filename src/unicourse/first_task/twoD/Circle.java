package unicourse.first_task.twoD;

import java.awt.*;

public class Circle {
    double radius;
    Point centr;
    // вычисляет и возвращает диаметр, длину окружности, площадь окружности
    public Circle(Point centr, double radius) {
        this.centr = centr;
        this.radius = radius;
    }

    public double diametr() {
        return 2 * radius;
    }

    public double len() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return Double.toString(radius) + " : (" + Integer.toString(centr.x) + ", " + Integer.toString(centr.y) + ")";
    }
}
