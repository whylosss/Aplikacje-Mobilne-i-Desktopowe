import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SwingWorkerDemo extends JFrame
{

    private JLabel statusLabel;
    private JButton startButton;

    public SwingWorkerDemo()
    {
        setTitle("Naprawiona wersja");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        startButton = new JButton("Start");
        startButton.setBounds(100, 20, 100, 30);
        add(startButton);

        statusLabel = new JLabel("Status...");
        statusLabel.setBounds(100, 70, 200, 30);
        add(statusLabel);

        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                SwingWorker<Void, String> worker = new SwingWorker<Void, String>()
                {

                    @Override
                    protected Void doInBackground() throws Exception
                    {
                        for (int i = 0; i < 5; i++)
                        {
                            Thread.sleep(1000);
                            publish("Pracuję... " + (i + 1) + "s");
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<String> chunks)
                    {
                        statusLabel.setText(chunks.get(chunks.size() - 1));
                    }

                    @Override
                    protected void done()
                    {
                        statusLabel.setText("Zakończono pomyślnie!");
                    }
                };

                worker.execute();
            }
        });
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new SwingWorkerDemo().setVisible(true));
    }
}
