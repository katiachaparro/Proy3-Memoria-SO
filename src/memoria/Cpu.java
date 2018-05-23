
package memoria;
import java.util.ArrayList;

/**
 *
 * @author Escurra
 */
public class Cpu {
    Proceso _proceso;
    int _totalDePaginas;
    ListaProcesos _lista;
    Pagina _paginaObtenida;
    
    public Cpu(){}
    public Cpu(Proceso proceso){
    _proceso = proceso;
    }
    public Cpu(ListaProcesos listas,Proceso proceso){
        _lista  = listas;
        _proceso = proceso;
    }
    // cuando tiene todas sus paginas
    public void cargarRamInicialmente(){
        boolean ramdon = true;
        int[]numeros_aleatorios = new int[3]; 
        int aleatorio = 0;
        for(int a= 0 ;a<3;a++){
            while(ramdon){
               aleatorio =  (int) (Math.random() * (_proceso.getListadePagina().size() -1) +1);
                ramdon = false;
                for (int i = 0 ; i< 3;i++){   
                    if(numeros_aleatorios [i] == aleatorio){
                        ramdon = true;
                    }
                }
            }
            numeros_aleatorios[a] = aleatorio;
            ramdon= true;
        }
        ArrayList<Pagina> paginas = new ArrayList<Pagina>();
        
        //grabamos en memoria Ram los 3 aleatorios
        for(int i=0;i<3;i++){
            
            LRU algoritmo = new LRU(_lista,_proceso.getListadePagina().get(numeros_aleatorios[i]));
            System.out.println("cargado en memoria la pagina" +_proceso.getListadePagina().get(numeros_aleatorios[i]).getIdentificador() );
           
            paginas.add(_proceso.getListadePagina().get(numeros_aleatorios[i]));
        }
        
        for(Pagina p : paginas){
            _proceso.getListadePagina().remove(p);
        }
       
           
            
         
        // el resto a memoria virtual
        if(_proceso.getListadePagina() !=null){
            for(Pagina pa : _proceso.getListadePagina()){
                _lista.getListaPaginasVirtual().add(pa);
            }
         
        }
        
        
        // eliminamos las paginas del proceso
        _proceso.setListadePagina(null);
        
    }
    // si ya no tiene sus paginas, utilizar el metodo que 
    // trae las paginas que necesita segun su quantun
    public void ejecutamosPagina(){
        boolean marco =false ;
       
        
        // si esta en ram lo obtenemos , liberamos ram y movemos 
        Pagina _memoriaRam[] = _lista.getArrayPaginasRam();
        for(int i = 0;i< _memoriaRam.length; i++){
            if(_memoriaRam[i].getProceso() == _proceso && marco ==false){
                marco = true;
                _paginaObtenida = _memoriaRam[i];
                break;
            }
            if(marco == true && i+1 < _memoriaRam.length){
                _memoriaRam[i] = _memoriaRam[i+1];
            }
            if(marco == true && i+1 == _memoriaRam.length){
                _memoriaRam[i]= null;
            }
        }
        
        // si no esta en RAM
        // verificar virtual, cargar a Ram y devolver pagina
        
    }
    
    public boolean hayMarco(Pagina[] _memoriaRam){
        boolean hay_espacio = false;
        for (Pagina _memoriaRam1 : _memoriaRam) {
            if (_memoriaRam1 == null) {
                hay_espacio = true;
            }
        }
       return hay_espacio;
    }
}
