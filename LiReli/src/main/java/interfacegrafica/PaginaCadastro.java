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
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Igor Coimbra Vargas Lorenzeto 201865045AC e Gabriela Machado Gazola 201865162AB
 */
public class PaginaCadastro implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JLabel mensagem = new JLabel();
    private JTextField username = new JTextField();
    private JPasswordField senha = new JPasswordField();
    private JPasswordField confirmaSenha = new JPasswordField();
    private JButton botaoCadastrar = new JButton();
    private JButton botaoVoltar = new JButton();
    private TitledBorder descricao;

    private FrameLiReli frame = new FrameLiReli();

    private HashMap<String, String> infoLogin = new HashMap<>();
    

    public PaginaCadastro(HashMap<String, String> infoLoginOriginal) {
        infoLogin = infoLoginOriginal;

        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText("Cadastro");
        titulo.setPreferredSize(new Dimension(200, 70));
        titulo.setHorizontalAlignment(JTextField.CENTER);

        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(220, 35));
        mensagem.setHorizontalAlignment(JTextField.CENTER);

        // caixas de texto
        username.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        username.setBackground(new Color(30, 29, 29));
        username.setForeground(Color.white);
        username.setCaretColor(Color.white);
        username.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Username");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        username.setBorder(descricao);
        username.setPreferredSize(new Dimension(200, 50));
        username.setToolTipText("Digite sua name");

        senha.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        senha.setBackground(new Color(30, 29, 29));
        senha.setForeground(Color.white);
        senha.setCaretColor(Color.white);
        senha.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Senha");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        senha.setBorder(descricao);
        senha.setPreferredSize(new Dimension(200, 50));
        senha.setToolTipText("Digite sua senha");

        confirmaSenha.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        confirmaSenha.setBackground(new Color(30, 29, 29));
        confirmaSenha.setForeground(Color.white);
        confirmaSenha.setCaretColor(Color.white);
        confirmaSenha.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descricao = BorderFactory.createTitledBorder("");
        descricao.setTitle("Confirme a senha");
        descricao.setTitleColor(Color.white);
        descricao.setTitleFont(new Font("Sans Serif", Font.ITALIC, 13));
        confirmaSenha.setBorder(descricao);
        confirmaSenha.setPreferredSize(new Dimension(200, 50));
        confirmaSenha.setToolTipText("Digite sua senha novamente");

        //botão
        botaoCadastrar.addActionListener(this);
        botaoCadastrar.setBackground(new Color(214, 53, 106));
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoCadastrar.setPreferredSize(new Dimension(160, 30));
        botaoCadastrar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoCadastrar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoCadastrar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoCadastrar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setForeground(Color.WHITE); // cor da fonte 
        botaoCadastrar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoCadastrar.setToolTipText("Clique para se cadastrar");
        botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoCadastrar.addMouseListener(this);
        
        botaoVoltar.addActionListener(this);
        botaoVoltar.setBackground(new Color(30, 29, 29));
        botaoVoltar.setText("Voltar");
        botaoVoltar.setPreferredSize(new Dimension(200, 30));
        botaoVoltar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoVoltar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoVoltar.setFont(new Font("Sans Serif", Font.ITALIC, 17)); // fonte do texto
        botaoVoltar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoVoltar.setForeground(new Color(115, 115, 115)); // cor da fonte 
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoVoltar.setToolTipText("Clique para voltar à página de login");
        botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoVoltar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(15, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(username);
        panel.add(senha);
        panel.add(confirmaSenha);
        panel.add(mensagem);
        panel.add(botaoCadastrar);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("LiReli - Página de Cadastro");
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoCadastrar) {

            String nomeUsuario = username.getText();
            String senhaUsuario = String.valueOf(senha.getPassword());
            String senhaConfirmada = String.valueOf(confirmaSenha.getPassword());
            
            //controle para não ter dados inconsistentes 
            if (nomeUsuario.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("Username não pode estar em branco");
            } else if (infoLogin.containsKey(nomeUsuario)) { //checa se o nome ja foi utilizado
                mensagem.setForeground(Color.red);
                mensagem.setText("Username já está sendo utilizado");
            } else if (senhaUsuario.equals("")) {
                mensagem.setForeground(Color.red);
                mensagem.setText("A senha não pode estar em branco");
            } else if (!senhaUsuario.equals(senhaConfirmada)) {
                mensagem.setForeground(Color.red);
                mensagem.setText("As senhas não conferem");
            } 
            //caso o username esteja disponível, cadastra ele no banco de dados de login
            else { 
                try {
                    FileWriter fw = new FileWriter("LoginSenha.txt", true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(nomeUsuario + ";" + senhaUsuario);
                    fw.close();
                    pw.close();
                    System.out.println("Cadastro realizado com sucesso");
                } catch (IOException e) {
                    System.out.println("Erro ocorreu ao tentar cadastrar");
                    e.printStackTrace();
                }
                frame.dispose();
                new MenuPrincipal(nomeUsuario); //inicia o menu já com o usuario logado
            }
        }
        else if(ae.getSource() == botaoVoltar) {
            frame.dispose();
            new PaginaLogin(infoLogin);
        }
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
        if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setBackground(new Color(220, 59, 112));
        }else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setBackground(new Color(214, 53, 106));
        }else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(new Color(115, 115, 115));
        }
    }

}

