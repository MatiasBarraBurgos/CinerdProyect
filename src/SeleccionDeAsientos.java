import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SeleccionDeAsientos extends JFrame {
    private String peliculaSeleccionada;
    private String horarioSeleccionado;
    private String salaSeleccionada;

    private static final int FILAS = 9;
    private static final int COLUMNAS = 10;
    private static final int PRECIO_POR_ASIENTO = 3000;
    private static final String[] LETRAS_FILA = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    private JButton[][] asientos;
    private JLabel montoTotalLabel;
    private JLabel infoPeliculaLabel;

    public void setInfoPelicula(String nombre, String horario, String sala) {
        this.peliculaSeleccionada = nombre;
        this.horarioSeleccionado = horario;
        this.salaSeleccionada = sala;
        actualizarInfoPelicula();
    }

    public SeleccionDeAsientos() {
        super("Sala de Cine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarAsientos();
        crearGUI();
        pack();
        generarAsientosOcupadosAleatoriamente();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearGUI() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JPanel panelPantalla = new JPanel();
        panelPantalla.setPreferredSize(new Dimension(400, 200));
        panelPantalla.setBackground(new Color(0, 0, 0));
        infoPeliculaLabel = new JLabel();
        infoPeliculaLabel.setForeground(Color.BLACK); // Texto negro
        panelPantalla.add(infoPeliculaLabel);

        JPanel panelAsientos = new JPanel(new GridLayout(FILAS, COLUMNAS, 5, 5));
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                JButton asiento = asientos[i][j];
                asiento.setBackground(new Color(255, 204, 0)); // Set the background color to yellow
                panelAsientos.add(asiento);
            }
        }

        JPanel panelInformacion = new JPanel(new FlowLayout());
        montoTotalLabel = new JLabel("Monto Total: $0");
        panelInformacion.add(montoTotalLabel);
        montoTotalLabel.setForeground(Color.BLACK);
        panelPrincipal.add(panelInformacion, BorderLayout.NORTH);
        infoPeliculaLabel = new JLabel("Película: - Horario: - Sala: -");
        panelInformacion.add(infoPeliculaLabel);

        JPanel panelPago = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton pagarButton = new JButton("Ir a Pagar");
        pagarButton.addActionListener(new PagoListener());
        panelPago.add(pagarButton);

        panelPrincipal.add(panelPantalla, BorderLayout.NORTH);
        panelPrincipal.add(panelAsientos, BorderLayout.CENTER);
        panelPrincipal.add(panelInformacion, BorderLayout.SOUTH);
        panelPrincipal.add(panelPago, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JButton crearAsientoButton(String etiqueta, int fila, int columna) {
        JButton button = new JButton(etiqueta);
        button.setPreferredSize(obtenerDimensionesSegunColumna(columna));
        button.addActionListener(new AsientoListener(fila));
        return button;
    }

    private Dimension obtenerDimensionesSegunColumna(int columna) {
        int ancho = 40;
        int alto = 40;

        if (columna == 0 || columna == 1 || columna == 7 || columna == 8) {
            ancho *= 2;
        }

        return new Dimension(ancho, alto);
    }

    private void inicializarAsientos() {
        asientos = new JButton[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                String etiqueta = LETRAS_FILA[i] + (j + 1);
                JButton asiento = crearAsientoButton(etiqueta, i, j);
                asientos[i][j] = asiento;
            }
        }
    }

    private class AsientoListener implements ActionListener {
        private int fila;

        public AsientoListener(int fila) {
            this.fila = fila;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton asiento = (JButton) e.getSource();
            asiento.setBackground(asiento.getBackground() == Color.GREEN ? new Color(255, 204, 0) : Color.GREEN);
            actualizarMontoTotal();
        }
    }

    private void actualizarMontoTotal() {
        int montoTotal = calcularMontoTotal();
        montoTotalLabel.setText("Monto Total: $" + montoTotal);
    }

    private int calcularMontoTotal() {
        int montoTotal = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (asientos[i][j].getBackground() == Color.GREEN) {
                    montoTotal += PRECIO_POR_ASIENTO;
                }
            }
        }
        return montoTotal;
    }

    private class PagoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String pelicula = peliculaSeleccionada;
            String horario = horarioSeleccionado;
            String sala = salaSeleccionada;
            int montoTotal = calcularMontoTotal();

            MetodoDePago metodoDePago = new MetodoDePago(pelicula, horario, sala, montoTotal);
            metodoDePago.setVisible(true);
            dispose(); // Cierra la ventana actual (SeleccionDeAsientos)
        }
    }

    private void generarAsientosOcupadosAleatoriamente() {
        Random random = new Random();
        int numAsientosOcupados = random.nextInt(FILAS * COLUMNAS);

        for (int i = 0; i < numAsientosOcupados; i++) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (asientos[fila][columna].getBackground() != Color.GREEN) {
                asientos[fila][columna].setBackground(Color.GRAY);
                asientos[fila][columna].setEnabled(false);
            } else {
                i--;
            }
        }
    }

    private void actualizarInfoPelicula() {
        infoPeliculaLabel.setText("Película: " + peliculaSeleccionada + " | Horario: " + horarioSeleccionado + " | Sala: " + salaSeleccionada);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SeleccionDeAsientos());
    }
}
