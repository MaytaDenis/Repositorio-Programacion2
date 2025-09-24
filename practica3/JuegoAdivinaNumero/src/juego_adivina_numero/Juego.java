package juego_adivina_numero;

public class Juego {
    // Atributos
    protected int numeroDeVidas;
    protected int record;

    // Constructor por defecto
    public Juego() {
        this.numeroDeVidas = 0;
        this.record = 0;
    }

    // Constructor con parámetro
    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }
    
    // Método reiniciaPartida
    public void reiniciaPartida(int vidasIniciales) {
        this.numeroDeVidas = vidasIniciales;
    }

    // Método actualizaRecord
    public void actualizaRecord() {
        if (this.numeroDeVidas > this.record) {
            this.record = this.numeroDeVidas;
            System.out.println("¡¡Nuevo récord establecido: " + this.record + " vidas restantes!!");
        }
    }

    // Método quitaVida
    public boolean quitaVida() {
        this.numeroDeVidas--;
        return this.numeroDeVidas > 0;
    }
}