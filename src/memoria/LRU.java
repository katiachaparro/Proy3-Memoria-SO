
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
    Ventana _ventana;
    int _tiempo;
    public LRU(ListaProcesos lista, Pagina nueva,Ventana ventana ,int tiempo){
        
        _listas = lista;
        _memoriaRam = lista.getArrayPaginasRam();
        _nueva = nueva;
        _memoriaVirtual = lista.getListaPaginasVirtual();
        _ventana = ventana;
        _tiempo= tiempo;
        algoritmo();
    }
    public void algoritmo(){
        if(hayMarco()){
          for(int a = 0;a<_memoriaRam.length;a++){
            if(_memoriaRam[a] == null){
                _memoriaRam[a] = _nueva;
                break;
            }
          }
          _listas.setArrayPaginasRam(_memoriaRam);
        }else{
            // aplica LRU
            _listas.getListaPaginasVirtual().add(_memoriaRam[0]);
            Pagina aux;
            for(int i = 0;i<_memoriaRam.length; i++){
                if(i+1 <_memoriaRam.length){
                _memoriaRam[i] = _memoriaRam[i+1];
                }
                
            }
            _memoriaRam[_memoriaRam.length - 1] = _nueva;
            _listas.setArrayPaginasRam(_memoriaRam);
        }
        _ventana.setRam(_listas.getArrayPaginasRam());
        _ventana.setVirtual(_listas.getListaPaginasVirtual());
         try {
                Thread.sleep(_tiempo);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }  
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
