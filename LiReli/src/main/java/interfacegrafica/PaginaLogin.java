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
import java.util.ArrayList;
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
 * @author igorc
 */
public class PaginaLogin implements ActionListener, MouseListener {

    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JLabel mensagem = new JLabel();
    private JTextField username = new JTextField();
    private JPasswordField senha = new JPasswordField();
    private JButton botaoCadastrar = new JButton();
    private JButton botaoEntrar = new JButton();
    private TitledBorder descricao;

    private FrameLiReli frame = new FrameLiReli();

    private HashMap<String, String> infoLogin = new HashMap<String, String>();
    private ArrayList<String> listaAssistir = new ArrayList<String>();

    public PaginaLogin(HashMap<String, String> infoLoginOriginal) {
        
        infoLogin = infoLoginOriginal;

        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText("Login");
        titulo.setPreferredSize(new Dimension(200, 70));
        titulo.setHorizontalAlignment(JTextField.CENTER);

        mensagem.setFont(new Font("Sans Serif", Font.ITALIC, 13));
        mensagem.setBackground(new Color(30, 29, 29));
        mensagem.setForeground(Color.white);
        mensagem.setBorder(BorderFactory.createEmptyBorder());
        mensagem.setText("");
        mensagem.setPreferredSize(new Dimension(200, 35));
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
        username.setToolTipText("Digite seu nome");

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

        //botoes
        botaoCadastrar.addActionListener(this);
        botaoCadastrar.setBackground(new Color(30, 29, 29));
        botaoCadastrar.setText("Cadastrar-se");
        botaoCadastrar.setPreferredSize(new Dimension(200, 30));
        botaoCadastrar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoCadastrar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoCadastrar.setFont(new Font("Sans Serif", Font.ITALIC, 17)); // fonte do texto
        botaoCadastrar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoCadastrar.setForeground(new Color(115, 115, 115)); // cor da fonte 
        botaoCadastrar.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoCadastrar.setToolTipText("Clique para se cadastrar");
        botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoCadastrar.addMouseListener(this);

        botaoEntrar.addActionListener(this);
        botaoEntrar.setBackground(new Color(248, 161, 31));
        botaoEntrar.setText("Entrar");
        botaoEntrar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoEntrar.setPreferredSize(new Dimension(160, 30));
        botaoEntrar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoEntrar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoEntrar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoEntrar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoEntrar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoEntrar.setForeground(Color.WHITE); // cor da fonte 
        botaoEntrar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoEntrar.setToolTipText("Clique para entrar");
        botaoEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoEntrar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(15, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(username);
        panel.add(senha);
        panel.add(mensagem);
        panel.add(botaoEntrar);
        panel.add(botaoCadastrar);

        // frame
        frame.setTitle("LiReli - Página de Login");
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoEntrar) {

            String nomeUsuario = username.getText();
            String senhaUsuario = String.valueOf(senha.getPassword());
            
            //busca a informação do usuario no banco de dados (hashmap)
            if (infoLogin.containsKey(nomeUsuario)) {
                if (infoLogin.get(nomeUsuario).equals(senhaUsuario)) {
                    mensagem.setForeground(Color.green);
                    mensagem.setText("Logado com sucesso");
                    frame.dispose();
                    new MenuPrincipal(nomeUsuario); //loga no menu principal usando a chave, no caso, o nome do usuario
                } else {
                    mensagem.setForeground(Color.red);
                    mensagem.setText("Senha incorreta");
                }
            } else {
                mensagem.setForeground(Color.red);
                mensagem.setText("Usuario não existe");
            }
        }
        //leva para a página de cadastro
        if (ae.getSource() == botaoCadastrar) {
            frame.dispose();
            PaginaCadastro pgCadastro = new PaginaCadastro(infoLogin);
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
        if (me.getSource() == botaoEntrar) {
            botaoEntrar.setBackground(new Color(255, 183, 76));
        } else if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoEntrar) {
            botaoEntrar.setBackground(new Color(248, 161, 31));
        } else if (me.getSource() == botaoCadastrar) {
            botaoCadastrar.setForeground(new Color(115, 115, 115));
        }
    }

}

