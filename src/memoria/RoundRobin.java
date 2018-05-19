/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Escurra
 */
public class RoundRobin {
    private ListaProcesos _procesos;
    //private Principal _ventana;
    private int orden = 0;
    private boolean condicion = true;
    private boolean rafaga = true;
    private int tiempora;
    public RoundRobin(ListaProcesos procesos,int tiemporafaga){
        _procesos = procesos;
        //_ventana = ventana;
        _procesos = _procesos.ordenarPorTiempoLlegada(_procesos,0);
        tiempora= tiemporafaga;
        algoritmo();
    }
    public void  algoritmo(){
    while(condicion){
        Proceso primero = (Proceso)_procesos.getProceso(orden);
        primero.setEstado("Preparado");
        //_ventana.setTabla(_procesos.tamano(), _procesos);
        //_ventana.setRafaga(_procesos);
        try {
                Thread.sleep(tiempora);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }   
         Proceso segundo;
         Proceso anterior;
        primero.setEstado("Ejecutado"); 
        //_ventana.setTabla(_procesos.tamano(), _procesos);
        for(int a = 0 ;a< primero.getTiempoRafaga();a++){
            primero.setTEjecutado(primero.getTEjecutado() + 1);
           //_ventana.setRafaga(_procesos);
            _procesos.setRafaga(_procesos.getRafaga() + 1);
            System.out.println(_procesos.getRafaga());
            if(orden +1 < _procesos.tamano()){
                segundo= (Proceso)_procesos.getProceso(orden+1);
                
                if(a +1 > _procesos.getQuantun()){
                   Proceso aux = segundo;
                   _procesos.setProceso(orden+1, primero);
                   _procesos.setProceso(orden,aux);
                        
                   a= primero.getTiempoRafaga();
                   orden --;
                   primero.setEstado("Preparado");
                  // _ventana.setTabla(_procesos.tamano(), _procesos);
                }
            }
            
            
            
        }
        
        // _ventana.setTabla(_procesos.tamano(), _procesos);
        try {
                Thread.sleep(tiempora);
            } catch (InterruptedException ex) {
               // Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            } 
        if(primero.getTiempoNoEjecutado() <= 0){
        primero.setEstado("Terminado");
        }
       
        orden ++;
        
        //_ventana.setTabla(_procesos.tamano(), _procesos);
        if(orden == _procesos.tamano()){
            condicion = false;
        }

        }
        // si es mayor se modifico la tabla de procesos en la interfaz
        /*if(_ventana.getTamanoProcesos() >_procesos.tamano() ){
            _procesos = _ventana.getProcesos();
            _procesos.ordenarPorTiempoLlegada(_procesos, orden);
            orden--;
        }*/
    }
    
}
