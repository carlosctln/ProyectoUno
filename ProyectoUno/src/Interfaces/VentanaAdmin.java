package Interfaces;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VentanaAdmin extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu menuOpciones;
    JScrollPane scrollPane;
    JLabel fondoProfe;
    JLabel titulo;
    JTextArea textArea;
    JTable tablaProfesores;
    JButton cerrarSesion;
    public static JPanel panelProfesores;
    public static JPanel panelCursos;
    public static JPanel panelEstudiantes;
    public static JTabbedPane pestanas;

    public VentanaAdmin() {
        pestanas = new JTabbedPane();
        pestanas.setBounds(0, 0, 350, 450);
        pestanas.setVisible(true);

        panelProfesores = new JPanel();
        panelProfesores.setBounds(0, 0, 600, 600);
        panelProfesores.setVisible(true);
        panelProfesores.setLayout(null);
        panelProfesores.setBackground(Color.green);
        pestanas.addTab("Profesores", panelProfesores);

        panelCursos = new JPanel();
        panelCursos.setBounds(0, 0, 600, 600);
        panelCursos.setVisible(true);
        panelCursos.setLayout(null);
        panelCursos.setBackground(Color.yellow);
        pestanas.addTab("Cursos", panelCursos);

        panelEstudiantes = new JPanel();
        panelEstudiantes.setBounds(0, 0, 600, 600);
        panelEstudiantes.setVisible(true);
        panelEstudiantes.setLayout(null);
        panelEstudiantes.setBackground(Color.black);
        pestanas.addTab("Estudiantes", panelEstudiantes);
        
        textArea = new JTextArea();
        textArea.setVisible(true);
        TableModel tablaUno = new TablaProfesores();
        JTable miTabla = new JTable(tablaUno);
        scrollPane = new JScrollPane(miTabla);
        scrollPane.setVisible(true);
        scrollPane.setBounds(10, 50, 435, 480);
        add(scrollPane);
        panelProfesores.add(scrollPane);

        titulo = new JLabel("Listado Oficial");
        titulo.setBounds(10, 10, 150, 30);
        titulo.setVisible(true);
        titulo.setFont(new Font("Andale Mono", 3, 18));
        panelProfesores.add(titulo);
        
        cerrarSesion = new JButton("Cerrar sesión");
        cerrarSesion.setBounds(760, 10, 120, 30);
        cerrarSesion.setFont(new Font ("Andale Mono" , 1, 12));
        cerrarSesion.setForeground(new Color(0, 0, 0));
        cerrarSesion.addActionListener(this);
        add(cerrarSesion);
        panelProfesores.add(cerrarSesion);

    }//Fin del constructor
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cerrarSesion){
            VentanaPrincipal VentanaPrin = new VentanaPrincipal();
            VentanaPrincipal.VentanaPrin();
            this.setVisible(false);
        }
    }// Fin del método para agregar eventos a los botones
    
    // clase para crear una tabla
    class TablaProfesores extends AbstractTableModel{

        //aca se definen las filas
        @Override
        public int getRowCount() {
            return 50;
        }

        //aca se definen las columnas
        @Override
        public int getColumnCount() {
            String codigo = "Código"; 
            return 5;
        }

        // este metodo recibe obejtos como para metros y se usa para llenar la tabla
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    }// fin de la clase para crear la tabla
    
    public String getColumnName(int columna){
        return "Código" + columna;
        
    }// fin del método para renombrar las columnas

    public static void VentAdmin() {

        VentanaAdmin ventana = new VentanaAdmin();
        ventana.setTitle("Administrador");
        ventana.setBounds(0, 0, 900, 600);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.add(pestanas);

    }//Fin del método VentAdmin

}// Fin de la VentanAdmin
