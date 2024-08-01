public class VisualAccumulator {
    private double total;
    private int N;

    public VisualAccumulator(int X, double Y) {
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, X);
        StdDraw.setYscale(0, Y);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        N++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N, mean());
    }

    public double mean() {
        return total/N;
    }

    public String toString() {
        return "(" + N + " numeros) "
                + "media: " + String.format("%4.2f", mean());
    }
}
