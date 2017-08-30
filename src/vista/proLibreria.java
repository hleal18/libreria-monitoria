/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import logica.Libreria;
import logica.Libro;
/**
 *
 * @author usuario
 */
public class proLibreria {
    public static void main(String[] args){
        //Titulo, codigo, numeroPaginas, tipo
        Libro libro_1 = new Libro("100 años de soledad", 1, 390, 1);
        Libro libro_2 = new Libro("Game of Thrones", 2, 350, 2);
        Libro libro_3 = new Libro("Rosario tijeras", 3, 250, 3);
        Libro libro_4 = new Libro("Paraíso Travel", 4, 125, 4);
        Libro libro_5 = new Libro("Tipo 1", 5, 300, 1);
        Libro libro_6 = new Libro("Tipo 2", 6, 500, 2);
        Libro libro_7 = new Libro("Tipo 3", 7, 750, 3);
        Libro libro_8 = new Libro("Tipo 4", 8, 662, 4);
        
        imprimirString("Características de los cuatro libros.");
        imprimirString(libro_1.toString());
        imprimirString(libro_2.toString());
        imprimirString(libro_3.toString());
        imprimirString(libro_4.toString());
        imprimirString(libro_5.toString());
        imprimirString(libro_6.toString());
        imprimirString(libro_7.toString());
        imprimirString(libro_8.toString());
        
        Libreria libreria = new Libreria();
        imprimirString("Agregar libros.");
        imprimirString(libreria.agregarLibro(libro_1) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_2) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_3) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_4) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_5) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_6) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_7) == true ? "True" : "False");
        imprimirString(libreria.agregarLibro(libro_8) == true ? "True" : "False");
        
        imprimirString("Busqueda por titulo.");
        imprimirString(libreria.buscarLibro(libro_1.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_2.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_3.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_4.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_5.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_6.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_7.getTitulo()).toString());
        imprimirString(libreria.buscarLibro(libro_8.getTitulo()).toString());
        
        imprimirString("Busqueda por codigo.");
        imprimirString(libreria.buscarLibro(libro_1.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_2.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_3.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_4.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_5.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_6.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_7.getCodigo()).toString());
        imprimirString(libreria.buscarLibro(libro_8.getCodigo()).toString());
        
        imprimirString("Listar por tipo.");
        imprimirString("Tipo 1:");
        imprimirString(libreria.listarLibrosTipo(1));
        imprimirString("Tipo 2:");
        imprimirString(libreria.listarLibrosTipo(2));
        imprimirString("Tipo 3:");
        imprimirString(libreria.listarLibrosTipo(3));
        imprimirString("Tipo indefinido:");
        imprimirString(libreria.listarLibrosTipo(4));
    }
    
    public static void imprimirString(String texto){
        System.out.println(texto);
    }
}
