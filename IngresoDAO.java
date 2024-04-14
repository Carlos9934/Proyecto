import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngresoDAO {
    private Connection conexion;

    public IngresoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarIngreso(Ingreso ingreso) {
        String query = "INSERT INTO ingresos(concepto, monto, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, ingreso.getConcepto());
            stmt.setDouble(2, ingreso.getMonto());
            stmt.setString(3, ingreso.getFecha());
            stmt.executeUpdate();
            System.out.println("Ingreso agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarIngreso(int idIngreso) {
        String query = "DELETE FROM ingresos WHERE idIngreso = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idIngreso);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Ingreso eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún ingreso con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Ingreso> obtenerTodosLosIngresos() {
        List<Ingreso> listaIngresos = new ArrayList<>();
        String query = "SELECT * FROM ingresos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("idIngreso");
                String concepto = rs.getString("concepto");
                double monto = rs.getDouble("monto");
                String fecha = rs.getString("fecha");
                Ingreso ingreso = new Ingreso(id, concepto, monto, fecha);
                listaIngresos.add(ingreso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaIngresos;
    }

    // Implementa métodos para actualizar, eliminar y otras operaciones según lo necesites.
}