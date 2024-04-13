

package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    public boolean existe(String nombreArchivo) throws AccesoDatosEx ;
    List <Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);
    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    void crear(String nombre) throws AccesoDatosEx;
    void borrar(String nombreArchivo);
}
