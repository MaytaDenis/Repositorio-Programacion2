public class TestEcuacion {
    public static void main(String[] args) {
        EcuacionLineal ecuacion = new EcuacionLineal(1, 2, 2, 4, 4, 5);

        if (ecuacion.tieneSolucion()) {
            System.out.println("X= " + ecuacion.getX());
            System.out.println("Y= " + ecuacion.getY());
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }
    }
}