/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 *
 * @author igorc
 */
public class AdicionarLivro implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JButton botaoAdicionar = new JButton();
    private JButton botaoVoltar = new JButton();
    private JLabel mensagem = new JLabel();
    private JTextField titulo = new JTextField();
    private JTextField genero = new JTextField();
    private JTextField autor = new JTextField();
    private JTextField paginas = new JTextField();
    private JTextField obrigatorio = new JTextField();
    private TitledBorder descricao;

    private FrameLiReli frame = new FrameLiReli();

    private String usuarioAtivo;
    private String situacao;

    public AdicionarLivro(String nomeUsuario, String status) {

        usuarioAtivo = nomeUsuario;
        situacao = status;

        // caixas de texto
        titulo.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setCaretColor(Color.white);
        titulo.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder(""); //borda com título
        descricao.setTitle("Título*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        titulo.setBorder(descricao);
        titulo.setPreferredSize(new Dimension(250, 50));
        titulo.setToolTipText("Título do Livro");

        genero.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        genero.setBackground(new Color(30, 29, 29));
        genero.setForeground(Color.white);
        genero.setCaretColor(Color.white);
        genero.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Gênero*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        genero.setBorder(descricao);
        genero.setPreferredSize(new Dimension(250, 50));
        genero.setToolTipText("Gênero do livro");

        autor.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        autor.setBackground(new Color(30, 29, 29));
        autor.setForeground(Color.white);
        autor.setCaretColor(Color.white);
        autor.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Autor*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        autor.setBorder(descricao);
        autor.setPreferredSize(new Dimension(250, 50));
        autor.setToolTipText("Autor do livro");

        paginas.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        paginas.setBackground(new Color(30, 29, 29));
        paginas.setForeground(Color.white);
        paginas.setCaretColor(Color.white);
        paginas.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Páginas*");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        paginas.setBorder(descricao);
        paginas.setPreferredSize(new Dimension(250, 50));
        paginas.setToolTipText("Quantidade de Páginas");

        obrigatorio.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        obrigatorio.setBackground(new Color(30, 29, 29));
        obrigatorio.setForeground(new Color(115, 115, 115));
        obrigatorio.setBorder(BorderFactory.createEmptyBorder());
        obrigatorio.setText("* Campo obrigatório");
        obrigatorio.setEditable(false);
        obrigatorio.setEnabled(false);
        obrigatorio.setPreferredSize(new Dimension(500, 20));
        obrigatorio.setHorizontalAlignment(JTextField.CENTER);
        
        //label
        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(500, 35));
        mensagem.setHorizontalAlignment(JTextField.CENTER);

        //botões
        botaoAdicionar.addActionListener(this);
        botaoAdicionar.setBackground(new Color(248, 161, 31));
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAdicionar.setPreferredSize(new Dimension(150, 30));
        botaoAdicionar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAdicionar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAdicionar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAdicionar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAdicionar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAdicionar.setForeground(Color.WHITE); // cor da fonte 
        botaoAdicionar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAdicionar.setSize(60, 20);
        botaoAdicionar.setToolTipText("Clique para adicionar o livro");
        botaoAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAdicionar.addMouseListener(this);

        botaoVoltar.addActionListener(this);
        botaoVoltar.setBackground(new Color(30, 29, 29));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(800, 30));
        botaoVoltar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoVoltar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoVoltar.setFont(new Font("Sans Serif", Font.ITALIC, 17)); // fonte do texto
        botaoVoltar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setForeground(new Color(115, 115, 115)); // cor da fonte 
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoVoltar.setToolTipText("Clique para voltar");
        botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoVoltar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(70, 100, 100, 100));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(genero);
        panel.add(autor);
        panel.add(paginas);
        panel.add(obrigatorio);
        panel.add(mensagem);
        panel.add(botaoAdicionar);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("LiReli - Adicionar Livro");
        frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
        frame.setSize(780, 520);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //muda de cor o botão caso o mouse esteja por cima dele, para dar uma resposta visual ao usuario
        if (me.getSource() == botaoAdicionar) {
            botaoAdicionar.setBackground(new Color(255, 183, 76));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //muda de cor o botão caso o mouse esteja fora dele (padrão)
        if (me.getSource() == botaoAdicionar) {
            botaoAdicionar.setBackground(new Color(248, 161, 31));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(new Color(115, 115, 115));
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // caso o usuario clique no botaoAdicionar
        if (ae.getSource() == botaoAdicionar) {
            
            //armazena as informações coletadas das caixas de texto em variáveis do tipo string, para facilitar a comparação posterior
            String tituloLivro = titulo.getText();
            String generoLivro = genero.getText();
            String autorLivro = autor.getText();
            String paginasLivro = paginas.getText();
            
            // checa se nenhum campo foi deixado em branco
            if (tituloLivro.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Título não pode estar em branco");
            } else if (generoLivro.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Gênero não pode estar em branco");
            } else if (autorLivro.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("autor não pode estar em branco");
            } else if (paginasLivro.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Páginas não pode estar em branco");
            } 
            // com todas as informações preenchidas, o programa vai escreve-las na base de dados
            else {
                try {
                    // abre o arquivo da base de dados, para fazer um apendice com as informações de um novo Livro
                    FileWriter fw = new FileWriter("BaseLivros.txt", true);
                    PrintWriter pw = new PrintWriter(fw); //print writer apresenta funcionalidades mais úteis
                    //o formato a ser escrito no artigo segue o padrão: nomeDoUsuario;títuloDoLivro;generoLivro;autor;paginas;status
                    // o nomedeusuário é unico, portanto serve como identificador
                    // a variável situação vai indicar se o Livro está para ser lido ou se está sendo lido. Caso esteja sendo lido, o campo indica onde parou 
                    pw.println(usuarioAtivo + ";" + tituloLivro + ";" + generoLivro
                            + ";" + autorLivro + ";" + paginasLivro
                            + ";" + situacao);
                    fw.close();
                    pw.close();
                    System.out.println("Livro adicionado com sucesso"); //apenas controle
                } catch (IOException e) {
                    System.out.println("Erro ocorreu ao tentar adicionar o livro");
                    e.printStackTrace();
                }
                //condicional para saber para qual menu o programa deve voltar, uma vez que Adicionar Livro está presente em mais de um menu
                // é importante abrir um novo menu do qual saiu, pois, assim, ele irá "recarregar" e trazer a info atualizada do livro recém adicionado
                if (situacao.equals("ler")) {
                    frame.dispose();
                    new MenuLer(usuarioAtivo);
                } else if (situacao.equals("lendo")) {
                    frame.dispose();
                    new MenuLendo(usuarioAtivo);
                }
            }
        } else if (ae.getSource() == botaoVoltar) { //mesma condicional descrita acima
            if (situacao.equals("ler")) {
                frame.dispose();
                new MenuLer(usuarioAtivo);
            } else if (situacao.equals("lendo")) {
                frame.dispose();
                new MenuLendo(usuarioAtivo);
            }
        }
    }
}
