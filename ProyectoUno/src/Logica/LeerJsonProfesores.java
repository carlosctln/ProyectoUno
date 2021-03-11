package Logica;

import Interfaces.VentanaAdmin;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerJsonProfesores {
    
    public static int numeroProfes = 0;
    //VentanaAdmin regresarAdmin = new VentanaAdmin();
    
    public static void CrearProfesores(String ruta) throws IOException{
        
        String json = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String linea;
            
            while((linea = br.readLine()) != null){
                json += linea;
            }
            br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerJsonProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(json);
        
        Gson gson = new Gson();
        Profesores[] p = gson.fromJson(json, Profesores[].class);
        numeroProfes = p.length;
        numProf(numeroProfes);
        //System.out.println(p[0]);
              
    }// fin del metodo CrearProfesores
    
    public static void numProf(int numeroProfes){
        System.out.println(numeroProfes);
        /*if((numeroProfes == 0) || (numeroProfes > 7)){
           // VentanaAdmin.VentAdmin();
        }*/
    }


}// Fin de la clase LeerJsonProfesores
