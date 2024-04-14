public class Ingreso {
    private int idIngreso;
    private String concepto;
    private double monto;
    private String fecha;

    public Ingreso(int idIngreso, String concepto, double monto, String fecha) {
        this.idIngreso = idIngreso;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
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
        return "Ingreso{" +
                "idIngreso=" + idIngreso +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}