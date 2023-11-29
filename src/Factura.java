import java.util.List;

public class Factura {
    private String metodoPago;
    private String pelicula;
    private String horario;
    private String sala;
    private List<String> asientosSeleccionados;
    private int montoTotal;

    public Factura(String cliente, String metodoPago, String pelicula, String horario,
                   String sala, List<String> asientosSeleccionados, int montoTotal) {
        this.metodoPago = metodoPago;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala = sala;
        this.asientosSeleccionados = asientosSeleccionados;
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public String getSala() {
        return sala;
    }

    public List<String> getAsientosSeleccionados() {
        return asientosSeleccionados;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    @Override
    public String toString() {
        StringBuilder facturaString = new StringBuilder();
        facturaString.append("Método de Pago: ").append(metodoPago).append("\n");
        facturaString.append("Película: ").append(pelicula).append("\n");
        facturaString.append("Horario: ").append(horario).append("\n");
        facturaString.append("Sala: ").append(sala).append("\n");
        facturaString.append("Asientos Seleccionados:\n");
        for (String asiento : asientosSeleccionados) {
            facturaString.append("- ").append(asiento).append("\n");
        }
        facturaString.append("Monto Total: $").append(montoTotal).append("\n");

        return facturaString.toString();
    }
}

