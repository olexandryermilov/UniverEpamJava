import java.util.*;

interface Figure{

}
interface ColorFigure extends Figure{

}
class Point implements Cloneable{
    @Override
    protected Object clone()  {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    private int x;
    private int y;
    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    public Point(Point p) {
        this.x=p.getX();
        this.y=p.getY();
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    public double distance(Point b) {
        int dx = x - b.x;
        int dy = y - b.y;
        // Simple cartesian distance.
        return Math.sqrt(dx * dx + dy * dy);
    }
}
class ColorPoint extends Point{
    private int color;
    public ColorPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "ColorPoint [color=" + color + ", X=" + getX() + ", Y=" + getY() + "]";
    }
}
class Line {
    private Point beg;
    private Point end;
    public Line(Point beg, Point end) {
        super();
        this.beg = beg;
        this.end = end;
    }
    public Line(int x1, int y1, int x2, int y2) {
        super();
        this.beg = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }
    public Point getBeg() {
        //return new Point(beg);
        return beg;
    }
    public void setBeg(Point beg) {
        this.beg = beg;
    }
    public Point getEnd() {
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

}
class ColorLine extends Line{
    private int color;

    public ColorLine(Point beg, Point end, int color) {
        super(beg, end);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "ColorLine [color=" + color + ", Beg = " + getBeg() + ", End =" + getEnd() + "]";
    }

}
class Triangle implements Figure{
    Point apexA, apexB, apexC;
    Line sideAB, sideBC, sideAC;

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                ", sideAB=" + sideAB +
                ", sideBC=" + sideBC +
                ", sideAC=" + sideAC +
                '}';
    }

    public Triangle(Point apexA, Point apexB, Point apexC) {
        super();
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        //sideAB= new Line(apexA, apexB);
    }
    public Line getSideAB() {
        if (sideAB==null) sideAB = new Line(apexA, apexB);
        return sideAB;
    }
    public void setApexA(Point p) {
        apexA=p;
        sideAB=null;
        sideAC=null;
    }
}
class ColorTriangle extends Triangle implements ColorFigure{
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    private int color;
    public ColorTriangle(Point apexA,Point apexB, Point apexC, int color) {
        super(apexA, apexB,apexC);
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorTriangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                ", color=" + color +
                '}';
    }
}

class Polygon implements Cloneable, Figure{


    private Point [] apexs;
    private Line[] sides;
    public Point[] getApexs() {
        return apexs;
    }

    public void setApexs(Point[] apexs) {
        this.apexs = apexs;
    }

    public Line[] getSides() {
        return sides;
    }

    public void setSides(Line[] sides) {
        this.sides = sides;
    }

    public Polygon(Point[] apexs) {
        this.apexs = apexs;
        this.sides= new Line[apexs.length];
        this.sides[0]=new Line(apexs[0],apexs[apexs.length-1]);
        for(int i=1;i<apexs.length;i++){
            this.sides[i]=new Line(apexs[i],apexs[i-1]);
        }
    }
    public static int getDoubledAreaOfTrapezoid(Point a, Point b){
        return (-a.getY()+b.getY())*(a.getX()+b.getX());
    }
    public double getArea(){
        sortClockwise();
        int area = getDoubledAreaOfTrapezoid(apexs[0],apexs[apexs.length-1]);
        for(int i=1;i<apexs.length;i++){
            area+=getDoubledAreaOfTrapezoid(apexs[i],apexs[i-1]);
        }
        return Math.abs(area)/2.0;
    }
    private void sortClockwise(){
        for (int i = 0; i < apexs.length - 1; i++) {
            Point a = apexs[i];
            int closest = i;
            double howClose = Double.MAX_VALUE;
            for (int j = i + 1; j < apexs.length; j++) {
                double howFar = a.distance(apexs[j]);
                if (howFar < howClose) {
                    closest = j;
                    howClose = howFar;
                }
            }
            if (closest != i + 1) {
                Point t =apexs[i+1];
                apexs[i+1]=apexs[closest];
                apexs[closest] = t;
            }
        }
    }
    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString() {
        return "Polygon{" +
                "apexs=" + Arrays.toString(apexs) +
                '}';
    }
}
class ColorPolygon extends Polygon implements ColorFigure{
    private int color;

    public ColorPolygon(Point[] apexs, int color) {
        super(apexs);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorPolygon{" +
                "color=" + color +
                '}';
    }
}
public class Main{
    final static Random random = new Random(42);
    public static Figure figureFabric(){
        switch (Math.abs(random.nextInt())%2){
            case 0: return getFigure();
            case 1: return getColorFigure();
            default:return null;
        }
    }
    private static Point getRandomPoint(){
        return new Point(random.nextInt()%100,random.nextInt()%100);
    }
    public static Polygon getRandomPolygon(int n){
        Point[] poly = new Point[n];
        for(int i=0;i<poly.length;i++){
            poly[i]=getRandomPoint();
        }
        return new Polygon(poly);
    }
    private static ColorPolygon getRandomColorPolygon(int n){
        Point[] poly = new Point[n];
        for(int i=0;i<poly.length;i++){
            poly[i]=getRandomPoint();
        }
        return new ColorPolygon(poly,random.nextInt());
    }
    public static Figure getFigure(){
        switch (Math.abs(random.nextInt())%2){
            case 0:
                return new Triangle(getRandomPoint(),getRandomPoint(),getRandomPoint());
            case 1:
                return getRandomPolygon(Math.abs(random.nextInt())%7+4);
            default:return null;
        }
    }
    public static Figure getColorFigure(){
        switch (Math.abs(random.nextInt())%2){
            case 0:
                return new ColorTriangle(getRandomPoint(),getRandomPoint(),getRandomPoint(),random.nextInt()%256);
            case 1:
                return getRandomColorPolygon(Math.abs(random.nextInt())%7+4);
            default:return null;
        }
    }
    public static void main(String[] args) {
        ArrayList<ColorFigure> colorFigures = new ArrayList<ColorFigure>();
        ArrayList<Figure> figures = new ArrayList<Figure>();
        ArrayList<ColorTriangle> colorTriangles = new ArrayList<ColorTriangle>();
        ArrayList<Triangle>triangles = new ArrayList<Triangle>();
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
        ArrayList<ColorPolygon> colorPolygons = new ArrayList<ColorPolygon>();
        for(int i=0;i<Math.abs(random.nextInt())%50+15;i++){
            Figure f = figureFabric();
            if(f instanceof ColorFigure){
                colorFigures.add((ColorFigure)f);
                if(f instanceof ColorPolygon){
                    colorPolygons.add((ColorPolygon)f);
                }
                else{
                    if(f instanceof ColorTriangle){
                        colorTriangles.add((ColorTriangle)f);
                    }
                }
            }
            else{
                figures.add(f);
                if(f instanceof Polygon){
                    polygons.add((Polygon)f);
                }
                else{
                    if(f instanceof Triangle){
                        triangles.add((Triangle)f);
                    }
                }
            }
        }
        System.out.println(figures.toString());
        System.out.println(colorFigures.toString());
        System.out.println(triangles.toString());
        System.out.println(colorTriangles.toString());
        System.out.println(polygons.toString());
        System.out.println(colorPolygons.toString());
    }

}
