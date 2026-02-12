import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame
{

    public JTextField poleLogin;
    public JPasswordField poleHaslo;
    public JButton przyciskZaloguj;
    public JLabel etykietaStatusu;

    public GlownyView()
    {
        setTitle("System logowania");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        poleLogin = new JTextField(15);
        poleHaslo = new JPasswordField(15);
        przyciskZaloguj = new JButton("Zaloguj");
        etykietaStatusu = new JLabel(" ");

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JLabel("Login:"));
        panel.add(poleLogin);
        panel.add(new JLabel("Hasło:"));
        panel.add(poleHaslo);

        JPanel panelDolny = new JPanel();
        panelDolny.add(przyciskZaloguj);

        JPanel panelStatus = new JPanel();
        panelStatus.add(etykietaStatusu);

        add(panel, BorderLayout.CENTER);
        add(panelDolny, BorderLayout.SOUTH);
        add(panelStatus, BorderLayout.NORTH);
    }
}
