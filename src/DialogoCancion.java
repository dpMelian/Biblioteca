package Biblioteca;

/**
 * Created by dpMelian on 12/12/2016.
 */
import javax.swing.*;
import java.awt.*;

public class DialogoCancion{

    public void dialogoCancion() {
        JFrame frame = new JFrame("");
        JPanel p = new JPanel(new BorderLayout(5,5));
        JPanel labels = new JPanel(new GridLayout(0,2));

        labels.add(new JLabel("Título: ", SwingConstants.LEFT));
        JTextField title = new JTextField();
        labels.add(title);

        labels.add(new JLabel("Intérprete: ", SwingConstants.LEFT));
        JTextField author = new JTextField();
        labels.add(author);

        labels.add(new JLabel("Duración: ", SwingConstants.LEFT));
        JTextField duration = new JTextField();
        labels.add(duration);

        p.add(labels, BorderLayout.CENTER);

        JOptionPane.showConfirmDialog(frame, p, "", JOptionPane.OK_CANCEL_OPTION);

        try{
            Cancion c = new Cancion(title.getText(), author.getText(), Integer.parseInt(duration.getText()));
            DialogoAlbum.getCurrent().añadeCanción(c);
            DialogoAlbum.getLista().setText(DialogoAlbum.getCurrent().toString());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(p, "La duración introducida no es un entero",
                    "Error" , JOptionPane.ERROR_MESSAGE);
        }
    }
}
