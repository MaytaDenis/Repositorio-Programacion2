import java.util.Scanner;

public class TestEcuacionCuadratica {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

      
        System.out.print("Introduce el valor de a: ");
        double a = entrada.nextDouble();
        System.out.print("Introduce el valor de b: ");
        double b = entrada.nextDouble();
        System.out.print("Introduce el valor de c: ");
        double c = entrada.nextDouble();
        
        EcuacionCuadratica ecuacion = new EcuacionCuadratica(a, b, c);
        double discriminante = ecuacion.getDiscriminante();

 
        if (discriminante > 0) {
            System.out.println("El discriminante tiene dos raices :");
            System.out.println("Raiz 1: " + ecuacion.getRaiz1());
            System.out.println("Raiz 2: " + ecuacion.getRaiz2());
        } else if (discriminante == 0) {
            System.out.println("la ecuacion tiene una unica raiz :");
            System.out.println("Raiz: " + ecuacion.getRaiz1());
        } else {
            System.out.println(" La ecuacion no tiene raices reales.");
        }
    }
}
