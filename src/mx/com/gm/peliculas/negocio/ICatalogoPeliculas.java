/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    void agregarPeliculas(String nombrePelicula);
    void listarPeliculas();
    void buscarPeliculas(String buscar);
    void iniciarCatalogoPeliculas();
    
}
