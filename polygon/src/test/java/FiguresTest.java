import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Time;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FiguresTest {
    Polygon polygon;
    Point A,B,C,D;
    @Before
    public void setPolygon(){
        A = new Point (3,1);
        B = new Point(3,3);
        C = new Point(5,3);
        D = new Point(5,1);
        Point[] polygonApexs = {A,B,C,D};
        polygon = new Polygon(polygonApexs);
    }
    @Test
    public void getDoubledTrapezoidArea_calculates_right(){
        final int RIGHT_ANSWER = 16;
        int answer = Polygon.getDoubledAreaOfTrapezoid(A,C);
        assertEquals(RIGHT_ANSWER,answer);
    }
    @Test
    public void getArea_calculates_right(){
        final double RIGHT_ANSWER = 4;
        double answer = polygon.getArea();
        assertTrue(Math.abs(answer-RIGHT_ANSWER)<0.001);
    }
    @Test
    public void getArea_randomPolygon_givesBiggerThanZero(){
        Random r = new Random(new Date().getTime());
        polygon = Main.getRandomPolygon(Math.abs(r.nextInt())%100);
        double answer = polygon.getArea();
        assertTrue(answer>0);
    }

}
