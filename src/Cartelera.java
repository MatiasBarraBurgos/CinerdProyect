import Conexion.Conex;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cartelera extends javax.swing.JDialog {
    private String peliculaSeleccionada;
    private String horarioSeleccionado;
    private String salaSeleccionada;
    private JButton ultimoBotonHorarioSeleccionado;
    
    public Cartelera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bloquearControlesIniciales();
    }
    
    public Cartelera() {
        super(new javax.swing.JFrame(), true);
        initComponents();
        bloquearControlesIniciales();
    }
    
    private void bloquearControlesIniciales() {
        JComboSeleccion1.setEnabled(false);
        JComboSeleccion2.setEnabled(false);
        JComboSeleccion3.setEnabled(false);
        JComboSeleccion4.setEnabled(false);
        JComboSeleccion5.setEnabled(false);
        JComboSeleccion6.setEnabled(false);

        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);

        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);

        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
        
        Jpelicula1.setEnabled(false);
        Jpelicula2.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula5.setEnabled(false);
        Jpelicula6.setEnabled(false);
    }

    private void desbloquearControlesPeliculas() {
        Jpelicula1.setEnabled(true);
        Jpelicula2.setEnabled(true);
        Jpelicula3.setEnabled(true);
        Jpelicula4.setEnabled(true);
        Jpelicula5.setEnabled(true);
        Jpelicula6.setEnabled(true);
    }

    private void relacionarConPelicula1() {
        System.out.println("DEBUG - Relacionando horarios con Napoleon");
        JhorarioNap.setEnabled(true);
        JhorarioNap2.setEnabled(true);
        JhorarioNap3.setEnabled(true);
        JComboSeleccion1.setEnabled(true);
    }

    private void relacionarConPelicula2() {
        System.out.println("DEBUG - Relacionando horarios con wonka");
        JhorarioWon1.setEnabled(true);
        JhorarioWon2.setEnabled(true);
        JhorarioWon3.setEnabled(true);
        JComboSeleccion2.setEnabled(true);
    }

    private void relacionarConPelicula3() {
        System.out.println("DEBUG - Relacionando horarios con Aquaman 2");
        JhorarioAq1.setEnabled(true);
        JhorarioAq2.setEnabled(true);
        JhorarioAq3.setEnabled(true);
        JComboSeleccion3.setEnabled(true);
    }
    
    private void relacionarConPelicula4() {
        System.out.println("DEBUG - Relacionando horarios con Noche de Paz");
        JhorarioNdp1.setEnabled(true);
        JhorarioNdp2.setEnabled(true);
        JhorarioNdp3.setEnabled(true);
        JComboSeleccion4.setEnabled(true);
        
    }
    
    private void relacionarConPelicula5() {
        System.out.println("DEBUG - Relacionando horarios con Teddy");
        JhorarioTeddy1.setEnabled(true);
        JhorarioTeddy2.setEnabled(true);
        JhorarioTeddy3.setEnabled(true);
        JComboSeleccion5.setEnabled(true);
    }
    
    private void relacionarConPelicula6() {
        System.out.println("DEBUG - Relacionando horarios con Whish");
        JhorarioWhish1.setEnabled(true);
        JhorarioWhish2.setEnabled(true);
        JhorarioWhish3.setEnabled(true);
        JComboSeleccion6.setEnabled(true);
    }
    
    private boolean verificarRelacionPelicula1() {
        return JhorarioNap.isSelected() && JComboSeleccion1.getSelectedIndex() != -1 ||
        JhorarioNap2.isSelected() && JComboSeleccion1.getSelectedIndex() != -1 ||
        JhorarioNap3.isSelected() && JComboSeleccion1.getSelectedIndex() != -1;
    }

private boolean verificarRelacionPelicula2() {
        return JhorarioWon1.isSelected() && JComboSeleccion2.getSelectedIndex() != -1 ||
        JhorarioWon2.isSelected() && JComboSeleccion2.getSelectedIndex() != -1 ||
        JhorarioWon3.isSelected() && JComboSeleccion2.getSelectedIndex() != -1;
    }

private boolean verificarRelacionPelicula3() {
        return JhorarioAq1.isSelected() && JComboSeleccion3.getSelectedIndex() != -1 ||
        JhorarioAq2.isSelected() && JComboSeleccion3.getSelectedIndex() != -1 ||
        JhorarioAq3.isSelected() && JComboSeleccion3.getSelectedIndex() != -1;
    }

private boolean verificarRelacionPelicula4() {
        return JhorarioNdp1.isSelected() && JComboSeleccion4.getSelectedIndex() != -1 ||
        JhorarioNdp2.isSelected() && JComboSeleccion4.getSelectedIndex() != -1 ||
        JhorarioNdp3.isSelected() && JComboSeleccion4.getSelectedIndex() != -1;
    }

private boolean verificarRelacionPelicula5() {
        return JhorarioTeddy1.isSelected() && JComboSeleccion5.getSelectedIndex() != -1 ||
        JhorarioTeddy2.isSelected() && JComboSeleccion5.getSelectedIndex() != -1 ||
        JhorarioTeddy3.isSelected() && JComboSeleccion5.getSelectedIndex() != -1;
    }

