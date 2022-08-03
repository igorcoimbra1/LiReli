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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static javax.swing.ScrollPaneConstants.*;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.mycompany.lireli.*;
import usuario.BaseLivros;
/**
 *
 * @author igorc
 */
public class MenuLer implements ActionListener, MouseListener, ListSelectionListener{
    
    private String[] padrao = {"Não há nada para Ler agora. Adicione mais Livros a sua lista!"};

    private ImageIcon plus = new ImageIcon("src/main/java/imagens/plus_icon.png");
    private ImageIcon home = new ImageIcon("src/main/java/imagens/home_icon.png");
    private ImageIcon homeBranca = new ImageIcon("src/main/java/imagens/home_icon_branca.png");

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JList lista = new JList();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton botaoAddLivro = new JButton();
    private JButton botaoHome = new JButton();
    private FrameLiReli frame = new FrameLiReli();

    private String usuarioAtivo;
    private ListaLer listaLer;
    private BaseLivros baseDados = new BaseLivros();

    public MenuLer(String nomeUsuario) {

        // pega as informaçoes atualizadas da base de dados
        usuarioAtivo = nomeUsuario;
        baseDados.carregaBaseDados(nomeUsuario);
        listaLer = baseDados.getListaLer();

        // botoes
        botaoAddLivro.addActionListener(this);
        botaoAddLivro.setBackground(new Color(248, 161, 31));
        botaoAddLivro.setText("Livro");
        botaoAddLivro.setIcon(plus);
        botaoAddLivro.setIconTextGap(10);
        botaoAddLivro.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoAddLivro.setPreferredSize(new Dimension(120, 30));
        botaoAddLivro.setHorizontalTextPosition((JButton.RIGHT)); // alinhamento horizontal do texto
        botaoAddLivro.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoAddLivro.setFont(new Font("Sans Serif", Font.BOLD, 20)); // fonte do texto
        botaoAddLivro.setHorizontalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAddLivro.setVerticalAlignment(JButton.CENTER); // alinhamento dentro do panel
        botaoAddLivro.setForeground(Color.WHITE); // cor da fonte 
        botaoAddLivro.setBorder(BorderFactory.createRaisedSoftBevelBorder()); // altera a borda do botão
        botaoAddLivro.setSize(60, 20);
        botaoAddLivro.setToolTipText("Clique para adicionar um Livro");
        botaoAddLivro.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoAddLivro.addMouseListener(this);

        botaoHome.addActionListener(this);
        botaoHome.setBackground(new Color(30, 29, 29));
        botaoHome.setOpaque(true);
        botaoHome.setIcon(home);
        botaoHome.setFocusable(false); // tira a marquinha que fica no texto do botão
        botaoHome.setPreferredSize(new Dimension(20, 20));
        botaoHome.setHorizontalTextPosition((JButton.CENTER)); // alinhamento horizontal do texto
        botaoHome.setVerticalTextPosition(JButton.CENTER); // alinhamento vertical do texto
        botaoHome.setBorder(BorderFactory.createEmptyBorder()); // altera a borda do botão
        botaoHome.setToolTipText("Clique para voltar para o Menu Principal");
        botaoHome.setCursor(new Cursor(Cursor.HAND_CURSOR)); // muda o cursor
        botaoHome.addMouseListener(this);

        // panel                
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 0));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panel2.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel2.add(botaoAddLivro);

        panel3.setBorder(BorderFactory.createEmptyBorder(40, 0, 30, 25));
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel3.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel3.add(botaoHome);

        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setLayout(new GridLayout(0, 2, 0, 0));
        panel.setBackground(new Color(30, 29, 29)); // muda a cor de fundo
        panel.setPreferredSize(new Dimension(100, 90));
        panel.add(panel2);
        panel.add(panel3);

        //list
        if (listaLer.getSize() == 0) {
            lista.setListData(padrao);
            lista.setFont(new Font("Sans Serif", Font.ITALIC, 20));
            lista.setForeground(new Color(115, 115, 115));
        } else {
            lista.setListData(listaLer.getLista().toArray());
            lista.setFont(new Font("Sans Serif", Font.PLAIN, 20));
            lista.setForeground(Color.WHITE);
        }
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setSize(630, 490);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setLayoutOrientation(JList.VERTICAL);
        lista.setVisibleRowCount(-1);
        lista.setBackground(new Color(34, 34, 34));
        lista.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lista.addListSelectionListener(this);

        // scroll pane
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 13, 13, 13));
        //scrollPane.setViewportBorder(BorderFactory.createEmptyBorder(0, 13, 13, 13));
        scrollPane.setOpaque(true);
        scrollPane.setBackground(new Color(30, 29, 29));
        scrollPane.setVisible(true);
        scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(lista);
        scrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // frame
        frame.setTitle("LiReli - Menu Preciso Ler");
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botaoAddLivro) {
            new AdicionarLivro(usuarioAtivo, "Ler");
            frame.dispose();
        }

        if (ae.getSource() == botaoHome) {
            frame.dispose();
            new MenuPrincipal(usuarioAtivo);
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
        if (me.getSource() == botaoAddLivro) {
            botaoAddLivro.setBackground(new Color(255, 183, 76));
        }
        if (me.getSource() == botaoHome) {
            botaoHome.setIcon(homeBranca);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == botaoAddLivro) {
            botaoAddLivro.setBackground(new Color(248, 161, 31));
        }
        if (me.getSource() == botaoHome) {
            botaoHome.setIcon(home);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int index = lista.getSelectedIndex();
        
        //caso a lista esteja com algum elemento selecionado
        if (index != -1) {
            String s = listaLer.getPorIndice(index);
            String divisor = "   -   ";
            String[] infos = s.split(divisor);

            String categoria = infos[0].substring(1, 6); //nome da categoria
            categoria = categoria.toLowerCase();
            String titulo = infos[0].substring(10); //titulo do livro

            //chama o menu de açoes possiveis para aquele item
   
            frame.dispose();
        }
    }
}
