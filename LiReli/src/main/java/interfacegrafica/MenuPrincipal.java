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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author igorc
 */
public class MenuPrincipal implements ActionListener, MouseListener {
    private ImageIcon logo = new ImageIcon("src/main/java/imagens/logo.png");
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton botaoLer = new JButton("Ler");
    private JButton botaoLendo = new JButton("Lendo");
    private JLabel logoLiReli = new JLabel();
    private FrameLiReli frame = new FrameLiReli();
    
    private String usuarioAtivo;

    public MenuPrincipal(String nomeUsuario) {
        
        usuarioAtivo = nomeUsuario;
        
        // a logo
        logoLiReli.setIcon(logo);
        logoLiReli.setHorizontalTextPosition((JLabel.CENTER));
        logoLiReli.setVerticalTextPosition(JLabel.CENTER);
        logoLiReli.setVerticalAlignment(JLabel.CENTER); // posiciona verticalmente icone+texto dentro da label
        logoLiReli.setHorizontalAlignment(JLabel.CENTER);

        // botao Ler
        botaoLer.addActionListener(this);
        botaoLer.setBackground(new Color(214, 53, 106));
        botaoLer.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoLer.setPreferredSize(new Dimension(200, 50));
        botaoLer.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoLer.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoLer.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoLer.setForeground(Color.WHITE); // cor da fonte 
        botaoLer.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoLer.setSize(60, 20);
        botaoLer.setToolTipText("Clique para abrir o Menu Ler");
        botaoLer.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoLer.addMouseListener(this);

        // botao Lendo
        botaoLendo.addActionListener(this);
        botaoLendo.setBackground(new Color(214, 53, 106));
        botaoLendo.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoLendo.setPreferredSize(new Dimension(200, 50));
        botaoLendo.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoLendo.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoLendo.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoLendo.setForeground(Color.WHITE); // cor da fonte 
        botaoLendo.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoLendo.setSize(60, 20);
        botaoLendo.setToolTipText("Clique para abrir o Menu Lendo");
        botaoLendo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoLendo.addMouseListener(this);

        // paineis
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        panel2.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel2.add(botaoLer);
        panel2.add(botaoLendo);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1)); // GridLaytou(lunhas, colunas, margem vertical, margem horizontal)
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel.add(logoLiReli);
        panel.add(panel2);

        // frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("LiReli - Menu Principal");
    }
    
    public String getUsuarioAtivo(){
        return usuarioAtivo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //encaminha para os menus a depender do botao clicado
        if (e.getSource() == botaoLer) {
            frame.dispose(); // fecha a janela anterior (MenuPrincipal) para não ficar com duas abertas
            new MenuLer(usuarioAtivo);
        }
        if (e.getSource() == botaoLendo) {
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
        if (me.getSource() == botaoLer) {
            botaoLer.setBackground(new Color(220, 59, 112));
        }
        if (me.getSource() == botaoLendo) {
            botaoLendo.setBackground(new Color(220, 59, 112));
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoLer) {
            botaoLer.setBackground(new Color(214, 53, 106));
        }
        if (me.getSource() == botaoLendo) {
            botaoLendo.setBackground(new Color(214, 53, 106));
        }
    }
}
