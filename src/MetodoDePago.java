import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class MetodoDePago extends JFrame {

    private JRadioButton btnTarjetaCredito;
    private JRadioButton btnTarjetaDebito;
    private JRadioButton btnEfectivo;

    private String pelicula;
    private String horario;
    private String sala;
    private int montoTotal;
    private List<String> asientosReservados;

    public MetodoDePago(String pelicula, String horario, String sala, int montoTotal, List<String> asientosReservados) {
        SwingUtilities.invokeLater(() -> {
            this.pelicula = pelicula;
            this.horario = horario;
            this.sala = sala;
            this.montoTotal = montoTotal;
            this.asientosReservados = asientosReservados;

            iniciarComponentes();
            setVisible(true);
            setLocationRelativeTo(null);
        });
    }

    private void iniciarComponentes() {
        setTitle("Método de Pago");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(255, 204, 0));

        setLayout(new BorderLayout());

        JPanel panelMetodoPago = crearPanelMetodoPago();
        add(panelMetodoPago, BorderLayout.CENTER);

        JPanel panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.SOUTH);
    }

   private JPanel crearPanelMetodoPago() {
    JPanel panelMetodoPago = new JPanel();
    panelMetodoPago.setLayout(new BorderLayout());

    // Título , que es puesto en el borde
    panelMetodoPago.setBorder(BorderFactory.createTitledBorder("Método de Pago"));

    // Información de la película.
    JLabel infoPelicula = new JLabel("Película: " + pelicula + " -  Horario: " + horario + " -  Sala: " + sala);
    infoPelicula.setFont(new Font("Arial", Font.BOLD, 14));
    panelMetodoPago.add(infoPelicula, BorderLayout.NORTH);

    // Combinamos las etiquetas infoMontoTotal e infoAsientosReservados en un solo panel
    JPanel panelInfo = new JPanel(new GridLayout(2, 1));
    
    JLabel infoMontoTotal = new JLabel("Monto Total a Pagar: $" + montoTotal);
    infoMontoTotal.setFont(new Font("Arial", Font.BOLD, 14));
    panelInfo.add(infoMontoTotal);

    JLabel infoAsientosReservados = new JLabel("Asientos Reservados: " + obtenerAsientosReservadosComoString());
    infoAsientosReservados.setFont(new Font("Arial", Font.BOLD, 14));
    panelInfo.add(infoAsientosReservados);

    panelMetodoPago.add(panelInfo, BorderLayout.CENTER);

    JPanel panelOpciones = new JPanel(new GridLayout(0, 2, 10, 10));
    panelOpciones.setBackground(new Color(255, 204, 0));

    // Imágenes para cada opción de pago
    ImageIcon iconoEfectivo = cargarImagen("efectivo.png");
    ImageIcon iconoTarjetaCredito = cargarImagen("tarjeta_credito.png");
    ImageIcon iconoTarjetaDebito = cargarImagen("tarjeta_debito.png");

    btnTarjetaCredito = new JRadioButton("Tarjeta de crédito");
    panelOpciones.add(btnTarjetaCredito);
    panelOpciones.add(new JLabel(iconoTarjetaCredito));

    btnTarjetaDebito = new JRadioButton("Tarjeta Débito");
    panelOpciones.add(btnTarjetaDebito);
    panelOpciones.add(new JLabel(iconoTarjetaDebito));

    btnEfectivo = new JRadioButton("Efectivo");
    panelOpciones.add(btnEfectivo);
    panelOpciones.add(new JLabel(iconoEfectivo));

    ButtonGroup grupo = new ButtonGroup();
    grupo.add(btnTarjetaCredito);
    grupo.add(btnTarjetaDebito);
    grupo.add(btnEfectivo);

    panelMetodoPago.add(panelOpciones, BorderLayout.SOUTH);

    return panelMetodoPago;
}

    private JPanel crearPanelBotones() {
        JButton botonConfirmar = new JButton("Confirmar");
        JButton botonCancelar = new JButton("Cancelar compra");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(botonConfirmar);
        panelBotones.add(botonCancelar);

        // Establecer el color de fondo del panel de botones
        panelBotones.setBackground(new Color(255, 204, 0)); 

        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarConfirmacionPago();
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarCancelarCompra();
            }
        });

        return panelBotones;
    }

    private void manejarConfirmacionPago() {
        JRadioButton opcionSeleccionada = obtenerBotonSeleccionado();
        if (opcionSeleccionada != null) {
            String metodoPago = opcionSeleccionada.getText();
            String detallesPago = obtenerDetallesPago(metodoPago);
            String informacionAdicional = mostrarDialogoEntrada(detallesPago);

            if (informacionAdicional != null) {
                if (confirmarCompra(metodoPago, informacionAdicional)) {
                    System.out.println("Compra confirmada con " + metodoPago);

                    // Instanciar la factura y mostrar la ventana de Factura
                    Factura factura = new Factura(metodoPago, pelicula, horario, sala, montoTotal, asientosReservados);
                    factura.setVisible(true);

                    dispose(); // Cerramos la ventana actual MetodoDePago.
                } else {
                    System.out.println("Compra cancelada");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Por favor, seleccione un método de pago");
        }
    }

    private String obtenerDetallesPago(String metodoPago) {
        switch (metodoPago) {
            case "Tarjeta de crédito":
            case "Tarjeta Débito":
                return "Número de tarjeta:\nFecha de vencimiento (MM/YY):\nCVV:";
            case "Efectivo":
                return "Indique la cantidad en efectivo:";
            default:
                return "";
        }
    }

    private String mostrarDialogoEntrada(String mensaje) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (mensaje.contains("CVV")) {
            JTextField campoNumeroTarjeta = new JTextField(20);
            JTextField campoFechaVencimiento = new JTextField(6);
            JPasswordField campoCVV = new JPasswordField(3);

            panel.add(new JLabel("Número de tarjeta:"));
            panel.add(campoNumeroTarjeta);
            panel.add(new JLabel("Fecha de vencimiento (MM/YY):"));
            panel.add(campoFechaVencimiento);
            panel.add(new JLabel("CVV:"));
            panel.add(campoCVV);

            int resultado = JOptionPane.showOptionDialog(
                    this,
                    panel,
                    "Detalles de Pago",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null
            );

            if (resultado == JOptionPane.OK_OPTION) {
                String numeroTarjeta = campoNumeroTarjeta.getText().replaceAll("\\s", ""); // Elimina espacios en blanco
                String fechaVencimiento = campoFechaVencimiento.getText();
                String cvv = new String(campoCVV.getPassword());

                // Validar campos
                if (numeroTarjeta.isEmpty() || fechaVencimiento.isEmpty() || cvv.isEmpty() || !esNumero(cvv)) {
                    return null;
                }

                // Formatear el número de tarjeta con espacios cada 4 dígitos
                StringBuilder numeroFormateado = new StringBuilder();
                for (int i = 0; i < numeroTarjeta.length(); i++) {
                    if (i > 0 && i % 4 == 0) {
                        numeroFormateado.append(" ");
                    }
                    numeroFormateado.append(numeroTarjeta.charAt(i));
                }

                return "Número de tarjeta: " + numeroFormateado.toString() +
                        "\nFecha de vencimiento (MM/YY): " + fechaVencimiento +
                        "\nCVV: " + cvv;
            }
        } else {
            panel.add(new JLabel(mensaje));
            JTextField campoEfectivo = new JTextField(20);
            panel.add(campoEfectivo);

            int resultado = JOptionPane.showOptionDialog(
                    this,
                    panel,
                    "Detalles de Pago",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null
            );

            if (resultado == JOptionPane.OK_OPTION) {
                String cantidadEfectivo = campoEfectivo.getText();
                // Validar campo
                if (cantidadEfectivo.isEmpty() || !esNumero(cantidadEfectivo)) {
                    return null;
                }
                return "Indique la cantidad en efectivo: " + cantidadEfectivo;
            }
        }

        return null;
    }

    private boolean esNumero(String texto) {
        try {
            Integer.valueOf(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean confirmarCompra(String metodoPago, String informacionAdicional) {
        String mensajeConfirmacion = "¿Confirmar la compra con " + metodoPago + "?\n\n" +
                "Detalles de Pago:\n" + informacionAdicional + "\n\n" +
                "Película: " + pelicula + "\n" +
                "Horario: " + horario + "\n" +
                "Sala: " + sala + "\n" +
                "Monto Total: $" + montoTotal + "\n" +
                "Asientos Reservados: " + obtenerAsientosReservadosComoString();

        return JOptionPane.showConfirmDialog(this, mensajeConfirmacion,
                "Confirmación de Compra", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
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

    private void manejarCancelarCompra() {
        System.out.println("Compra cancelada");
        dispose();
    }

    private JRadioButton obtenerBotonSeleccionado() {
        if (btnTarjetaCredito.isSelected()) {
            return btnTarjetaCredito;
        } else if (btnTarjetaDebito.isSelected()) {
            return btnTarjetaDebito;
        } else if (btnEfectivo.isSelected()) {
            return btnEfectivo;
        } else {
            return null;
        }
    }

    private ImageIcon cargarImagen(String nombreImagen) {
        URL url = getClass().getResource("/Imagenes/" + nombreImagen);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            System.err.println("No se pudo cargar la imagen: " + nombreImagen);
            return null;
        }
    }

    public static void main(String[] args) {

       
    }
}
