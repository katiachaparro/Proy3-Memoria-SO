/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

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
        //lista.imprimir();
        Principal a = new Principal();
        a.setVisible(true);
        int duracionRafaga= 1;
        RoundRobin r = new RoundRobin(lista,a,1000);
        //NUESTROS ALGORITMOS
        //SJF A = new SJF(lista, a,10000);
        //FCFS f = new FCFS(lista,a,2);
        //ColasMulitNivel g = new ColasMulitNivel(lista,a,1000);
        //f.imprimirList(f.ordenarPorLlegada(lista,0));
    }
    
}
