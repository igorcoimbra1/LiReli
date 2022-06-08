/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lireli;

import java.util.ArrayList;

/**
 *
 * @author igorc
 */
public class ListaLendo {
    
    private ArrayList <Livro> lendo = new ArrayList<>();

    public ListaLendo() {
    }

    public void adicionarLivro(Livro livro){
        lendo.add(livro);
    }

    public int getSize(){
        return lendo.size();
    }
    
    public Livro getPorIndice(int indice){
        return lendo.get(indice);
    }
    
    public ArrayList<Livro> getLista()
    {
        return lendo;
    }
    
}
