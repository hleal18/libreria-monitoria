/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author usuario
 */
public class Libro {
    private String titulo;
    private int codigo;
    private int numeroPaginas;
    private int tipo;
    
    public Libro(){
        
    }
    
    public Libro(String titulo, int codigo, int numeroPaginas, int tipo){
        this.titulo = titulo;
        this.codigo = codigo;
        this.numeroPaginas = numeroPaginas;
        this.tipo = tipo;
    }
    
    public String getTitulo(){ return titulo; }
    public int getCodigo(){ return codigo; }
    public int getNumeroPaginas(){ return numeroPaginas; }
    public int getTipo(){ return tipo; }
    
    public void setTitulo(String titulo){ this.titulo = titulo; }
    public void setCodigo(int codigo){ this.codigo = codigo; }
    public void setNumeroPaginas(int numeroPaginas){ this.numeroPaginas = numeroPaginas; }
    public void setTipo(int tipo){ this.tipo = tipo; }
    
    @Override
    public String toString(){
        StringBuilder cadenita;
        cadenita = new StringBuilder("Titulo: " + this.titulo + '\n' +
                "Codigo: " + this.codigo + "\n" +
                        "Numero de paginas: " + this.numeroPaginas + "\n" +
                                "Tipo: " + this.tipo + "\n");
        return cadenita.toString();
    }
}
