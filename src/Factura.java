import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Factura extends JFrame {

    private List<String> asientosReservados;

    public Factura(String metodoPago, String pelicula, String horario, String sala, int montoTotal, List<String> asientosReservados) {
        SwingUtilities.invokeLater(() -> {
            this.asientosReservados = asientosReservados;

            // Configurar la ventana
            setTitle("Boleta de Compra");
            setSize(300, 400); // Tamaño ajustado
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Obtener la resolución de la pantalla
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Calcular la posición centrada en la pantalla
            int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
            int y = (int) ((screenSize.getHeight() - getHeight()) / 2);

            // Establecer la posición de la ventana
            setLocation(x, y);

            // Crear el panel principal de la boleta
            JPanel boletaPanel = new JPanel();
            boletaPanel.setLayout(new BoxLayout(boletaPanel, BoxLayout.Y_AXIS));
            boletaPanel.setBackground(new Color(255, 255, 255));

            // Crear el encabezado con el nombre del cine
            JLabel cineLabel = new JLabel("Cinerd");
            cineLabel.setFont(new Font("Arial", Font.BOLD, 24));
            cineLabel.setForeground(new Color(255, 204, 0));
            cineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Agregar espacio entre el encabezado y la fecha/hora
            boletaPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            // Agregar el nombre del cine al panel principal
            boletaPanel.add(cineLabel);

            // Obtener la fecha y hora actuales
            Date fechaHoraActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

            // Crear etiquetas para la fecha y hora
            JLabel fechaLabel = new JLabel("Fecha: " + formatoFecha.format(fechaHoraActual));
            JLabel horaLabel = new JLabel("Hora: " + formatoHora.format(fechaHoraActual));

            // Alinear las etiquetas al centro
            fechaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            horaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Agregar las etiquetas al panel principal
            boletaPanel.add(fechaLabel);
            boletaPanel.add(horaLabel);

            // Agregar espacio después de la fecha y hora
            boletaPanel.add(Box.createRigidArea(new Dimension(0, 20)));

            // Crear detalles de la boleta y agregar al panel principal
            boletaPanel.add(crearDetalle("Película", pelicula));
            boletaPanel.add(crearDetalle("Horario", horario));
            boletaPanel.add(crearDetalle("Sala", sala));
            boletaPanel.add(crearDetalle("Asientos Reservados", obtenerAsientosReservadosComoString()));

            // Agregar espacio después de los detalles
            boletaPanel.add(Box.createRigidArea(new Dimension(0, 20)));

            // Crear el panel del monto total con un estilo llamativo
            JLabel montoTotalLabel = new JLabel("Total: " + formatearMonto(montoTotal));
            montoTotalLabel.setFont(new Font("Arial", Font.BOLD, 18));
            montoTotalLabel.setForeground(new Color(255, 51, 51));
            montoTotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Agregar el monto total al panel principal
            boletaPanel.add(montoTotalLabel);

            // Agregar espacio después del monto total
            boletaPanel.add(Box.createRigidArea(new Dimension(0, 20)));

            // Crear el botón imprimir
            JButton imprimirButton = new JButton("Imprimir");
            imprimirButton.addActionListener(e -> imprimirBoleta());
            imprimirButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Agregar el botón imprimir al panel principal
            boletaPanel.add(imprimirButton);

            // Agregar el panel de la boleta a la ventana
            add(boletaPanel);

            // Centrar la ventana
            setLocationRelativeTo(null);
            setVisible(true);
        });
    }

    private JLabel crearDetalle(String etiqueta, String valor) {
        JLabel detalleLabel = new JLabel(etiqueta + ": " + valor);
        detalleLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        detalleLabel.setForeground(new Color(51, 51, 51));
        detalleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return detalleLabel;
    }

    private String formatearMonto(int monto) {
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
        return formatoMoneda.format(monto);
    }

    private void imprimirBoleta() {
        // Lógica para imprimir la boleta

        // Mostrar mensaje de compra exitosa después de imprimir
        JOptionPane.showMessageDialog(this, "Compra realizada con éxito. ¡Disfrute la experiencia!", "Compra Exitosa", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Cerrar la ventana después de imprimir
    }

    private String obtenerAsientosReservadosComoString() {
        StringBuilder asientosReservadosString = new StringBuilder();
        for (String asiento : asientosReservados) {
            asientosReservadosString.append(asiento).append(", ");
        }
        if (asientosReservadosString.length() > 2) {
            // Eliminar la coma y el espacio al final
            asientosReservadosString.setLength(asientosReservadosString.length() - 2);
        }
        return asientosReservadosString.toString();
    }

    public static void main(String[] args) {
       
    }
}
