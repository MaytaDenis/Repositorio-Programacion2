public class Main {
    public static void main(String[] args) {        
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(2, 4, 6); 
        Vector v3 = new Vector(3, -3, 4); 

        System.out.println("Vector1 y Vector2 son perpendiculares " + AlgebraVectorial.esPerpendicular(v1, v2));
        System.out.println("Vector1 y Vector3 son paralelos " + AlgebraVectorial.esParalelo(v1, v3));
        
        Vector proy = AlgebraVectorial.proyeccion(v1, v3);
        System.out.println("Proyeccion de Vector1 en Vector3: (" + proy.x + ", " + proy.y + ", " + proy.z + ")");
        System.out.println("Componente de Vector1 en Vector3: " + AlgebraVectorial.componente(v1, v3));
    }
}
