import java.lang.Math;
sealed class Shape permits Ball, Cylinder, Pyramid {
    private double volume;
    protected Shape(){
    }
    public Shape(double volume){
        this.volume = volume;
    }
    public void print() {
        System.out.println("Объём: " + Double.toString(volume));
    }
}

final class Ball extends Shape {
    private double radius;
    private double volume;
    public Ball(double rad){
        this.radius = rad;
        this.volume = 4.0/3.0 * rad * rad * rad;
    }
    @Override
    public void print() {
        System.out.println("Шар");
        System.out.println("Объём: " + Double.toString(volume));
        System.out.println("Радиус: " + Double.toString(radius));
        System.out.println();
    }
}

final class Cylinder extends Shape {
    private double height;
    private double radius;
    private double area;
    private double volume;
    public Cylinder(double volume, double height){
        this.volume = volume;
        this.height = height;
        this.area = volume / height;
        this.radius = Math.sqrt(area / Math.PI);
    }
    @Override
    public void print(){
        System.out.println("Цилиндр");
        System.out.println("Объём: " + Double.toString(volume));
        System.out.println("Высота: " + Double.toString(height));
        System.out.println("Радиус: " + Double.toString(radius));
        System.out.println("Плошадь основания: " + Double.toString(area));
        System.out.println();
    }
}

non-sealed class Pyramid extends Shape{
    private double height;
    private double area;
    private double volume;
    protected Pyramid(){
    }
    public Pyramid(double height, double area){
        this.height = height;
        this.area = area;
        this.volume = 1.0 / 3.0 * height * area;
    }
    @Override
    public void print(){
        System.out.println("Пирамида");
        System.out.println("Высота: " + Double.toString(height));
        System.out.println("Плошадь основания: " + Double.toString(area));
        System.out.println("Объём: " + Double.toString(volume));
        System.out.println();
    }
}

class ColorPyramid extends Pyramid {
    private String color;
    private double height;
    private double area;
    private double volume;

    public ColorPyramid(String color, double height, double area) {
        this.height = height;
        this.area = area;
        this.volume = 1.0 / 3.0 * height * area;
        this.color = color;
    }
    @Override
    public void print(){
        System.out.println("Цветная пирамида");
        System.out.println("Цвет: " + color);
        System.out.println("Высота: " + Double.toString(height));
        System.out.println("Плошадь основания: " + Double.toString(area));
        System.out.println("Объём: " + Double.toString(volume));
        System.out.println();
    }
}