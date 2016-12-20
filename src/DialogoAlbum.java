package Biblioteca;

/**
 * Created by dpMelian on 12/12/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoAlbum extends JDialog implements ActionListener {
    private static JTextArea lista;
    private JFrame newAlbum;
    private JButton add;
    private JButton finish;
    private JButton cancel;
    private static Album current;
    private String name = "";

    public void dialogoAlbum(){
        JFrame createAlbum = new JFrame("");
        name = JOptionPane.showInputDialog(createAlbum,
                "Introduzca el nombre del álbum", "Crear álbum", JOptionPane.PLAIN_MESSAGE);
        if (name != null && name.length() > 0) {
            current = new Album(name);
            newAlbum();
        }
    }
    public void newAlbum() {
        newAlbum = new JFrame("Nuevo álbum");
        newAlbum.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newAlbum.setSize(350, 250);
        Container p = getContentPane();
        lista = new JTextArea(20,25);
        add = new JButton("Añadir canción");
        finish = new JButton("Finalizar álbum");
        cancel = new JButton("Cancelar");
        add.addActionListener(this);
        finish.addActionListener(this);
        cancel.addActionListener(this);
        p.add(new JScrollPane(lista),BorderLayout.CENTER);
        JPanel rellenoBotón = new JPanel();
        rellenoBotón.add(add);
        p.add(rellenoBotón,BorderLayout.WEST);
        JPanel subPanel = new JPanel();

        subPanel.add(finish);
        subPanel.add(cancel);
        newAlbum.add(subPanel, BorderLayout.SOUTH);

        lista.setEditable(false);
        lista.setText(current.toString());
        newAlbum.add(p);
        pack();
        newAlbum.setLocationRelativeTo(null);
        newAlbum.setVisible(true);
    }
    public static Album getCurrent(){
        return current;
    }
    public static JTextArea getLista(){
        return lista;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            DialogoCancion c = new DialogoCancion();
            c.dialogoCancion();
        } else if(e.getSource() == cancel){
            newAlbum.dispose();
        } else if(e.getSource() == finish){
            BibliotecaGUI.getMiBiblioteca().añadeÁlbum(current);
            BibliotecaGUI.getLista().setText(BibliotecaGUI.getMiBiblioteca().toString());
            newAlbum.dispose();
        }
    }
}