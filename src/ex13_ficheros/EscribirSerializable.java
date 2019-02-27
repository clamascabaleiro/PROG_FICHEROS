package ex13_ficheros;

import Utilidad.PedirDatos;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author clamascabaleiro
 */
public class EscribirSerializable {
    ObjectOutputStream fich;
    FileOutputStream f;
    
    public void escribirObjetosSeri(String nome){
        try {
            f = new FileOutputStream(nome + ".dat");
            fich = new ObjectOutputStream(f);
            
            for(int i = 0; i<3 ; i++){
                Alumno al = new Alumno(PedirDatos.palabra("nome"), PedirDatos.entero("nota"));
                fich.writeObject(al);
            }

            
        
        }catch (FileNotFoundException ex) {
            System.out.println("Error1" + ex.getMessage());
         
        }catch (IOException ex) {
            System.out.println("Error2" + ex.getMessage());
        }finally{
            try {
                fich.close();
                f.close();
            } catch (IOException ex) {
                System.out.println("Error3" + ex.getMessage());
            }
            
        }
        
        
    }

}
