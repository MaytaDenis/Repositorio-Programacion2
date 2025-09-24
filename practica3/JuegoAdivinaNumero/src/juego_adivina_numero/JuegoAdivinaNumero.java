package juego_adivina_numero;

import java.util.Random;
import java.util.Scanner;

public class JuegoAdivinaNumero extends Juego {
    // Atributo
    private int numeroAAdivinar;
    
    // Constructor
    public JuegoAdivinaNumero(int vidas) {
        super(vidas);
    }
    
    // Método juega
    public void juega() {
        int vidasIniciales = this.numeroDeVidas;
        
        // 1) Llama al método reiniciaPartida
        reiniciaPartida(vidasIniciales);
        
        // 2) Genera aleatoriamente el número a adivinar (entre 0 y 10)
        Random random = new Random();
        this.numeroAAdivinar = random.nextInt(11); // Genera un número entre 0 y 10
        
        Scanner scanner = new Scanner(System.in);
        int intento;
        
        do {
            // 3) Muestra un mensaje al usuario pidiendo que adivine un número
            System.out.println("\n-------------------------------------");
            System.out.println("Adivina el número entre 0 y 10.");
            System.out.println("Te quedan " + this.numeroDeVidas + " vidas.");
            System.out.print("Ingresa tu número: ");
            intento = scanner.nextInt();
            
            // 4) Compara el número
            if (intento == this.numeroAAdivinar) {
                // a) Si es igual
                System.out.println("¡¡Acertaste!!");
                actualizaRecord();
                break; // Sale del bucle y del método
            } else {
                // b) Si es diferente
                if (quitaVida()) {
                    // c) Aún le quedan más vidas
                    if (intento > this.numeroAAdivinar) {
                        System.out.println("El número a adivinar es menor.");
                    } else {
                        System.out.println("El número a adivinar es mayor.");
                    }
                } else {
                    // d) Ya no le quedan más vidas
                    System.out.println("\n¡¡Has perdido todas tus vidas!!");
                    System.out.println("El número era: " + this.numeroAAdivinar);
                    break; // Sale del bucle y del método
                }
            }
        } while (true);
    }
}