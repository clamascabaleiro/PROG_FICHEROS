package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clamascabaleiro
 */
public class Leer {
    // declarar un scanner

    Scanner teclado;
    //lee palabra por palabra
    // File abre la ruta o el nombre del fichero, por lo q tenemos q crear el flujo 
    //para poder leer

    //metodo lee hasta el delimitador espacio
    public void leerPalabras(File fich) {
        //se recoge la excepcion por sino hay fichero
        try {
            //se crea un nuevo escaner que lee del fichero
            teclado = new Scanner(fich);
            //mientras haya algo en el fichero que lo imprima
            while (teclado.hasNext()) {
                System.out.println(teclado.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            teclado.close();
        }

    }

    //lee linea por linea
    public void leerLineas(File fich) throws FileNotFoundException {
        teclado = new Scanner(fich);
        while (teclado.hasNextLine()) {
            System.out.println(teclado.nextLine());
        }
        teclado.close();
    }

    //el metodo lee hasta otro delimitador en este caso ","
    public void leerDelimitador(File fich) {
        try {
            teclado = new Scanner(fich).useDelimiter("\\s*,\\s*");
            // \\s* para que coja los espacios que tenga sea uno o varios
            while (teclado.hasNext()) {
                System.out.println(teclado.next());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            teclado.close();
        }
    }

    //leer numeros del fichero y añadir en un array
    public ArrayList<Integer> LeerNumeros(File fich, ArrayList<Integer> numeros) {
        try {
            teclado = new Scanner(fich).useDelimiter("\\s*,\\s*");
            while (teclado.hasNextInt()) {
                numeros.add(teclado.nextInt());

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());;
        } finally {
            teclado.close();
        }
        return numeros;
    }

    public void leerObxetos(File fich) {
        try {
            teclado = new Scanner(fich);
            while (teclado.hasNextLine()) {
                String[] alumno = teclado.nextLine().split(" ");
                /*
                split separa por una String que tengamos el delimitador que queramos 
                y nos da un Array String con los elementos de cada linea
                en este caso 2 el nombre y el numero
                 */
                System.out.println(alumno[0] + " " + alumno[1]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            teclado.close();
        }
    }
}
