import static java.lang.Math.sqrt;

public class EcuacionCuadratica {
  
    private double a;
    private double b;
    private double c;


    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminante() {
        return (b * b) - (4 * a * c);
    }

    public double getRaiz1() {
        double discriminante = getDiscriminante();
        if (discriminante >= 0) {
            return (-b + sqrt(discriminante)) / (2 * a);
        } else {
            return 0;
        }
    }

    public double getRaiz2() {
        double discriminante = getDiscriminante();
        if (discriminante >= 0) {
            return (-b - sqrt(discriminante)) / (2 * a);
        } else {
            return 0; 
        }
    }
}