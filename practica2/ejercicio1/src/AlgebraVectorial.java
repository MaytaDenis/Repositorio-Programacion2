public class AlgebraVectorial {

    public static boolean esPerpendicular(Vector v1, Vector v2) {
        return Math.abs(v1.productoEscalar(v2)) < 1e-9;
    }

    public static boolean esParalelo(Vector v1, Vector v2) {
        double i = (v1.y * v2.z) - (v1.z * v2.y);
        double j = (v1.z * v2.x) - (v1.x * v2.z);
        double k = (v1.x * v2.y) - (v1.y * v2.x);
        return (Math.abs(i) < 1e-9) && (Math.abs(j) < 1e-9) && (Math.abs(k) < 1e-9);
    }

    public static Vector proyeccion(Vector v1, Vector v2) {
        double productoEscalar = v1.productoEscalar(v2);
        double magnitudCuadrada = v2.productoEscalar(v2);

        if (magnitudCuadrada == 0) {
            return new Vector(0, 0, 0); 
        }

        double factor = productoEscalar / magnitudCuadrada;
        return new Vector(factor * v2.x, factor * v2.y, factor * v2.z);
    }
    public static double componente(Vector v1, Vector v2) {
        double productoEscalar = v1.productoEscalar(v2);
        double magnitudV2 = v2.magnitud();

        if (magnitudV2 == 0) {
            return 0; 
        }

        return Math.abs(productoEscalar) / magnitudV2;
    }
}