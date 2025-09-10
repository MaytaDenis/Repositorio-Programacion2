public class Vector {
    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double magnitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public double productoEscalar(Vector otroVector) {
        return (this.x * otroVector.x) + (this.y * otroVector.y) + (this.z * otroVector.z);
    }
}