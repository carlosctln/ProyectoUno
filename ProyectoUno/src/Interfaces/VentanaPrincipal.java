package Interfaces;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class VentanaPrincipal extends JFrame implements ActionListener{
    
    VentanaAdmin VentAdmin = new VentanaAdmin();
    JLabel fondo;
    JLabel etiIngresar;
    JLabel usuarioL;
    JLabel contraseniaL;
    public static JTextField usuarioT;
    public static JPasswordField contraseniaT;
    JButton botonAdmin;
    JButton botonProfe;
    JButton botonStudent;
    public static JPanel contenedor;
    public static String Usuario = "";
    public static String Contrasenia = "";

    public VentanaPrincipal() {
        setLayout(null);
        //setIconImage(new ImageIcon(getClass().getResource("images/icon.jpg")).getImage());
        
        contenedor = new JPanel();
        contenedor.setBounds(0, 0, 350, 450);
        contenedor.setVisible(true);
        contenedor.setLayout(null);
        contenedor.setBackground(Color.red);
        
        ImageIcon fondoPrin = new ImageIcon("images/fondoPrincipal.jpg");
        fondo = new JLabel(fondoPrin);
        fondo.setBounds(0, -15, 350, 450);
        fondo.setLayout(null);
        fondo.setVisible(true);
        contenedor.add(fondo);
        
        etiIngresar = new JLabel("Ingresar");
        etiIngresar.setBounds(135, 30, 200, 30);
        etiIngresar.setFont(new Font("Andale Mono", 3, 18));
        etiIngresar.setForeground(new Color(0, 255, 255));
        add(etiIngresar);
        
        usuarioL = new JLabel("Usuario:");
        usuarioL.setBounds(135, 70, 200, 30);
        usuarioL.setFont(new Font("Andale Mono", 3, 18));
        usuarioL.setForeground(new Color(0, 255, 255));
        add(usuarioL);
        
        usuarioT = new JTextField("");
        usuarioT.setBounds(75, 100, 200, 30);
        usuarioT.setBackground(new Color(224,224,224));
        usuarioT.setFont(new Font("Andale Mono", 3, 18));
        usuarioT.setForeground(new Color(0, 0, 0));
        //contenedor.add(usuarioT);
        add(usuarioT);
        
        contraseniaL = new JLabel("Contraseña:");
        contraseniaL.setBounds(125, 140, 200, 30);
        contraseniaL.setFont(new Font("Andale Mono", 3, 18));
        contraseniaL.setForeground(new Color(0, 255, 255));
        add(contraseniaL);
        
        contraseniaT = new JPasswordField("");
        contraseniaT.setBounds(75, 170, 200, 30);
        contraseniaT.setBackground(new Color(224,224,224));
        contraseniaT.setFont(new Font("Andale Mono", 3, 18));
        contraseniaT.setForeground(new Color(0, 0, 0));
        add(contraseniaT);
        
        botonAdmin = new JButton("Admin");
        botonAdmin.setBounds(125, 210, 100, 30);
        botonAdmin.setFont(new Font ("Andale Mono" , 1, 14));
        botonAdmin.setForeground(new Color(0, 0, 0));
        botonAdmin.addActionListener(this);
        add(botonAdmin);
        
        botonProfe = new JButton("Profesor");
        botonProfe.setBounds(70, 250, 100, 30);
        botonProfe.setFont(new Font ("Andale Mono" , 1, 14));
        botonProfe.setForeground(new Color(0, 0, 0));
        botonProfe.addActionListener(this);
        add(botonProfe);
        
        botonStudent = new JButton("Estudiante");
        botonStudent.setBounds(180, 250, 100, 30);
        botonStudent.setFont(new Font ("Andale Mono" , 1, 14));
        botonStudent.setForeground(new Color(0, 0, 0));
        add(botonStudent);
        
    }// fin del constructor
    
    @Override
    public void actionPerformed(ActionEvent e){ 
        if(e.getSource() == botonAdmin){
            Usuario = usuarioT.getText().trim();
            Contrasenia = contraseniaT.getText();
            
            if(Usuario.equals("") || Contrasenia.equals("")){
                JOptionPane.showMessageDialog(null,"Debes de llenar todos los campos.");
            }//fin del if campos
            
            if(!"admin".equals(Usuario) || !"admin".equals(Contrasenia)){
                JOptionPane.showMessageDialog(null,"Usuario o contarseña incorrectos.");
            }else{
                
                VentanaAdmin.VentAdmin();
                this.setVisible(false); 
                
            }//Fin del if-else para validar el acceso del Admin
            
        }// fin del if para capturar el boton
        
    }//Fin del método para agregar eventos a los botones
    
    public static void VentanaPrin(){
        
        VentanaPrincipal principal = new VentanaPrincipal();
        principal.setTitle("REGISTRO DTT");
        principal.setBounds(0, 0, 350, 450);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        principal.setDefaultCloseOperation(EXIT_ON_CLOSE);
        principal.setResizable(false);
        principal.add(contenedor);

    }
    
}// Fin de la clase VentanaPrincipal
