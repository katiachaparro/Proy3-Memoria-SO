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
        lista.setArrayPaginasRam(new Pagina[5]);
        if(lista.getArrayPaginasRam() ==null){System.out.println("es nulo");}
        ArrayList<Proceso> procesos = (ArrayList)lista.getListadeProcesos();
        for(Proceso p : procesos){
            //System.out.println("proceso "+ p.getNombreProceso() + "tiempo de rafaga" +p.getTiempoRafaga());
            for (Pagina pag: p.getListadePagina()){    
              //System.out.println("pagina "+ pag.getIdentificador()); 
              for(String in: pag.getInstruccion()){
                  //System.out.println(in);
              }
            }
           
            
        }
        
        //Proceso p = new Proceso();
        //Cpu a = new Cpu(p);
        //a.cargarRamInicialmente();
        //System.out.println(p.getEstado());
        Principal a = new Principal();
        a.setVisible(true);
        //int duracionRafaga= 1;
        RoundRobin r = new RoundRobin(lista,a,10000);
        
        
        System.out.println("*********************");
        System.out.println("MEMORIA RAM");
        for(int i = 0;i<lista.getArrayPaginasRam().length;i++){
            System.out.println(lista.getArrayPaginasRam()[i].getIdentificador());
        }
        System.out.println("*********************");
        System.out.println("MEMORIA VIRTUAL");
        for(Pagina p :lista.getListaPaginasVirtual()){
            System.out.println(p.getIdentificador());
        }
        
   
       
    }
    
}
