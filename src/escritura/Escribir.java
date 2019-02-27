/**
 *Clase con metodos de escritura para ficheros
 */
package escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utilidad.PedirDatos;
import ex13_ficheros.Alumno;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author clamascabaleiro
 */
public class Escribir {

    File fich = null;
    PrintWriter f = null;

    public File escribirNumeros(String nomeFich) {
        fich = new File(nomeFich + ".txt");
        //cuando abrimos el fichero para escribir puede no existir entonces lo crea
        // si existe lo machaca y vuelve a empezar a escribir desde el principio SOBREESCRIBE
        //Si quieres añadir hay que usar otro metodo
        try {
            //abrir flujo de escritura
            f = new PrintWriter(fich);
            f.println(PedirDatos.entero(nomeFich));
            f.println(PedirDatos.entero(nomeFich));
            f.println(PedirDatos.entero(nomeFich));
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            f.close();
        }

        return fich;
    }
    public void escribirLineas(File fich,String nomeFich, ArrayList<Alumno>lista){
        try{
            f = new PrintWriter(fich);
            for(Alumno al:lista){
                f.println(al.getNome() + "," + al.getNota());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("error" + ex.getMessage());
        }finally{
            f.close();
        }
        
    }
     public void engadir (String nomeFich){
         try{
             f = new PrintWriter(new FileWriter(nomeFich + ".txt", true));
             Alumno al = new Alumno(PedirDatos.palabra("nome"), PedirDatos.entero("nota"));
             f.println(al);
         }catch (IOException e){
             System.out.println("Error" + e.getMessage());
         }finally{
             f.close();
         }
     }
}
