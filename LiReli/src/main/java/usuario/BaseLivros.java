/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.mycompany.lireli.Livro;
import com.mycompany.lireli.ListaLendo;
import com.mycompany.lireli.ListaLer;


/**
 *
 * @author Igor Coimbra Vargas Lorenzeto 201865045AC e Gabriela Machado Gazola 201865162AB
 */
public class BaseLivros {
    
    private ListaLer listaLer = new ListaLer();
    private ListaLendo listaLendo = new ListaLendo();

    public BaseLivros() {
    }

    public ListaLer getListaLer() {
        return listaLer;
    }

    public ListaLendo getListaLendo() {
        return listaLendo;
    }

    public void carregaBaseDados(String nomeUsuarioAtivo) {

        BufferedReader br = null;
        try {
            // Cria o objeto para o arquivo
            File arqv = new File("BaseLivros.txt");

            // Cria BufferedReader para ajudar na leitura do arquivo
            br = new BufferedReader(new FileReader(arqv));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;
                String username = infos[0].trim();

                // checar se a linha corresponde a um livro do usuario ativo
                if (username.equals(nomeUsuarioAtivo)) {

                    if (infos.length == 6) { //a linha indica um livro
                        Livro f = new Livro();
                        f.cadastro(infos[1], infos[2], infos[3], infos[4], infos[5]);

                        if (infos[5].equals("ler")) {
                            listaLer.adicionarLivro(f);
                        } else {
                            listaLendo.adicionarLivro(f);
                        }
                    }
                    }
                }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO CONSTRUTOR DE BASE LIVROS");

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                };
            }
        }
    }
    
    //a ação de apagar funciona reescrevendo o arquivo em um auxiliar, excluindo o que se pretende apagar,
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void apagarLivro(String usuarioAtivo, String tituloLivro) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseLivros.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseLivros.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "livro";
                } 

                // caso não seja o usuario e o livro que estamos procurando, copiamos a linha para o novo arquivo
                if (!username.equals(usuarioAtivo) || !titulo.equals(tituloLivro)) {
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseLivros.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO APAGAR LIVRO");
        }
    }

    //a edição funciona reescrevendo o arquivo em um auxiliar, acrescentando o que se pretende mudar, 
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void editarPagina(String usuarioAtivo, String tituloLivro, String novoOndeParou) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseLivros.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseLivros.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                System.out.print(" infos0: " + infos[0]);
                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "livro";
                } 

                // se for a linha do livro que se busca editar, altera a linha
                if (username.equals(usuarioAtivo) && titulo.equals(tituloLivro)) {
                    
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + "onde parou: " + novoOndeParou);
                    
                } else { //senao, apenas copia para o novo arquivo
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseLivros.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO EDITAR ONDE PAROU LIVRO");
        }
    }

    //a edição funciona reescrevendo o arquivo em um auxiliar, acrescentando o que se pretende mudar, 
    //depois apga o arquivo antigo e, por fim, troca o nome do auxiliar para o nome do antigo
    public void editarStatus(String usuarioAtivo, String tituloLivro, String novoStatus) {
        String arqvAux = "temporario.txt";
        File arqvAntigo = new File("BaseLivros.txt");
        File arqvNovo = new File(arqvAux);
        try {
            arqvNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("ERRO AO CRIAR ARQV");
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(arqvAux, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br = new BufferedReader(new FileReader("BaseLivros.txt"));

            // para ler cada linha do arquivo
            String linha = null;

            while ((linha = br.readLine()) != null) {

                String[] infos = linha.split(";"); // separa a linha quando encontrar ;

                System.out.print(" infos0: " + infos[0]);
                String username = "";
                String titulo = "";
                String categoria = "";

                if (infos.length == 6) {
                    username = infos[0].trim();
                    titulo = infos[1].trim();
                    categoria = "livro";
                } 

                // se for a linha do livro que se busca editar, altera a linha
                if (username.equals(usuarioAtivo) && titulo.equals(tituloLivro)) {
                    if (categoria.equals("livro")) {
                        pw.println(infos[0] + ";" + infos[1] + ";" + infos[2] + ";" + infos[3] + ";"
                                + infos[4] + ";" + novoStatus);
                    } 
                } else { //senao, apenas copia para o novo arquivo
                    pw.println(linha);
                }
            }

            pw.flush();
            pw.close();
            fw.close();
            bw.close();
            br.close();

            //apaga o arquivo antigo e renomeia o arquvio novo, que está sem os dados que apagamos
            arqvAntigo.delete();
            File criador = new File("BaseLivros.txt");
            arqvNovo.renameTo(criador);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO NO METODO EDITAR STATUS LIVRO");
        }
    }
}

