package unicourse.first_task.tests.twod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;
import unicourse.first_task.twoD.Circle;

import java.awt.*;


public class CircleTest {

    @BeforeAll
    static void circlePrint(){
        System.out.println("Запуск теста для класса Circle");
    }

    @Test
    static void diametr() {
        int r = 100;
        Circle c = new Circle(new Point(0, 0), r);
        Assertions.assertEquals(2 * r, c.diametr());
    }

    @Test
    static void len() {
        int r = 100;
        Circle c = new Circle(new Point(0, 0), r);
        Assertions.assertEquals(2 * r * Math.PI, c.len());
    }

    @Test
    static void area() {
        int r = 100;
        Circle c = new Circle(new Point(0, 0), r);
        Assertions.assertEquals(Math.PI * Math.pow(r, 2), c.area());
    }
}