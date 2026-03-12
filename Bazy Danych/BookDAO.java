import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Pobieranie wszystkich książek
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT id, tytul, autor, rok_wydania FROM ksiazki";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tytul = rs.getString("tytul");
                String autor = rs.getString("autor");
                int rok = rs.getInt("rok_wydania");

            }

        } catch (SQLException e) {
            System.err.println("Błąd podczas pobierania książek: " + e.getMessage());
        }

        return list;
    }

    // Dodawanie książki
    public void addBook(String tytul, String autor, int rok) {
        String sql = "INSERT INTO ksiazki (tytul, autor, rok_wydania) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tytul);
            ps.setString(2, autor);
            ps.setInt(3, rok);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Błąd podczas dodawania książki: " + e.getMessage());
        }
    }

    // Aktualizacja książki
    public void updateBook(int id, String tytul, String autor, int rok) {
        String sql = "UPDATE ksiazki SET tytul=?, autor=?, rok_wydania=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tytul);
            ps.setString(2, autor);
            ps.setInt(3, rok);
            ps.setInt(4, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Błąd podczas aktualizacji książki: " + e.getMessage());
        }
    }

    // Usuwanie książki
    public void deleteBook(int id) {
        String sql = "DELETE FROM ksiazki WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Błąd podczas usuwania książki: " + e.getMessage());
        }
    }
}
