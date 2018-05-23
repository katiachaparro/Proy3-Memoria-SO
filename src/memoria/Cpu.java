
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
        
        
        
        
        
    }
    // si ya no tiene sus paginas, utilizar el metodo que 
    // trae las paginas que necesita segun su quantun
    
}
