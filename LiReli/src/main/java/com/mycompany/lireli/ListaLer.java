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
public class ListaLer {
    
    private ArrayList <Livro> ler = new ArrayList<>();

    public ListaLer() {
    }

    public void adicionarLivro(Livro livro){
        ler.add(livro);
    }

    public int getSize(){
        return ler.size();
    }
    
    public Livro getPorIndice(int indice){
        return ler.get(indice);
    }
    
    public ArrayList<Livro> getLista()
    {
        return ler;
    }
}
