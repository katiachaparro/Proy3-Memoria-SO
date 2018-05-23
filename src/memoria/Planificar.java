
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Escurra
 */
public class Planificar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaProcesos lista = new ListaProcesos();
        lista.cargarList("MisProcesos.txt");
        lista.setArrayPaginasRam(new Pagina[4]);       
        lista.setQuantun(3);
        Ventana a = new Ventana();
        a.setVisible(true);
        RoundRobin r = new RoundRobin(lista,a,1000);
        

        
    
       
    }
    
}
