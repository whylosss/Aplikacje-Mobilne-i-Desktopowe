import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FreezeExample extends JFrame
{

    private JLabel statusLabel;
    private JButton startButton;

    public FreezeExample()
    {
        setTitle("Wersja Zawieszająca");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        statusLabel = new JLabel("Status: oczekiwanie...");
        startButton = new JButton("Start");

        startButton.addActionListener((ActionEvent e) ->
        {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                statusLabel.setText("Pracuję... " + (i + 1) + "s");
            }
            statusLabel.setText("Zakończono blokadę.");
        });

        add(startButton);
        add(statusLabel);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new FreezeExample().setVisible(true));
    }
}
