package Interfaces;

import Logica.LeerJsonProfesores;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class VentanaAdmin extends JFrame implements ActionListener{

    LeerJsonProfesores llamarProfesores = new LeerJsonProfesores();
    JMenuBar menuBar;
    JMenu menuOpciones;
    JScrollPane scrollPane;
    JLabel fondoProfe;
    JLabel titulo;
    JTextArea textArea;
    JTable tablaProfesores;
    JButton cerrarSesion;
    JButton crear;
    JButton cargaMasiva;
    JButton actualizar;
    JButton eliminar;
    JButton exportarPDF;
    
    public static JPanel panelProfesores;
    public static JPanel panelCursos;
    public static JPanel panelEstudiantes;
    public static JTabbedPane pestanas;
    public static String[] columnas;
    public static String[][] matriz;
    
    public VentanaAdmin() {
        
        columnas = new String[5];
        matriz = new String[50][5];
        columnas[0] = "Código";
        columnas[1] = "Nombre";
        columnas[2] = "Apellido";
        columnas[3] = "Correo";
        columnas[4] = "Genero";
        
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
        textArea.setBounds(600, 190, 280, 340);
        add(textArea);
        panelProfesores.add(textArea);
        JTable tablaProfesores = new JTable(matriz, columnas);
        
        scrollPane = new JScrollPane(tablaProfesores);
        scrollPane.setVisible(true);
        scrollPane.setBounds(10, 50,580, 480);
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
        
        crear = new JButton("Crear");
        crear.setBounds(600, 50, 120, 30);
        crear.setFont(new Font ("Andale Mono" , 1, 12));
        crear.setForeground(new Color(0, 0, 0));
        crear.addActionListener(this);
        add(crear);
        panelProfesores.add(crear);
        
        cargaMasiva = new JButton("Carga Masiva");
        cargaMasiva.setBounds(740, 50, 120, 30);
        cargaMasiva.setFont(new Font ("Andale Mono" , 1, 12));
        cargaMasiva.setForeground(new Color(0, 0, 0));
        cargaMasiva.addActionListener(this);
        add(cargaMasiva);
        panelProfesores.add(cargaMasiva);
        
        actualizar = new JButton("Actualizar");
        actualizar.setBounds(600, 100, 120, 30);
        actualizar.setFont(new Font ("Andale Mono" , 1, 12));
        actualizar.setForeground(new Color(0, 0, 0));
        actualizar.addActionListener(this);
        add(actualizar);
        panelProfesores.add(actualizar);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(740, 100, 120, 30);
        eliminar.setFont(new Font ("Andale Mono" , 1, 12));
        eliminar.setForeground(new Color(0, 0, 0));
        eliminar.addActionListener(this);
        add(eliminar);
        panelProfesores.add(eliminar);
        
        exportarPDF = new JButton("Exportar Listado a PDF");
        exportarPDF.setBounds(600, 150, 260, 30);
        exportarPDF.setFont(new Font ("Andale Mono" , 1, 12));
        exportarPDF.setForeground(new Color(0, 0, 0));
        exportarPDF.addActionListener(this);
        add(exportarPDF);
        panelProfesores.add(exportarPDF);
        
    }//Fin del constructor
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //evento para el boton cerrar sesión
        if(e.getSource() == cerrarSesion){
            VentanaPrincipal VentanaPrin = new VentanaPrincipal();
            VentanaPrincipal.VentanaPrin();
            this.setVisible(false);
        }
        //Fin del evento para el boton cerrar sesion
        
        //asignar evento al boton crear
        if(e.getSource() == crear){
            //LeerJsonProfesores.CrearProfesores();
        }
        // fin del evento para el boton crea
        
        //asignar evento al boton carga masiva
        if (e.getSource() == cargaMasiva) {
            
            String ruta;
            ruta = JOptionPane.showInputDialog("Ingrese la ruta");
            while("".equals(ruta)){
                ruta = JOptionPane.showInputDialog("Ingrese la ruta");
            }
            try {
                LeerJsonProfesores.CrearProfesores(ruta);
            } catch (IOException ex) {
                Logger.getLogger(VentanaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // fin del evento para el boton carga masiva
        
    }// Fin del método para agregar eventos a los botones

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
