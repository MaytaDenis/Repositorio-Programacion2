import java.lang.Math;

public class Vector {
    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector sumar(Vector otro) {
        return new Vector(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }
    public Vector multiplicarPorEscalar(double r) {
        return new Vector(this.x * r, this.y * r, this.z * r);
    }
    public double magnitud() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
    public Vector vectorUnitario() {
        double mag = this.magnitud();
        if (mag == 0) {
            return new Vector(0, 0, 0);
        }
        return this.multiplicarPorEscalar(1.0 / mag);
    }
    public double productoEscalar(Vector otro) {
        return (this.x * otro.x) + (this.y * otro.y) + (this.z * otro.z);
    }
    public Vector productoVectorial(Vector otro) {
        double i = (this.y * otro.z) - (this.z * otro.y);
        double j = (this.z * otro.x) - (this.x * otro.z);
        double k = (this.x * otro.y) - (this.y * otro.x);
        return new Vector(i, j, k);
    }
    public boolean esPerpendicular(Vector otro) {
        return Math.abs(this.productoEscalar(otro)) < 1e-9;
    }
    public boolean esParalelo(Vector otro) {
        return this.productoVectorial(otro).magnitud() < 1e-9;
    }
    public Vector proyeccionEn(Vector base) {
        double productoEscalar = this.productoEscalar(base);
        double magnitudCuadrada = base.productoEscalar(base);
        if (magnitudCuadrada == 0) {
            return new Vector(0, 0, 0);
        }
        double factor = productoEscalar / magnitudCuadrada;
        return base.multiplicarPorEscalar(factor);
    }
    public double componenteEn(Vector base) {
        double productoEscalar = this.productoEscalar(base);
        double magnitudBase = base.magnitud();
        if (magnitudBase == 0) {
            return 0;
        }
        return Math.abs(productoEscalar) / magnitudBase;
    }
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}