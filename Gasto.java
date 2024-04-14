public class Gasto {
    private int idGasto;
    private String concepto;
    private double monto;
    private String fecha;

    public Gasto(int idGasto, String concepto, double monto, String fecha) {
        this.idGasto = idGasto;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "idGasto=" + idGasto +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}