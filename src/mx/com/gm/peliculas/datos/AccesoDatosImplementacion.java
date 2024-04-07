package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImplementacion implements IAccesoDatos {

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito información en el archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void crear(String nombre) throws AccesoDatosEx {
        var archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creó el archivo.");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepción al crear el archivo." + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha eliminado el archivo");
        }
    }

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        BufferedReader entrada;
        try {

            entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                var pelicula = new Pelicula(lectura);
                peliculas.add(pelicula);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción al listar peliculas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            var indice = 1;
            while (lectura != null) {
                if (buscar != null && buscar.equalsIgnoreCase(lectura)) {
                    resultado = "Pelicula: " + lectura + "\nEncontrada en el índice: " + indice;
                    break;
                } else {
                    lectura = entrada.readLine();
                    indice++;
                }
                entrada.close();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción al buscar peliculas: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepción al buscar peliculas: " + ex.getMessage());
        }

        return resultado;
    }

}
