import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo extends JFrame {

    public BoxLayoutDemo() {
        super("BoxLayout Demo (Pionowy)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Etykieta 1"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JTextField(15));
        panel.add(Box.createVerticalGlue());
        panel.add(new JButton("Zapisz"));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutDemo();
    }
}