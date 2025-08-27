import java.util.Scanner;

public class App {

    public static double promedio(double[] arreglo) {
        double suma = 0;
        for (double valor : arreglo) {
            suma += valor;
        }
        return suma / arreglo.length;
    }

    public static double desviacion(double[] arreglo) {
        double promedio = promedio(arreglo);
        double sumaDeCuadrados = 0;
        for (double valor : arreglo) {
            sumaDeCuadrados += Math.pow(valor - promedio, 2);
        }
        return Math.sqrt(sumaDeCuadrados / (arreglo.length - 1));
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double[] numeros = new double[10];

       
        for (int i = 0; i < 10; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = entrada.nextDouble();
        }

    
        double promedioCalculado = promedio(numeros);
        double desviacionCalculada = desviacion(numeros);

      
        System.out.println("El promedio es: " + promedioCalculado);
        System.out.println("La desviacion estandar es: " + desviacionCalculada);
    }
}