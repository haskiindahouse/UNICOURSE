package unicourse.first_task;
import java.awt.Point;

interface IFigure {
    double perimeter();
    double area();

    default double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

}


