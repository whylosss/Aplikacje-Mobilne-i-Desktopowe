import javax.swing.*;
import java.awt.*;

public class LibraryApp extends JFrame {

    private BookDAO dao = new BookDAO();
    private BookTableModel tableModel;
    private JTable table;

    private JTextField tytulField = new JTextField(15);
    private JTextField autorField = new JTextField(15);
    private JTextField rokField = new JTextField(5);

    public LibraryApp() {
        setTitle("Księgozbiór - CRUD JDBC + Swing");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new BookTableModel(dao.getAllBooks());
        table = new JTable(tableModel);

        JPanel form = new JPanel();
        form.add(new JLabel("Tytuł:"));
        form.add(tytulField);
        form.add(new JLabel("Autor:"));
        form.add(autorField);
        form.add(new JLabel("Rok:"));
        form.add(rokField);

        JButton addBtn = new JButton("Dodaj");
        JButton updateBtn = new JButton("Aktualizuj");
        JButton deleteBtn = new JButton("Usuń");

        form.add(addBtn);
        form.add(updateBtn);
        form.add(deleteBtn);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            dao.addBook(tytulField.getText(), autorField.getText(), Integer.parseInt(rokField.getText()));
            refreshTable();
        });

        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            int id = (int) table.getValueAt(row, 0);
            dao.updateBook(id, tytulField.getText(), autorField.getText(), Integer.parseInt(rokField.getText()));
            refreshTable();
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            int id = (int) table.getValueAt(row, 0);
            dao.deleteBook(id);
            refreshTable();
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) return;

            tytulField.setText(table.getValueAt(row, 1).toString());
            autorField.setText(table.getValueAt(row, 2).toString());
            rokField.setText(table.getValueAt(row, 3).toString());
        });
    }

    private void refreshTable() {
        tableModel.setBooks(dao.getAllBooks());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryApp().setVisible(true));
    }
}
