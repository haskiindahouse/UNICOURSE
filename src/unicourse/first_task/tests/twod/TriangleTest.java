package unicourse.first_task.tests.twod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import unicourse.first_task.twoD.Triangle;

import java.awt.*;


public class TriangleTest {

    @BeforeAll
    static void trianglePrint(){
        System.out.println("Запуск теста для класса Triangle");
    }

    @Test
    static void area() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        Point c = new Point(4, 4);
        Triangle t = new Triangle(a, b, c);
        double p = (t.getLenAB() + t.getLenBC() + t.getLenCA()) / 2;
        Assertions.assertEquals( Math.sqrt(p * (p - t.getLenAB()) * (p - t.getLenBC()) * (p - t.getLenCA())), t.area());
    }
    @Test
    static void isExist()
    {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(0, 0);
        Triangle t = new Triangle(a, b, c);
        Assertions.assertFalse(t.isValid());
    }

}