package unicourse.first_task.twoD;

import unicourse.first_task.TriangleCreateException;

import java.awt.*;

public class Triangle implements IFigure{
    Point a;
    Point b;
    Point c;

    double lenAB;
    double lenBC;
    double lenCA;

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public double getLenAB() {
        return lenAB;
    }

    public double getLenBC() {
        return lenBC;
    }

    public double getLenCA() {
        return lenCA;
    }

    public Triangle(Point a, Point b, Point c) throws TriangleCreateException {
        this.a = a;
        this.b = b;
        this.c = c;
        this.lenAB = distance(a, b);
        this.lenBC = distance(b, c);
        this.lenCA = distance(c, a);
        if (!isValid()) {
            throw new TriangleCreateException("failed to create triangle");
        }
    }

    public double perimeter() {
        return lenAB + lenBC + lenCA;
    }

    /*
    S = √(p·(p - a)·(p - b)·(p - c)), P = (a+b+c)/2 - формула Герона,
    где a, b, c - стороны треугольника, p - полупериметр.
     */
    public double area() {
        double p = (lenAB + lenBC + lenCA) / 2;
        return Math.sqrt(p * (p - lenAB) * (p - lenBC) * (p - lenCA));
    }

    @Override
    public String toString() {
        return Double.toString(lenAB) + " : " + Double.toString(lenBC) + " : " + Double.toString(lenCA);
    }

    public boolean isValid(){
        boolean ret = false;
        if (lenAB == 0 | lenBC == 0 | lenCA == 0)
            return false;

        if (lenAB + lenBC >= lenCA) {
            if (lenBC + lenCA >= lenAB)
                if (lenAB + lenCA >= lenBC)
                    ret = true;
        }

        return ret;
    }
}
