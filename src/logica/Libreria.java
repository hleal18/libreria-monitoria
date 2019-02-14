/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author usuario
 */
public class Libreria {
    private static final int SIZE = 150;
    
    private final Libro[] catalogo;
    private int indiceActual;
    
    public Libreria(){
        catalogo = new Libro[SIZE];
        indiceActual = 0;
    }
    
    public Libro[] getCatalogo(){ return catalogo; }
    public int getIndiceActual(){ return indiceActual; }
    
    public Libro[] buscarLibro(String titulo){
        Libro[] librosEncontrados = new Libro[20];
        int indice = 0;
        for(Libro libro : catalogo){
            if(libro != null && libro.getTitulo().equals(titulo)){
                librosEncontrados[indice] = libro;
                indice++;
            }
        }
        return librosEncontrados;
    }
    
    public Libro buscarLibro(int codigo){
        for(Libro libro : catalogo){
            if(libro != null && libro.getCodigo() == codigo){
                return libro;
            }
        }
        return null;
    }
    
    public boolean agregarLibro(Libro libro){
        if(buscarLibro(libro.getCodigo()) == null){
            catalogo[indiceActual] = libro;
            indiceActual++;
            return true;
        }
        return false;
    }
    
    //Cualquier tipo de libro será diferente a 1 - 3.
    public Libro[] listarLibrosTipo(int tipo){
        Libro[] libros = new Libro[150];
        int indice = 0;
        for(Libro libro : catalogo){
            if(libro != null){
                if(tipo == libro.getTipo()){
                    libros[indice] = libro;
                    indice++;
                }
                else if((tipo < 1 || tipo > 3) &&
                        (libro.getTipo()  < 1 || libro.getTipo() > 3)){
                    libros[indice] = libro;
                    indice++;
                }
            }
            else{
                break;
            }
        }
        return libros;
    }
    
    //Listar libros por tipo que devuelve un arreglo
    
    
    //Prepara un String con el titulo del libro junto con el precio
    private String listarLibro(Libro libro){
        StringBuilder cadenita = new StringBuilder();
        cadenita.append("Titulo: " + libro.getTitulo() + '\n');
        cadenita.append("Precio: " + calcularPrecio(libro) + '\n');
        cadenita.append('\n');
        
        return cadenita.toString();
    }  
    
    public int calcularPrecio(Libro libro){
        int precioBase = 0, precioPagina = 0;
        
        if(libro.getTipo() == 1){
            precioBase = 10000;
            precioPagina = 50*libro.getNumeroPaginas();
        }else if(libro.getTipo() == 2){
            precioBase = 15000;
            precioPagina = 70*libro.getNumeroPaginas();
        }else if(libro.getTipo() == 3){
            precioBase = 20000;
            precioPagina = 90*libro.getNumeroPaginas();
        }else{
            precioBase = 25000;
            precioPagina = 120*libro.getNumeroPaginas();
        }
        
        return precioBase + precioPagina;
    }
    
    @Override
    public String toString(){
        StringBuilder cadenita = new StringBuilder();
        for(Libro libro : catalogo){
            if(libro != null){
                cadenita.append(listarLibro(libro));
            }
        }
        return cadenita.toString();
    }
}