private boolean verificarRelacionPelicula6() {
        return JhorarioWhish1.isSelected() && JComboSeleccion6.getSelectedIndex() != -1 ||
        JhorarioWhish2.isSelected() && JComboSeleccion6.getSelectedIndex() != -1 ||
        JhorarioWhish3.isSelected() && JComboSeleccion6.getSelectedIndex() != -1;
    }

private boolean verificarRelacion() {
    boolean relacion = false;

    if (null != peliculaSeleccionada) switch (peliculaSeleccionada) {
            case "Napoleon":
                relacion = verificarRelacionPelicula1();
                break;
            case "Wonka":
                relacion = verificarRelacionPelicula2();
                break;
            case "Aquaman 2":
                relacion = verificarRelacionPelicula3();
                break;
            case "Noche de paz":
                relacion = verificarRelacionPelicula4();
                break;
            case "Teddy":
                relacion = verificarRelacionPelicula5();
                break;
            case "Whish":
                relacion = verificarRelacionPelicula6();
                break;
            default:
                break;
        }

    return relacion;
    }
    
    private void bloquearNoRelacionadosConPelicula1() {
        JhorarioNap.setEnabled(true);
        JhorarioNap2.setEnabled(true);
        JhorarioNap3.setEnabled(true);
        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);
        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
        
        
    }

    private void bloquearNoRelacionadosConPelicula2() {
        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);
        JhorarioWon1.setEnabled(true);
        JhorarioWon2.setEnabled(true);
        JhorarioWon3.setEnabled(true);
        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
    }

    private void bloquearNoRelacionadosConPelicula3() {
        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);
        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);
        JhorarioAq1.setEnabled(true);
        JhorarioAq2.setEnabled(true);
        JhorarioAq3.setEnabled(true);
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
    }

    private void bloquearNoRelacionadosConPelicula4() {
        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);
        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);
        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        JhorarioNdp1.setEnabled(true);
        JhorarioNdp2.setEnabled(true);
        JhorarioNdp3.setEnabled(true);
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
    }

    private void bloquearNoRelacionadosConPelicula5() {
        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);
        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);
        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        JhorarioTeddy1.setEnabled(true);
        JhorarioTeddy2.setEnabled(true);
        JhorarioTeddy3.setEnabled(true);
        JhorarioWhish1.setEnabled(false);
        JhorarioWhish2.setEnabled(false);
        JhorarioWhish3.setEnabled(false);
    }

    private void bloquearNoRelacionadosConPelicula6() {
        JhorarioNap.setEnabled(false);
        JhorarioNap2.setEnabled(false);
        JhorarioNap3.setEnabled(false);
        JhorarioWon1.setEnabled(false);
        JhorarioWon2.setEnabled(false);
        JhorarioWon3.setEnabled(false);
        JhorarioAq1.setEnabled(false);
        JhorarioAq2.setEnabled(false);
        JhorarioAq3.setEnabled(false);
        JhorarioNdp1.setEnabled(false);
        JhorarioNdp2.setEnabled(false);
        JhorarioNdp3.setEnabled(false);
        JhorarioTeddy1.setEnabled(false);
        JhorarioTeddy2.setEnabled(false);
        JhorarioTeddy3.setEnabled(false);
        JhorarioWhish1.setEnabled(true);
        JhorarioWhish2.setEnabled(true);
        JhorarioWhish3.setEnabled(true);
    }

    private void bloquearPelicula2345y6() {
        Jpelicula2.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula5.setEnabled(false);
        Jpelicula6.setEnabled(false);
    }

    private void bloquearPelicula1345y6() {
        Jpelicula1.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula5.setEnabled(false);
        Jpelicula6.setEnabled(false);
    }

    private void bloquearPelicula1245y6() {
        Jpelicula1.setEnabled(false);
        Jpelicula2.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula5.setEnabled(false);
        Jpelicula6.setEnabled(false);
    }

    private void bloquearPelicula1235y6() {
        Jpelicula1.setEnabled(false);
        Jpelicula2.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula5.setEnabled(false);
        Jpelicula6.setEnabled(false);  
    }

    private void bloquearPelicula1234y6() {
        Jpelicula1.setEnabled(false);
        Jpelicula2.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula6.setEnabled(false);
    }

    private void bloquearPelicula1234y5() {
        Jpelicula1.setEnabled(false);
        Jpelicula2.setEnabled(false);
        Jpelicula3.setEnabled(false);
        Jpelicula4.setEnabled(false);
        Jpelicula5.setEnabled(false);
    }
    
   private void desbloquearHorarios() {
        // Desseleccionar horarios para la película "Napoleon"
        JhorarioNap.setSelected(true);
        JhorarioNap2.setSelected(true);
        JhorarioNap3.setSelected(true);

        // Desseleccionar horarios para la película "Wonka"
        JhorarioWon1.setSelected(true);
        JhorarioWon2.setSelected(true);
        JhorarioWon3.setSelected(true);

        // Desseleccionar horarios para la película "Aquaman"
        JhorarioAq1.setSelected(true);
        JhorarioAq2.setSelected(true);
        JhorarioAq3.setSelected(true);

        // Desseleccionar horarios para la película "Noche de paz"
        JhorarioNdp1.setSelected(true);
        JhorarioNdp2.setSelected(true);
        JhorarioNdp3.setSelected(true);

        // Desseleccionar horarios para la película "Teddy"
        JhorarioTeddy1.setSelected(true);
        JhorarioTeddy2.setSelected(true);
        JhorarioTeddy3.setSelected(true);

        // Desseleccionar horarios para la película "Whish"
        JhorarioWhish1.setSelected(true);
        JhorarioWhish2.setSelected(true);
        JhorarioWhish3.setSelected(true);

    
    horarioSeleccionado = "";
}
   private void desbloquearSala1() {
        JComboSeleccion1.setEnabled(true);
}
   private void desbloquearSala2() {
        JComboSeleccion2.setEnabled(true);
}
   private void desbloquearSala3() {
        JComboSeleccion3.setEnabled(true);
}
   private void desbloquearSala4() {
        JComboSeleccion4.setEnabled(true);
}
   private void desbloquearSala5() {
        JComboSeleccion5.setEnabled(true);
}
   private void desbloquearSala6() {
        JComboSeleccion6.setEnabled(true);
}
   
    private void actualizarControlesHorarioSeleccionado() {
        JhorarioNap.setSelected(false);
        JhorarioNap2.setSelected(false);
        JhorarioNap3.setSelected(false);
        JhorarioWon1.setSelected(false);
        JhorarioWon2.setSelected(false);
        JhorarioWon3.setSelected(false);
        JhorarioAq1.setSelected(false);
        JhorarioAq2.setSelected(false);
        JhorarioAq3.setSelected(false);
        JhorarioNdp1.setSelected(false);
        JhorarioNdp2.setSelected(false);
        JhorarioNdp3.setSelected(false);
        JhorarioTeddy1.setSelected(false);
        JhorarioTeddy2.setSelected(false);
        JhorarioTeddy3.setSelected(false);
        JhorarioWhish1.setSelected(false);
        JhorarioWhish2.setSelected(false);
        JhorarioWhish3.setSelected(false);

    //  esto ctiva la selección en el último botón de horario seleccionado
    if (ultimoBotonHorarioSeleccionado != null) {
        ultimoBotonHorarioSeleccionado.setSelected(true);
    }
}
  private void bloquearHorariosNoRelacionados() {
        System.out.println("DEBUG - Bloqueando horarios no relacionados para: " + peliculaSeleccionada);
        if (null != peliculaSeleccionada) switch (peliculaSeleccionada) {
            case "Napoleon ":
                bloquearNoRelacionadosConPelicula1();
                bloquearPelicula2345y6();
                break;
            case "Wonka ":
                bloquearNoRelacionadosConPelicula2();
                bloquearPelicula1345y6();
                break;
            case "Aquaman 2 ":
                bloquearNoRelacionadosConPelicula3();
                bloquearPelicula1245y6();
                break;
            case "Noche de paz ":
                bloquearNoRelacionadosConPelicula4();
                bloquearPelicula1235y6();
                break;
            case "Teddy ":
                bloquearNoRelacionadosConPelicula5();
                bloquearPelicula1234y6();
                break;
            case "Whish ":
                bloquearNoRelacionadosConPelicula6();
                bloquearPelicula1234y5();
                break;
            default:
                break;
        }
    }
  
  
     private void realizarReserva() {
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Verificar que el horario y la sala estén relacionados con la película seleccionada
        if (verificarRelacion()) {
            {
           
    }
            
            // Bloquear horarios no relacionados antes de mostrar el mensaje
          bloquearHorariosNoRelacionados();

Object[] options = {"Ir a Selección de Asientos", "Cancelar Reserva"};
int choice = JOptionPane.showOptionDialog(
        this,
        "Reserva realizada:\n" +
                "Pelicula: " + peliculaSeleccionada + "\n" +
                "Horario: " + horarioSeleccionado + "\n" +
                "Sala: " + salaSeleccionada,
        "Reserva realizada",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        options,
        options[0]
);

if (choice == 0) {
    // Llamar al método setInfoPelicula para establecer la información de la película
    SeleccionDeAsientos seleccionDeAsientos = new SeleccionDeAsientos();
    seleccionDeAsientos.setInfoPelicula(peliculaSeleccionada, horarioSeleccionado, salaSeleccionada);

    // Mostrar la ventana SeleccionDeAsientos
    seleccionDeAsientos.setVisible(true);

    // Cerrar la ventana Cartelera
    dispose();
} else if (choice == 1) {
    cancelarReserva();

}
        } else {
            JOptionPane.showMessageDialog(this, "El horario y la sala no están relacionados con la película seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Primero selecciona una película, un horario y una sala.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        guardarReservaEnBaseDeDatos(); 
     
       
}
 private void cancelarReserva() {
    bloquearControlesIniciales();
    JOptionPane.showMessageDialog(this, "Reserva cancelada", "Cancelación de Reserva", JOptionPane.INFORMATION_MESSAGE);
}
 
 private void guardarReservaEnBaseDeDatos() {
    // Guardar reserva en la base de datos
    try (Connection conex = new Conex().ConectarBD()) {
        conex.setAutoCommit(true);
        String sql;
        sql = "INSERT INTO reserva (pelicula, horario, sala) VALUES (?, ?, ?)";
        try (PreparedStatement declaracion = conex.prepareStatement(sql)) {
            declaracion.setString(1, peliculaSeleccionada);
            declaracion.setString(2, horarioSeleccionado);
            declaracion.setString(3, salaSeleccionada);
            declaracion.executeUpdate();
            
            
        }
    } catch (SQLException ex) {
       // imprimir el error
        JOptionPane.showMessageDialog(this, "Error al guardar la reserva en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

 private void mostrarSinopsisPelicula() {
    // Verifica si se ha seleccionado una película
    if (peliculaSeleccionada != null) {
        // Muestra detalles de la película según la selección actual
        switch (peliculaSeleccionada) {
            case "Napoleon":
                mostrarSinopsis("Sinopsis Pelicula Napoleon: "+"\n"
                               + "Con un impresionante telón de fondo de filmación a gran escala orquestada por el legendario director Ridley Scott,"+"\n"
                               + "la película captura el implacable viaje de Bonaparte al poder y su volátil relación con Josefina ,ademas de que nos"+"\n"
                               + "Muestra tácticas militares y políticas contra secuencias de batallas dinámicas.");
                break;
            case "Wonka":
                mostrarSinopsis("Sinopsis Pelicula Wonka: "+"\n"
                                +"Basado en el extraordinario personaje central de Charlie y la fábrica de chocolate, \n"
                                + "el libro infantil más icónico de Roald Dahl y uno de los libros infantiles más vendidos de todos los tiempos, \n"
                                + "\"Wonka\" cuenta la maravillosa historia de cómo el mayor inventor, mago y chocolatero se convirtió en el amado \n"
                                + "Willy Wonka que conocemos hoy. Una embriagadora mezcla de magia y música, caos y emoción, \n"
                                + "todo contado con un corazón y un humor fabulosos.");
                break;
            case "Aquaman 2":
                mostrarSinopsis("Sinopsis Aquaman 2: "+"\n"
                                 +"Al no poder derrotar a Aquaman la primera vez, Black Manta, todavía impulsado por la necesidad de vengar la muerte de su padre, \n"
                                 + "no se detendrá ante nada para acabar con Aquaman de una vez por todas. Esta vez Black Manta es más formidable que nunca \n"
                                 + "y ejerce el poder del mítico Tridente Negro, que desata una fuerza antigua y malévola. Para derrotarlo, Aquaman recurrirá a su \n"
                                 + "hermano encarcelado Orm, el ex rey de Atlantis, para forjar una alianza improbable. Juntos, deben dejar de lado sus diferencias \n"
                                 + "para proteger su reino y salvar a la familia de Aquaman y al mundo de una destrucción irreversible.");
                break;
            case "Noche de Paz":
               mostrarSinopsis( "Sinopsis Pelicula Noche de Paz: "+"\n"
                                +"Nochebuena. Un padre atormentado (Joel Kinnaman) es testigo de la muerte de su hijo cuando éste queda atrapado en un fuego cruzado \n"
                                + "entre bandas. Roto de dolor y sin voz, debido a una herida profunda que afecta sus cuerdas vocales, decidirá someterse a un estricto \n"
                                + "entrenamiento para vengar su muerte.");
                break;
            case "Teddy":
               mostrarSinopsis("Sinopsis Pelicula Teddy: "+"\n"
                                +"Al no poder derrotar a Aquaman la primera vez, Black Manta, todavía impulsado por la necesidad de vengar la muerte de su padre, \n"
                                + "no se detendrá ante nada para acabar con Aquaman de una vez por todas. Esta vez Black Manta es más formidable que nunca y ejerce el poder \n"
                                + "del mítico Tridente Negro, que desata una fuerza antigua y malévola. Para derrotarlo, Aquaman recurrirá a su hermano encarcelado Orm, el \n"
                                + "ex rey de Atlantis, para forjar una alianza improbable. Juntos, deben dejar de lado sus diferencias para proteger su reino y salvar a la \n"
                                + "familia de Aquaman y al mundo de una destrucción irreversible.");
                break;
            case "Whish":
                mostrarSinopsis("Sinopsis Pelicula Whish: "+"\n"
                                +"El Poder de los Deseos de Walt Disney Animation Studios es una comedia musical animada que invita a la audiencia a visitar el reino mágico de Rosas, \n"
                                + "donde Asha, una idealista ingeniosa, pide un deseo tan poderoso que es respondido por una fuerza cósmica, una pequeña esfera de energía infinita llamada Star. \n"
                                + "Juntos, Asha y Star se enfrentan al enemigo más temible de todos, el rey Magnifico de Rosas, para salvar a la comunidad y demostrar que suceden cosas maravillosas \n"
                                + "cuando la voluntad de una persona valiente se entrelaza con la magia de las estrellas.");
                break;
           
            default:
                
                break;
        }
    } else {
        // Muestra un mensaje indicando que no se ha seleccionado ninguna película
        JOptionPane.showMessageDialog(this, "Seleccione una película antes de ver detalles.");
    }
}
 private void mostrarSinopsis(String detalles) {
    // Puedes ajustar cómo deseas mostrar los detalles, aquí se usa un cuadro de diálogo
    JOptionPane.showMessageDialog(this, detalles, "Detalles de la Película", JOptionPane.INFORMATION_MESSAGE);
}
 
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Jpelicula = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        Jdetallepelicula = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JhorarioNap = new javax.swing.JButton();
        JhorarioNap2 = new javax.swing.JButton();
        JhorarioNap3 = new javax.swing.JButton();
        JhorarioWon1 = new javax.swing.JButton();
        JhorarioWon2 = new javax.swing.JButton();
        JhorarioWon3 = new javax.swing.JButton();
        JhorarioAq2 = new javax.swing.JButton();
        JhorarioAq3 = new javax.swing.JButton();
        JhorarioAq1 = new javax.swing.JButton();
        JComboSeleccion1 = new javax.swing.JComboBox<>();
        JComboSeleccion2 = new javax.swing.JComboBox<>();
        JComboSeleccion3 = new javax.swing.JComboBox<>();
        Jpelicula1 = new javax.swing.JButton();
        Jpelicula2 = new javax.swing.JButton();
        Jpelicula3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Jpelicula4 = new javax.swing.JButton();
        Jpelicula5 = new javax.swing.JButton();
        Jpelicula6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        JhorarioWhish3 = new javax.swing.JButton();
        JhorarioWhish2 = new javax.swing.JButton();
        JhorarioWhish1 = new javax.swing.JButton();
        JhorarioTeddy3 = new javax.swing.JButton();
        JhorarioTeddy2 = new javax.swing.JButton();
        JhorarioTeddy1 = new javax.swing.JButton();
        JhorarioNdp3 = new javax.swing.JButton();
        JhorarioNdp2 = new javax.swing.JButton();
        JhorarioNdp1 = new javax.swing.JButton();
        JComboSeleccion4 = new javax.swing.JComboBox<>();
        JComboSeleccion5 = new javax.swing.JComboBox<>();
        JComboSeleccion6 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        Jpelicula.setBackground(new java.awt.Color(0, 102, 102));
        Jpelicula.setForeground(new java.awt.Color(255, 255, 255));
        Jpelicula.setText("Pelicula");
        Jpelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JpeliculaActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(0, 102, 102));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cintacine-removebg-preview (1).png"))); // NOI18N
        jLabel20.setText("jLabel20");

        Jdetallepelicula.setBackground(new java.awt.Color(0, 102, 102));
        Jdetallepelicula.setForeground(new java.awt.Color(255, 255, 255));
        Jdetallepelicula.setText("Sinopsis de pelicula");
        Jdetallepelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JdetallepeliculaActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Macotaoficial.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Jdetallepelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Jpelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jpelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jdetallepelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logoboleteria.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        JhorarioNap.setText("15:00");
        JhorarioNap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNapActionPerformed(evt);
            }
        });

        JhorarioNap2.setText("18:00");
        JhorarioNap2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNap2ActionPerformed(evt);
            }
        });

        JhorarioNap3.setText("21:00");
        JhorarioNap3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNap3ActionPerformed(evt);
            }
        });

        JhorarioWon1.setText("11:00");
        JhorarioWon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWon1ActionPerformed(evt);
            }
        });

        JhorarioWon2.setText("13:00");
        JhorarioWon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWon2ActionPerformed(evt);
            }
        });

        JhorarioWon3.setText("19:00");
        JhorarioWon3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWon3ActionPerformed(evt);
            }
        });

        JhorarioAq2.setText("17:00");
        JhorarioAq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioAq2ActionPerformed(evt);
            }
        });

        JhorarioAq3.setText("19:00");
        JhorarioAq3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioAq3ActionPerformed(evt);
            }
        });

        JhorarioAq1.setText("14:00");
        JhorarioAq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioAq1ActionPerformed(evt);
            }
        });

        JComboSeleccion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar sala", "2D", "3D", "3DXD" }));
        JComboSeleccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion1ActionPerformed(evt);
            }
        });

        JComboSeleccion2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Sala", "2D", "3D", "3DXD" }));
        JComboSeleccion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion2ActionPerformed(evt);
            }
        });

        JComboSeleccion3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar sala", "2D", "3D", "3DXD" }));
        JComboSeleccion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion3ActionPerformed(evt);
            }
        });

        Jpelicula1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/napoleon-thai-movie-poster-sm.jpg"))); // NOI18N
        Jpelicula1.setText("Pelicula 1");
        Jpelicula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula1ActionPerformed(evt);
            }
        });

        Jpelicula2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wonka_99581 (1).jpg"))); // NOI18N
        Jpelicula2.setText("Pelicula 2");
        Jpelicula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula2ActionPerformed(evt);
            }
        });

        Jpelicula3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aquaman_y_el_reino_perdido_99744 (1).jpg"))); // NOI18N
        Jpelicula3.setText("Pelicula 3");
        Jpelicula3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setText("Napoleon");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel3.setText("Genero: Cine Historico");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel4.setText("Año: 2023");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel5.setText("Aquaman 2");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel6.setText("Wonka");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel7.setText("Genero: Cine Familiar");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel8.setText("Genero: Accion");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel9.setText("Año: 2023");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel10.setText("Año: 2023");

        Jpelicula4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/noche_de_paz_99354 (1).jpg"))); // NOI18N
        Jpelicula4.setText("Pelicula 4");
        Jpelicula4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula4ActionPerformed(evt);
            }
        });

        Jpelicula5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/teddy_la_magia_de_la_navidad_99752 (1).jpg"))); // NOI18N
        Jpelicula5.setText("Pelicula 5");
        Jpelicula5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula5ActionPerformed(evt);
            }
        });

        Jpelicula6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/wish_el_poder_de_los_deseos_99431 (1).jpg"))); // NOI18N
        Jpelicula6.setText("Pelicula 6");
        Jpelicula6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jpelicula6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel11.setText("Teddy");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel12.setText("Whish");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel13.setText("Noche de Paz");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel14.setText("Genero: Superheroes");

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel15.setText("Genero: Navideño,Familiar");

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel16.setText("Genero: Animación");

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel17.setText("Año: 2023");

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel18.setText("Año: 2023");

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel19.setText("Año: 2023");

        JhorarioWhish3.setText("17:20");
        JhorarioWhish3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWhish3ActionPerformed(evt);
            }
        });

        JhorarioWhish2.setText("14:00");
        JhorarioWhish2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWhish2ActionPerformed(evt);
            }
        });

        JhorarioWhish1.setText("12:40");
        JhorarioWhish1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioWhish1ActionPerformed(evt);
            }
        });

        JhorarioTeddy3.setText("19:00");
        JhorarioTeddy3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioTeddy3ActionPerformed(evt);
            }
        });

        JhorarioTeddy2.setText("16:30");
        JhorarioTeddy2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioTeddy2ActionPerformed(evt);
            }
        });

        JhorarioTeddy1.setText("13:50");
        JhorarioTeddy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioTeddy1ActionPerformed(evt);
            }
        });

        JhorarioNdp3.setText("18:00");
        JhorarioNdp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNdp3ActionPerformed(evt);
            }
        });

        JhorarioNdp2.setText("16:00");
        JhorarioNdp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNdp2ActionPerformed(evt);
            }
        });

        JhorarioNdp1.setText("13:00");
        JhorarioNdp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JhorarioNdp1ActionPerformed(evt);
            }
        });

        JComboSeleccion4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar sala", "2D", "3D", "3DXD" }));
        JComboSeleccion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion4ActionPerformed(evt);
            }
        });

        JComboSeleccion5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar sala", "2D", "3D", "3DXD" }));
        JComboSeleccion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion5ActionPerformed(evt);
            }
        });

        JComboSeleccion6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar sala", "2D", "3D", "3DXD" }));
        JComboSeleccion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboSeleccion6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Jpelicula2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Jpelicula1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jpelicula3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Jpelicula4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Jpelicula5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Jpelicula6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JhorarioWon2)
                            .addComponent(JhorarioWon3)
                            .addComponent(JhorarioAq3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JhorarioNap2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JhorarioNap3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JhorarioAq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JhorarioAq2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JComboSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboSeleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboSeleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboSeleccion6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboSeleccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JComboSeleccion5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(JhorarioNap, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JhorarioWon1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JhorarioWhish3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioWhish2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioWhish1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioTeddy3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioTeddy2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioTeddy1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioNdp3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioNdp2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JhorarioNdp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(723, 723, 723))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Jpelicula1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JhorarioNap)
                            .addComponent(JComboSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(JhorarioNap2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JhorarioNap3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Jpelicula2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Jpelicula3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JhorarioWon1)
                                    .addComponent(JComboSeleccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(JhorarioWon2)
                                .addGap(18, 18, 18)
                                .addComponent(JhorarioWon3)
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JhorarioAq1)
                                    .addComponent(JComboSeleccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(JhorarioAq2)
                                .addGap(18, 18, 18)
                                .addComponent(JhorarioAq3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Jpelicula4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JhorarioNdp1)
                                    .addComponent(JComboSeleccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JhorarioNdp2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JhorarioNdp3)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel19)
                                .addGap(69, 69, 69)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Jpelicula5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Jpelicula6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JhorarioTeddy1)
                                    .addComponent(JComboSeleccion5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JhorarioTeddy2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JhorarioTeddy3)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel18)
                                .addGap(90, 90, 90)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JhorarioWhish1)
                                    .addComponent(JComboSeleccion6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(JhorarioWhish2)
                                        .addGap(18, 18, 18)
                                        .addComponent(JhorarioWhish3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel17)))))))
                .addGap(101, 101, 101))
        );

        jScrollPane2.setViewportView(jPanel1);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1328, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JpeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JpeliculaActionPerformed
  System.out.println("Evento generado por: " + evt.getSource());

    desbloquearControlesPeliculas();

    peliculaSeleccionada = (String) ((JButton) evt.getSource()).getText();

    switch (peliculaSeleccionada) {
        case "Napoleon":
            relacionarConPelicula1();
            break;
        case "Wonka":
            relacionarConPelicula2();
            break;
        case "Aquaman 2":
            relacionarConPelicula3();
            break;
        case "Noche de paz ":
            relacionarConPelicula4();
            break;
        case "Teddy ":
            relacionarConPelicula5();
            break;
        case "Whish ":
            relacionarConPelicula6();
            break;
        default:
            break;
    }

    bloquearHorariosNoRelacionados();
      
    }//GEN-LAST:event_JpeliculaActionPerformed

    private void JhorarioNapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNapActionPerformed
    horarioSeleccionado = "15:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNap;
    actualizarControlesHorarioSeleccionado();
   
    desbloquearSala1();

    }//GEN-LAST:event_JhorarioNapActionPerformed

    private void JhorarioNap2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNap2ActionPerformed
    horarioSeleccionado = "18:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNap2;
    actualizarControlesHorarioSeleccionado();
    
    desbloquearSala1();
    }//GEN-LAST:event_JhorarioNap2ActionPerformed

    private void JhorarioNap3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNap3ActionPerformed
    horarioSeleccionado = "21:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNap3;
    actualizarControlesHorarioSeleccionado();
    
    desbloquearSala1();
    }//GEN-LAST:event_JhorarioNap3ActionPerformed

    private void JhorarioWon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWon1ActionPerformed
    horarioSeleccionado = "11:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioWon1;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala2();            
    }//GEN-LAST:event_JhorarioWon1ActionPerformed

    private void JhorarioWon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWon2ActionPerformed
    horarioSeleccionado = "13:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioWon2;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala2();
    }//GEN-LAST:event_JhorarioWon2ActionPerformed

    private void JhorarioWon3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWon3ActionPerformed
    horarioSeleccionado = "11:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioWon3;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala2();
    }//GEN-LAST:event_JhorarioWon3ActionPerformed

    private void JhorarioAq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioAq1ActionPerformed
    horarioSeleccionado = "14:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioAq1;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala3();
    }//GEN-LAST:event_JhorarioAq1ActionPerformed

    private void JhorarioAq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioAq2ActionPerformed
    horarioSeleccionado = "17:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioAq2;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala3();
    }//GEN-LAST:event_JhorarioAq2ActionPerformed

    private void JhorarioAq3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioAq3ActionPerformed
    horarioSeleccionado = "19:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioAq3;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala3();
    }//GEN-LAST:event_JhorarioAq3ActionPerformed

    private void JComboSeleccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion1ActionPerformed
    salaSeleccionada = (String) JComboSeleccion1.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }

    }//GEN-LAST:event_JComboSeleccion1ActionPerformed

    private void Jpelicula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula3ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Aquaman 2";
    relacionarConPelicula3();
       
    desbloquearSala3();
    }//GEN-LAST:event_Jpelicula3ActionPerformed

    private void Jpelicula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula1ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Napoleon";
    relacionarConPelicula1();
        
    desbloquearHorarios();
    desbloquearSala1();
    }//GEN-LAST:event_Jpelicula1ActionPerformed

    private void Jpelicula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula2ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Wonka";
    relacionarConPelicula2();
       
    desbloquearSala2();
    }//GEN-LAST:event_Jpelicula2ActionPerformed

    private void Jpelicula4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula4ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Noche de paz";
    relacionarConPelicula4();
      
    desbloquearSala4();
    }//GEN-LAST:event_Jpelicula4ActionPerformed

    private void Jpelicula5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula5ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Teddy";
    relacionarConPelicula5();
      
    desbloquearSala5();
    }//GEN-LAST:event_Jpelicula5ActionPerformed

    private void Jpelicula6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jpelicula6ActionPerformed
    desbloquearControlesPeliculas();
    peliculaSeleccionada = "Whish";
    relacionarConPelicula6();
      
    desbloquearSala6();
    }//GEN-LAST:event_Jpelicula6ActionPerformed

    private void JhorarioWhish3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWhish3ActionPerformed
    horarioSeleccionado = "17:20 ";
    ultimoBotonHorarioSeleccionado = JhorarioWhish3;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala6();
    }//GEN-LAST:event_JhorarioWhish3ActionPerformed

    private void JhorarioWhish2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWhish2ActionPerformed
    horarioSeleccionado = "14:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioWhish2;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala6();
    }//GEN-LAST:event_JhorarioWhish2ActionPerformed

    private void JhorarioWhish1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioWhish1ActionPerformed
    horarioSeleccionado = "12:40 ";
    ultimoBotonHorarioSeleccionado = JhorarioWhish1;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala6();
    }//GEN-LAST:event_JhorarioWhish1ActionPerformed

    private void JhorarioTeddy3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioTeddy3ActionPerformed
    horarioSeleccionado = "19:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioTeddy3;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala5();
    }//GEN-LAST:event_JhorarioTeddy3ActionPerformed

    private void JhorarioTeddy2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioTeddy2ActionPerformed
    horarioSeleccionado = "16:30 ";
    ultimoBotonHorarioSeleccionado = JhorarioTeddy2;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala5();
    }//GEN-LAST:event_JhorarioTeddy2ActionPerformed

    private void JhorarioTeddy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioTeddy1ActionPerformed
    horarioSeleccionado = "13:50 ";
    ultimoBotonHorarioSeleccionado = JhorarioTeddy1;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala5();
    }//GEN-LAST:event_JhorarioTeddy1ActionPerformed

    private void JhorarioNdp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNdp3ActionPerformed
    horarioSeleccionado = "18:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNdp3;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala4();
    }//GEN-LAST:event_JhorarioNdp3ActionPerformed

    private void JhorarioNdp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNdp2ActionPerformed
    horarioSeleccionado = "16:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNdp2;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala4();
    }//GEN-LAST:event_JhorarioNdp2ActionPerformed

    private void JhorarioNdp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JhorarioNdp1ActionPerformed
    horarioSeleccionado = "13:00 ";
    ultimoBotonHorarioSeleccionado = JhorarioNdp1;
    actualizarControlesHorarioSeleccionado();
     
    desbloquearSala4();
    }//GEN-LAST:event_JhorarioNdp1ActionPerformed

    private void JComboSeleccion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion4ActionPerformed
     salaSeleccionada = (String) JComboSeleccion4.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }
    }//GEN-LAST:event_JComboSeleccion4ActionPerformed

    private void JComboSeleccion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion2ActionPerformed
    salaSeleccionada = (String) JComboSeleccion2.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }
    }//GEN-LAST:event_JComboSeleccion2ActionPerformed

    private void JComboSeleccion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion3ActionPerformed
    salaSeleccionada = (String) JComboSeleccion3.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }
    }//GEN-LAST:event_JComboSeleccion3ActionPerformed

    private void JComboSeleccion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion5ActionPerformed
    salaSeleccionada = (String) JComboSeleccion5.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }
    }//GEN-LAST:event_JComboSeleccion5ActionPerformed

    private void JComboSeleccion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboSeleccion6ActionPerformed
    salaSeleccionada = (String) JComboSeleccion6.getSelectedItem();
    // Verificar si se han realizado todas las selecciones
    if (peliculaSeleccionada != null && horarioSeleccionado != null && salaSeleccionada != null) {
        // Realizar la reserva
        realizarReserva();
        // Reiniciar las variables para futuras selecciones
        peliculaSeleccionada = null;
        horarioSeleccionado = null;
        salaSeleccionada = null;
    }
    }//GEN-LAST:event_JComboSeleccion6ActionPerformed

    private void JdetallepeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JdetallepeliculaActionPerformed
       mostrarSinopsisPelicula();
    }//GEN-LAST:event_JdetallepeliculaActionPerformed
                                                        
   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cartelera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Cartelera dialog = new Cartelera(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboSeleccion1;
    private javax.swing.JComboBox<String> JComboSeleccion2;
    private javax.swing.JComboBox<String> JComboSeleccion3;
    private javax.swing.JComboBox<String> JComboSeleccion4;
    private javax.swing.JComboBox<String> JComboSeleccion5;
    private javax.swing.JComboBox<String> JComboSeleccion6;
    private javax.swing.JButton Jdetallepelicula;
    private javax.swing.JButton JhorarioAq1;
    private javax.swing.JButton JhorarioAq2;
    private javax.swing.JButton JhorarioAq3;
    private javax.swing.JButton JhorarioNap;
    private javax.swing.JButton JhorarioNap2;
    private javax.swing.JButton JhorarioNap3;
    private javax.swing.JButton JhorarioNdp1;
    private javax.swing.JButton JhorarioNdp2;
    private javax.swing.JButton JhorarioNdp3;
    private javax.swing.JButton JhorarioTeddy1;
    private javax.swing.JButton JhorarioTeddy2;
    private javax.swing.JButton JhorarioTeddy3;
    private javax.swing.JButton JhorarioWhish1;
    private javax.swing.JButton JhorarioWhish2;
    private javax.swing.JButton JhorarioWhish3;
    private javax.swing.JButton JhorarioWon1;
    private javax.swing.JButton JhorarioWon2;
    private javax.swing.JButton JhorarioWon3;
    private javax.swing.JButton Jpelicula;
    private javax.swing.JButton Jpelicula1;
    private javax.swing.JButton Jpelicula2;
    private javax.swing.JButton Jpelicula3;
    private javax.swing.JButton Jpelicula4;
    private javax.swing.JButton Jpelicula5;
    private javax.swing.JButton Jpelicula6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

   
}
