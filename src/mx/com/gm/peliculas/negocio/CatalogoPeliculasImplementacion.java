/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatosImplementacion;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImplementacion implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImplementacion() {
        this.datos = new AccesoDatosImplementacion();
    }

    @Override
    public void agregarPeliculas(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {

            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("peliculas = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error en Lectura de datos");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);

            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catálogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

}
