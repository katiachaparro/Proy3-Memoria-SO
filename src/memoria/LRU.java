package memoria;

import java.util.List;

/**
 *
 * @author Escurra
 */
public class LRU {
    Pagina []_memoriaRam;
    Pagina _nueva;
    List <Pagina> _memoriaVirtual;
    ListaProcesos _listas;
    public LRU(ListaProcesos lista, Pagina nueva ){
        
        _listas = lista;
        _memoriaRam = lista.getArrayPaginasRam();
        _nueva = nueva;
        _memoriaVirtual = lista.getListaPaginasVirtual();
        algoritmo();
    }
    public void algoritmo(){
        if(hayMarco()){
          for(int a = 0;a<_memoriaRam.length;a++){
            if(_memoriaRam[a] == null){
                _memoriaRam[a] = _nueva;
            }
        }
        }
        _listas.setArrayPaginasRam(_memoriaRam);
    }
    public boolean hayMarco(){
        boolean hay_espacio = false;
        for (Pagina _memoriaRam1 : _memoriaRam) {
            if (_memoriaRam1 == null) {
                hay_espacio = true;
            }
        }
       return hay_espacio;
    }
    
    
    
}
