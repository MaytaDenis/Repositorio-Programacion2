package poo_figuras;

import java.util.Random;

public class PruebaFiguras {

    public static void main(String[] args) {
        Figura[] figuras = new Figura[5];
        Random rnd = new Random();
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja"};

        System.out.println("Arreglo de Figuras ");
        
        for (int i = 0; i < figuras.length; i++) {
            int tipoFigura = rnd.nextInt(2) + 1;
            double tamano = 1.0 + (10.0 - 1.0) * rnd.nextDouble(); 
            String colorElegido = colores[rnd.nextInt(colores.length)];

            if (tipoFigura == 1) {
                figuras[i] = new Cuadrado(tamano, colorElegido);
                System.out.println("Agregado: Cuadrado (Lado: " + String.format("%.2f", tamano) + ")");
            } else {
                figuras[i] = new Circulo(tamano, colorElegido);
                System.out.println("Agregado: Circulo (Radio: " + String.format("%.2f", tamano) + ")");
            }
        }
        System.out.println("Figura");
        
        for (Figura figura : figuras) {
            System.out.println(figura);
            System.out.println("  Area: " + String.format("%.2f", figura.area()));
            System.out.println("  Perimetro: " + String.format("%.2f", figura.perimetro()));
            if (figura instanceof Coloreado) {
                Coloreado objColoreado = (Coloreado) figura;
                System.out.println("  Coloreado: " + objColoreado.comoColorear());
            } else {
                System.out.println("  Coloreado: No se colorea");
            }
        }
    }
}