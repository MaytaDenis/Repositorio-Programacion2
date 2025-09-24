package juego_adivina_numero;

public class Aplicacion {
    public static void main(String[] args) {
        // Crear una instancia de JuegoAdivinaNumero con 3 vidas
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        
        // Llama al método juega para iniciar el juego
        juego.juega();
    }
}