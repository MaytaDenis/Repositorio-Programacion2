package poo_figuras;

public class Circulo extends Figura {
    
    private double radio;

    public Circulo(double radio, String color) {
        super(color);
        this.radio = radio;
    }
    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public String toString() {
        return super.toString() + " - Radio: " + radio;
    }
}
