/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lireli;

/**
 *
 * @author Igor Coimbra Vargas Lorenzeto 201865045AC e Gabriela Machado Gazola 201865162AB
 */
public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private String paginas;
    private String ondeParou;
    protected String status;

    public Livro() {
       
    }
    
    public void cadastro(String titulo, String genero, String paginas, String status) {
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
        this.status = status;
    }
    
    public void editarOndeParou(String onde){
        ondeParou = onde;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getPaginas() {
        return paginas;
    }

    public String getOndeParou() {
        return ondeParou;
    }

    public String getAutor() {
        return autor;
    }

    public String getStatus() {
        return status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public void setOndeParou(String ondeParou) {
        this.ondeParou = ondeParou;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String listarLendo(){
        if(status.equals("lendo")){
            return ("[LIVRO]   " + titulo + "   -   "  + autor + "   -   "  + genero + "   -   "  + paginas + "   -   clique para atualizar onde parou");
        }
        return ("[Livro]   " + titulo + "   -   " + autor + "   -   " + genero + "   -   " + paginas + "   -   " + ondeParou);
    }
    
    public String listarLer(){
        return ("[Livro]   " + titulo + "   -   " + autor + "   -   " + genero + "   -   " + paginas);
    }
    
}
