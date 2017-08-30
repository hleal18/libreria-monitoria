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
    
    public String listarLibrosTipo(int tipo){
        StringBuilder cadenita = new StringBuilder();
        for(Libro libro : catalogo){
            if(libro != null && libro.getTipo() == tipo){
                cadenita.append(listarLibro(libro));
            }
        }
        return cadenita.toString();
    }
    
    public String listarLibrosPrecio(){
        Libro[] copiaCatalogo = catalogo.clone();
        StringBuilder cadenita = new StringBuilder();
        Libro libroAuxiliar;
        
        for (int i = 0; i < copiaCatalogo.length && copiaCatalogo[i] != null; i++) {
            for (int j = 0; j < copiaCatalogo.length && copiaCatalogo[j] != null; j++) {
                if(calcularPrecio(copiaCatalogo[i]) < calcularPrecio(copiaCatalogo[j])){
                    libroAuxiliar = copiaCatalogo[i];
                    copiaCatalogo[i] = copiaCatalogo[j];
                    copiaCatalogo[j] = libroAuxiliar;
                }
            }
        }
        
        for(Libro libro : copiaCatalogo){
            if(libro != null){
                cadenita.append(listarLibro(libro));
            }
            else
                break;
        }
        
        return cadenita.toString();
    }
    
    public String listarLibrosTitulo(){
        StringBuilder cadenita = new StringBuilder();
        Libro[] copiaCatalogo = catalogo.clone();
        Libro auxiliar;
        
        for (int i = 0; i < copiaCatalogo.length && copiaCatalogo[i] != null; i++) {
            for (int j = 0; j < copiaCatalogo.length && copiaCatalogo[j] != null; j++) {
                if(copiaCatalogo[i].getTitulo().compareTo(copiaCatalogo[j].getTitulo()) < 0){
                    auxiliar = copiaCatalogo[i];
                    copiaCatalogo[i] = copiaCatalogo[j];
                    copiaCatalogo[j] =  auxiliar;
                }
            }
        }
        
        for(Libro libro : copiaCatalogo){
            if(libro != null){
                cadenita.append(listarLibro(libro));
            }
            else
                break;
        }
        
        return cadenita.toString();
    }
    
    //Prepara un String con los datos del libro más el precio.
    private String listarLibro(Libro libro){
        StringBuilder cadenita = new StringBuilder();
        cadenita.append(libro.toString());
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
