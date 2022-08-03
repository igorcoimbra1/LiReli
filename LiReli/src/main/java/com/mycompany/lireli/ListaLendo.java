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
public class ListaLendo {
    
    private ArrayList <String> lendo = new ArrayList<>();

    public ListaLendo() {
    }

    public void adicionarLivro(Livro livro){
        lendo.add(livro.listarLendo());
    }

    public int getSize(){
        return lendo.size();
    }
    
    public String getPorIndice(int indice){
        return lendo.get(indice);
    }
    
    public ArrayList<String> getLista()
    {
        return lendo;
    }
    
}
