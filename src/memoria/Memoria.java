/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Escurra
 */
public class Memoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaProcesos lista = new ListaProcesos();
        lista.cargarList("MisProcesos.txt");
        /*String procesos [] = lista.getProcesos("MisProcesos.txt");
        for(int i=1; i<procesos.length;i++){
            System.out.println(procesos[i]);
        }*/
        
    }
    
}
