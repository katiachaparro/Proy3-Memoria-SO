
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
                aleatorio =  (int) (Math.random() * _proceso.getListaPaginasDisco().size() -1) + 1;
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
        ArrayList<Pagina> paginas = _proceso.getListaPaginasDisco();
        //grabamos en memoria Ram los 3 aleatorios
        for(int i=0;i<3;i++){
            System.out.println(numeros_aleatorios[i]);
            LRU algoritmo = new LRU(_lista,_proceso.getListaPaginasDisco().get(numeros_aleatorios[i]));
            _proceso.getListaPaginasDisco().remove(numeros_aleatorios[i]);
            
        }
        // el resto a memoria virtual
        _proceso.getListaPaginasDisco().forEach((_pa) -> {
            _lista.getListaPaginasVirtual().add(_pa);
        });
        _proceso.setEstado("Hola");
        
        
        
    }
    // si ya no tiene sus paginas, utilizar el metodo que 
    // trae las paginas que necesita segun su quantun
    
}
