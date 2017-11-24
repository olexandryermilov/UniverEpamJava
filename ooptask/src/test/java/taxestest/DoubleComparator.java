package taxestest;

public class DoubleComparator {
    final static double eps = 0.001;
    public static boolean isEqual(double a, double b){
        return Math.abs(a-b)<eps;
    }
}
