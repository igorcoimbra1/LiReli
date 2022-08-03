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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import usuario.BaseLivros;
/**
 *
 * @author igorc
 */
public class ExcluirAtualizar implements ActionListener, MouseListener {
    private JPanel panel = new JPanel();

    private JLabel titulo = new JLabel();
    private JButton botaoExcluir = new JButton();
    private JButton botaoAtualizar = new JButton();
    private JButton botaoVoltar = new JButton();

    private FrameLiReli frame = new FrameLiReli();

    private String usuarioAtivo;
    private String tituloS;
    private String categoria;
    private BaseLivros baseDados = new BaseLivros();

    public ExcluirAtualizar(String nomeUsuario, String tituloLivro) {

        usuarioAtivo = nomeUsuario;
        tituloS = tituloLivro;

        //labels
        titulo.setFont(new Font("Sans Serif", Font.BOLD, 26));
        titulo.setBackground(new Color(30, 29, 29));
        titulo.setForeground(Color.white);
        titulo.setBorder(BorderFactory.createEmptyBorder());
        titulo.setText(tituloS);
        titulo.setPreferredSize(new Dimension(220, 120));
        titulo.setHorizontalAlignment(JTextField.CENTER);

        //botão
        botaoExcluir.addActionListener(this);
        botaoExcluir.setBackground(new Color(248, 161, 31));
        botaoExcluir.setText("Excluir");
        botaoExcluir.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoExcluir.setPreferredSize(new Dimension(160, 30));
        botaoExcluir.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoExcluir.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoExcluir.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoExcluir.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoExcluir.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoExcluir.setForeground(Color.WHITE); // cor da fonte 
        botaoExcluir.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoExcluir.setToolTipText("Clique para excluir");
        botaoExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoExcluir.addMouseListener(this);

        botaoAtualizar.addActionListener(this);
        botaoAtualizar.setBackground(new Color(248, 161, 31));
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAtualizar.setPreferredSize(new Dimension(160, 30));
        botaoAtualizar.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAtualizar.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAtualizar.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAtualizar.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAtualizar.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAtualizar.setForeground(Color.WHITE); // cor da fonte 
        botaoAtualizar.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAtualizar.setToolTipText("Clique para atualizar");
        botaoAtualizar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAtualizar.addMouseListener(this);

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
        botaoVoltar.setToolTipText("Clique para voltar");
        botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoVoltar.addMouseListener(this);

        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo  
        panel.add(titulo);
        panel.add(botaoExcluir);
        panel.add(botaoAtualizar);
        panel.add(botaoVoltar);

        // frame
        frame.setTitle("LiReli - Excluir ou Atualizar");
        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAtualizar) {
            frame.dispose();
            new PaginaEditarLivro(usuarioAtivo, tituloS);
        } else if (ae.getSource() == botaoVoltar) {
            frame.dispose();
            new MenuLendo(usuarioAtivo);
        } else if (ae.getSource() == botaoExcluir) {
            
            //apaga um livro do banco de dados chamando seu metodo
            baseDados.apagarLivro(usuarioAtivo, tituloS);
            frame.dispose();
            new MenuLendo(usuarioAtivo);
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
        if (me.getSource() == botaoAtualizar) {
            botaoAtualizar.setBackground(new Color(255, 183, 76));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAtualizar) {
            botaoAtualizar.setBackground(new Color(248, 161, 31));
        } else if (me.getSource() == botaoVoltar) {
            botaoVoltar.setForeground(new Color(115, 115, 115));
        }
    }
}
