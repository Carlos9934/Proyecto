import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoDAO {
    private Connection conexion;

    public GastoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarGasto(Gasto gasto) {
        String query = "INSERT INTO gastos(concepto, monto, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, gasto.getConcepto());
            stmt.setDouble(2, gasto.getMonto());
            stmt.setString(3, gasto.getFecha());
            stmt.executeUpdate();
            System.out.println("Gasto agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarGasto(int idGasto) {
        String query = "DELETE FROM gastos WHERE idGasto = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idGasto);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Gasto eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún gasto con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public List<Gasto> obtenerTodosLosGastos() {
        List<Gasto> listaGastos = new ArrayList<>();
        String query = "SELECT * FROM gastos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id = rs.getInt("idGasto");
                String concepto = rs.getString("concepto");
                double monto = rs.getDouble("monto");
                String fecha = rs.getString("fecha");
                Gasto gasto = new Gasto(id, concepto, monto, fecha);
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Cantidad de Gastos Obtenidos: " + listaGastos.size());

    // Mostrar los gastos obtenidos
        for (Gasto gasto : listaGastos) {
            System.out.println(gasto);

        }


        return listaGastos;
    }
}