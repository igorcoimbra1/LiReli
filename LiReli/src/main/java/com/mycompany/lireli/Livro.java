/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lireli;

/**
 *
 * @author igorc
 */
public class Livro {
    private String titulo;
    private String genero;
    private int paginas;
    private String ondeParou;

    public Livro(String titulo, String genero, int paginas, String ondeParou) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.ondeParou = ondeParou;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getOndeParou() {
        return ondeParou;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setOndeParou(String ondeParou) {
        this.ondeParou = ondeParou;
    }
    
    
    
}
