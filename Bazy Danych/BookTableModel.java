import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {

    private List<Book> books;
    private final String[] columns = {"ID", "Tytuł", "Autor", "Rok"};

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() { return books.size(); }

    @Override
    public int getColumnCount() { return columns.length; }

    @Override
    public String getColumnName(int col) { return columns[col]; }

    @Override
    public Object getValueAt(int row, int col) {
        Book b = books.get(row);
        return switch (col) {
            case 0 -> b.getId();
            case 1 -> b.getTytul();
            case 2 -> b.getAutor();
            case 3 -> b.getRokWydania();
            default -> null;
        };
    }
}
