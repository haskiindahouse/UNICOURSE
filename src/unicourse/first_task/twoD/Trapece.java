package unicourse.first_task.twoD;

import java.awt.*;

public class Trapece extends Figure implements IFigure {

    double h;
    double lenAB;
    double lenBC;
    double lenCD;
    double lenDA;

    public double getH() {
        return h;
    }

    public double getLenAB() {
        return lenAB;
    }

    public double getLenBC() {
        return lenBC;
    }

    public double getLenCD() {
        return lenCD;
    }

    public double getLenDA() {
        return lenDA;
    }

    public Trapece(Point topLeft, Point topRight, Point bottomLeft, Point bottomRight){
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        lenAB = distance(topLeft, topRight);
        lenBC = distance(topRight, bottomRight);
        System.out.println(topRight.x + " topRight " + topRight.y);
        System.out.println(Math.pow(bottomRight.x - topRight.x, 2));
        System.out.println(Math.pow(bottomRight.y - topRight.y, 2));

        System.out.println(Math.sqrt(Math.pow(bottomRight.x - topRight.x, 2) + Math.pow(bottomRight.y - topRight.y, 2)));
        System.out.println(bottomRight.x + " bottomRight " + bottomRight.y);

        lenCD = distance(bottomRight, bottomLeft);
        lenDA = distance(bottomLeft, topLeft);

        double c2 = Math.pow(lenDA, 2);
        double numerator = Math.pow(lenCD - lenAB, 2) + c2 - Math.pow(lenBC, 2);
        double denominator = 2 * (lenCD - lenAB);
        h = Math.sqrt(c2 - Math.pow(numerator / denominator, 2));
    }
    @Override
    public double perimeter() {
        return lenAB + lenBC + lenCD + lenDA;
    }

    @Override
    public double area() {
        return 0.5 * h * (lenAB + lenCD);
    }
}
