import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
public class Main {

    private static GastoDAO gastoDAO;
    private static IngresoDAO ingresoDAO;
    private static ConexionBD conexionBD;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Establecer conexión a la base de datos
        conexionBD = new ConexionBD();
        Connection conexion = conexionBD.getConnection();

        if (conexion != null) {
            System.out.println("Conexión establecida correctamente");
            gastoDAO = new GastoDAO(conexion);
            ingresoDAO = new IngresoDAO(conexion);

            int opcion;
            do {
                System.out.println("\n--- GESTIÓN DE GASTOS PERSONALES ---");
                System.out.println("1. Agregar Gasto");
                System.out.println("2. Mostrar Todos los Gastos");
                System.out.println("3. Agregar Ingreso");
                System.out.println("4. Mostrar Todos los Ingresos");
                System.out.println("5. Eliminar Gasto");
                System.out.println("6. Eliminar Ingreso");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        agregarGasto(scanner);
                        break;
                    case 2:
                        mostrarTodosLosGastos();
                        break;
                    case 3:
                        agregarIngreso(scanner);
                        break;
                    case 4:
                        mostrarTodosLosIngresos();
                        break;
                    
                    case 5:
                        eliminarGasto(scanner);
                        break;
                    case 6:
                        eliminarIngreso(scanner);
                        break;
                    case 7:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                }
            } while (opcion != 7);

            scanner.close();
            conexionBD.cerrarConexion();
        } else {
            System.out.println("No se pudo establecer conexión a la base de datos.");
        }
    }

    private static void agregarGasto(Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el concepto del gasto: ");
        String concepto = scanner.nextLine();
        System.out.print("Ingrese el monto del gasto: ");
        double monto = scanner.nextDouble();
        System.out.print("Ingrese la fecha del gasto (YYYY-MM-DD): ");
        scanner.nextLine(); // Limpiar el buffer
        String fecha = scanner.nextLine();

        Gasto nuevoGasto = new Gasto(0, concepto, monto, fecha);
        gastoDAO.agregarGasto(nuevoGasto);
    }

    private static void mostrarTodosLosGastos() {
        List<Gasto> gastos = gastoDAO.obtenerTodosLosGastos();
        System.out.println("\n--- LISTA DE GASTOS ---");
        if (gastos.isEmpty()){
            System.out.println("No hay gastos registrados");
        } else{

        
            for (Gasto gasto : gastos) {
                System.out.println(gasto);
            }
        }
    }

    private static void agregarIngreso(Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el concepto del ingreso: ");
        String concepto = scanner.nextLine();
        System.out.print("Ingrese el monto del ingreso: ");
        double monto = scanner.nextDouble();
        System.out.print("Ingrese la fecha del ingreso (YYYY-MM-DD): ");
        scanner.nextLine(); // Limpiar el buffer
        String fecha = scanner.nextLine();

        Ingreso nuevoIngreso = new Ingreso(0, concepto, monto, fecha);
        ingresoDAO.agregarIngreso(nuevoIngreso);
    }

    private static void mostrarTodosLosIngresos() {
        List<Ingreso> ingresos = ingresoDAO.obtenerTodosLosIngresos();
        System.out.println("\n--- LISTA DE INGRESOS ---");
        for (Ingreso ingreso : ingresos) {
            System.out.println(ingreso);
        }
    }

    private static void eliminarGasto(Scanner scanner) {
        System.out.print("Ingrese el ID del gasto a eliminar: ");
        int idGasto = scanner.nextInt();
        gastoDAO.eliminarGasto(idGasto);
    }
    
    private static void eliminarIngreso(Scanner scanner) {
        System.out.print("Ingrese el ID del ingreso a eliminar: ");
        int idIngreso = scanner.nextInt();
        ingresoDAO.eliminarIngreso(idIngreso);
    }




}