package unicourse.first_task;

import java.awt.*;

public class Main {
    public static void main(String[] args)
    {
        Point topLeftPos = new Point(0, 0);
        int width = 3;
        int height = 4;
        Rectangle r = new Rectangle(topLeftPos, width, height);
        System.out.println(r.diagonal());
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        Point c = new Point(4, 4);
        Triangle t = new Triangle(a, b, c);
        System.out.println(t.area());
        Point centr = new Point(0, 0);
        Circle o = new Circle(centr, 10);
        System.out.println(o.area());
        {
            Point p1 = new Point(0, 0);
            Point p2 = new Point(0, 4);
            Point p3 = new Point(4, 0);
            Point p4 = new Point(4, 5);
            Trapece tr = new Trapece(p1, p2, p3, p4);
            System.out.println("AB = " + tr.getLenAB());
            System.out.println("CD = " + tr.getLenCD());
            System.out.println("BC = " + tr.getLenBC());
            System.out.println("DA = " + tr.getLenDA());
            System.out.println("h = " + tr.getH());
            System.out.println("area = " + tr.area());
        }
    }
}
