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
public class ListaLido {
    
    private ArrayList <Livro> lido = new ArrayList<>();

    public ListaLido() {
    }

    public void adicionarLivro(Livro livro){
        lido.add(livro);
    }

    public int getSize(){
        return lido.size();
    }
    
    public Livro getPorIndice(int indice){
        return lido.get(indice);
    }
    
    public ArrayList<Livro> getLista()
    {
        return lido;
    }
}
