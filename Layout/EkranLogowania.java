import javax.swing.*;
import java.awt.*;

public class EkranLogowania extends JFrame {

    public EkranLogowania() {
        super("Ekran logowania");

        setLayout(new BorderLayout());

        JPanel panelGlowny = new JPanel(new GridLayout(2, 2, 5, 5));
        panelGlowny.add(new JLabel("Użytkownik:"));
        panelGlowny.add(new JTextField(15));
        panelGlowny.add(new JLabel("Hasło:"));
        panelGlowny.add(new JPasswordField(15));

        JPanel panelPrzyciski = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelPrzyciski.add(new JButton("Zaloguj"));
        panelPrzyciski.add(new JButton("Anuluj"));

        add(panelGlowny, BorderLayout.CENTER);
        add(panelPrzyciski, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EkranLogowania();
    }
}
