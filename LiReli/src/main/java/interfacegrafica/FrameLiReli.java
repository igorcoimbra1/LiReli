/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author igorc
 */
public class FrameLiReli extends JFrame {
    
    //modelo de frame padrão do programa. para não precisar ficar editando jframe o tempo todo
    public FrameLiReli(){
        
        ImageIcon icone = new ImageIcon("src/main/java/imagens/logo_mini.png");
        
        this.setIconImage(icone.getImage()); // muda o icone do canto da janela
        this.getContentPane().setBackground(new Color(30,29,29)); // muda a cor de fundo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando clica no X, encerra o programa
        this.setTitle("LiReli"); // título da janela
        this.setVisible(true); // torna visível
        this.setSize(950, 600); // tamanho(largura x altura)
        //this.setLayout(null); // layout
        // this.pack(); // resize o frame
    }
    
}
