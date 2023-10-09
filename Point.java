import java.util.Arrays;
public final class Point {
    private final double x;
    private final double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String getCoordinateX(){
        return Double.toString(x);
    }
    public String getCoordinateY(){
        return Double.toString(y);
    }
    public Point translate(double x, double y){
        return new Point(this.x + x, this.y + y);
    }
    public Point scale(double x){
        return new Point(this.x * x, this.y * x);
    }
}
