package poo_figuras;

public abstract class Figura {
    
    private String color;

    public Figura(String color) {
        this.color = color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Figura: " + getClass().getSimpleName() + " [Color: " + color + "]";
    }
    public abstract double area();
    public abstract double perimetro();
}