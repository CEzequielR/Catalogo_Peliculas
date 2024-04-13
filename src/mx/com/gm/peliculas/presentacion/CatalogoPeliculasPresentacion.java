
package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImplementacion;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;


public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        Scanner scan = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImplementacion();
        while (opcion != 0) {
            System.out.println("Elige una opción\n"
                    + " 1. Iniciar catálogo de peliculas\n"
                    + "2. Agregar película\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar película\n"
                    + "0. Salir");        
            opcion = Integer.parseInt(scan.nextLine());
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingresa el nombre de la película");
                    var nombrePelicula  = scan.nextLine();
                    catalogo.agregarPeliculas(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la película que quieres ver");
                    nombrePelicula = scan.nextLine();
                    catalogo.buscarPeliculas(nombrePelicula);
                    break;
                case 0:
                    System.out.println("Gracias por elegirnos, hasta luego.");
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;
            }
            
        }
        
    }
}
