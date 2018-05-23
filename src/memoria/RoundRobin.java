
package memoria;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Escurra
 */
public class RoundRobin {
    private ListaProcesos _procesos;
    private Ventana _ventana;
    private int orden = 0;
    private boolean condicion = true;
    private boolean rafaga = true;
    private int tiempora;
    public RoundRobin(ListaProcesos procesos,Ventana ventana,int tiemporafaga){
        _procesos = procesos;
        _ventana = ventana;
        _procesos = _procesos.ordenarPorTiempoLlegada(_procesos,0);
        tiempora= tiemporafaga;
        algoritmo();
    }
    public void  algoritmo(){
    while(condicion){
        /*obtenemos el proceso y lo colocamos como preparado
        obtenemos 3 paginas del proceso y colocamos en memoria Ram
        las demas las colocamos en memoria virtual*/
        Proceso primero = (Proceso)_procesos.getProceso(orden);
        primero.setEstado("Preparado");
        System.out.println("Preparado + "+primero.getNombreProceso() );
        _ventana.setTabla(_procesos.tamano(), _procesos);
        //_ventana.setRafaga(_procesos);
        
        // si tenemos las paginas en disco duro , las cargamos en ram y virtual
        if(primero.getListadePagina()!= null){
            Cpu cpu = new Cpu(_procesos,primero,_ventana);
            cpu.cargarRamInicialmente();
        }
        
        try {
                Thread.sleep(tiempora);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }   
        Proceso segundo;
         
         
        primero.setEstado("Ejecutando"); 
        System.out.println("Ejecutando + "+primero.getNombreProceso() );
        
      
        try{_ventana.setTabla(_procesos.tamano(), _procesos);}catch(Exception e){}
         
        try {
                Thread.sleep(tiempora);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }   
         
        for(int a = 0 ;a< primero.getTiempoRafaga();a++){
            // ejecutamos el proceso, una rafaga a la vez
            primero.setTEjecutado(primero.getTEjecutado() + 1);
            
            //EJECUTAMOS UNA PAGINA
            Cpu c = new Cpu(_procesos,primero,_ventana);        
            c.ejecutamosPagina();
     
            
            //try{_ventana.setRafaga(_procesos);}catch(Exception e){};
            _procesos.setRafaga(_procesos.getRafaga() + 1);
            
            
            
            if(orden +1 < _procesos.tamano() && primero.getTEjecutado()!= primero.getTiempoRafaga()){
                segundo= (Proceso)_procesos.getProceso(orden+1);
                
                if(a +2 >_procesos.getQuantun()){
                   Proceso aux = segundo;
                   _procesos.setProceso(orden+1, primero);
                   _procesos.setProceso(orden,aux);
                        
                   a= primero.getTiempoRafaga();
                   orden --;
                   primero.setEstado("Preparado");
                   System.out.println("Preparado + "+primero.getNombreProceso() );
                   try{_ventana.setTabla(_procesos.tamano(), _procesos);}catch(Exception e){}
                    
                }
            }else{
               if(primero.getTEjecutado()== primero.getTiempoRafaga()){
                   a= primero.getTiempoRafaga();
               }
               
            }
            
            
            
        }
        try{_ventana.setTabla(_procesos.tamano(), _procesos);}catch(Exception e){}
        
       
        try {
                Thread.sleep(tiempora);
            } catch (InterruptedException ex) {
               // Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            } 
        if(primero.getTiempoNoEjecutado()<= 0){
        primero.setEstado("Terminado");
        System.out.println("Terminado + "+primero.getNombreProceso() );
        }
       
        orden ++;
        try{_ventana.setTabla(_procesos.tamano(), _procesos);}catch(Exception e){
        
        }
        
        if(orden == _procesos.tamano()){
            condicion = false;
        }
    }
 }
}