public class Main {
    public static void main(String[] args) {
        Vector a = new Vector(2, 3, 4);
        Vector b = new Vector(1, 2, 4); 
        Vector c = new Vector(1, 2, 3   ); 
        
        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);
        System.out.println("Vector c: " + c);
        System.out.println("");
        Vector suma = a.sumar(b);
        System.out.println("Suma de a + b: " + suma);
        Vector multiEscalar = a.multiplicarPorEscalar(5);
        System.out.println("Multiplicacion de a * 5: " + multiEscalar);
        System.out.println("Magnitud de a: " + a.magnitud());
        System.out.println("Vector unitario de a: " + a.vectorUnitario());
        System.out.println("Producto escalar de a y c: " + a.productoEscalar(c));
        System.out.println("Producto vectorial de a y b: " + a.productoVectorial(b));
        System.out.println("a y c son perpendiculares?: " + a.esPerpendicular(c));
        System.out.println("a y b son paralelos?: " + a.esParalelo(b));
        System.out.println("Proyeccion de a en b: " + a.proyeccionEn(b));
        System.out.println("Componente de a en b: " + a.componenteEn(b));
    }
}
