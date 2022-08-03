/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lireli;

import java.util.ArrayList;

/**
 *
 * @author Igor Coimbra Vargas Lorenzeto 201865045AC e Gabriela Machado Gazola 201865162AB
 */
public class ListaLer {
    
    private ArrayList <String> ler = new ArrayList<>();

    public ListaLer() {
    }

    public void adicionarLivro(Livro livro){
        ler.add(livro.listarLer());
    }

    public int getSize(){
        return ler.size();
    }
    
    public String getPorIndice(int indice){
        return ler.get(indice);
    }
    
    public ArrayList<String> getLista()
    {
        return ler;
    }
}
