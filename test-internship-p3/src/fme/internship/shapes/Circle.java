package fme.internship.shapes;

public class Circle {
    static Double r;

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }
}
