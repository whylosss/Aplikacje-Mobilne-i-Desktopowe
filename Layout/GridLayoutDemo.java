import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame {

    public GridLayoutDemo() {
        super("GridLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i <= 12; i++) {
            add(new JButton("Cell " + i));
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutDemo();
    }
}