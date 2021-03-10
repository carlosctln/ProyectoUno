package Interfaces;

import com.sun.imageio.plugins.jpeg.JPEG;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VentanaAdmin extends JFrame {

    public static JPanel contenedor1;
    JMenuBar menuBar;
    JMenu menuOpciones;
    JScrollPane scrollPane;
    JLabel fondoProfe;
    JLabel titulo;
    JTextArea textArea;
    JTable tablaProfesores;
    public static JPanel panelProfesores;
    public static JPanel panelCursos;
    public static JPanel panelEstudiantes;
    public static JTabbedPane pestanas;

    public VentanaAdmin() {
        pestanas = new JTabbedPane();
        pestanas.setBounds(0, 0, 350, 450);
        pestanas.setVisible(true);

        /*contenedor1 = new JPanel();
        contenedor1.setBounds(0, 0, 600, 660);
        contenedor1.setVisible(true);
        contenedor1.setBackground(Color.blue);*/

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

        /*ImageIcon fondoProf = new ImageIcon("images/fondoProfesores.jpg");
        fondoProfe = new JLabel(fondoProf);
        fondoProfe.setBounds(0, 0, 600, 600);
        fondoProfe.setLayout(null);
        fondoProfe.setVisible(true);
        panelProfesores.add(fondoProfe);*/
        
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
        

    }//Fin del constructor
    
    class TablaProfesores extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return 50;
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return null;
        }
    }// fin de la clase para crear la tabla

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
