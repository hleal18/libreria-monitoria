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
    
    public Libro buscarLibro(String titulo){
        for(Libro libro : catalogo){
            if(libro != null && libro.getTitulo().equals(titulo)){
                return catalogo[Arrays.asList(catalogo).indexOf(libro)];
            }
        }
        return null;
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
    public String listarLibrosTipo(int tipo){
        StringBuilder cadenita = new StringBuilder();
        for(Libro libro : catalogo){
            if(libro != null && 
                    (libro.getTipo() == tipo || 
                    (libro.getTipo() < 1 || libro.getTipo() > 3) && (tipo < 1 || tipo > 3))){
                cadenita.append(listarLibro(libro));
            }
        }
        return cadenita.toString();
    }
    
    //Prepara un String con el titulo del libro junto con el precio
    private String listarLibro(Libro libro){
        StringBuilder cadenita = new StringBuilder();
        cadenita.append("Titulo: " + libro.getTitulo() + '\n');
        cadenita.append("Precio: " + calcularPrecio(libro) + '\n');
        cadenita.append('\n');
        
        return cadenita.toString();
    }  
    
    private int calcularPrecio(Libro libro){
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
