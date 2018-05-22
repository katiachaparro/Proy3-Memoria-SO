/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Escurra & Katia
 */
public class Pagina {
    Proceso _padre;
    int _identificador;
    List <String> _instrucciones;
    boolean _procesado = false;
    
    public Pagina(Proceso padre,int identificador){
        _identificador = identificador;
        _padre = padre;
        _instrucciones = new ArrayList<>();
    }
    public void add_instruccion(String instruccion){
        _instrucciones.add(instruccion);
    }
    public List<String> getListadeInstrucciones(){
        return _instrucciones;
    }
    public String getInstruccion(int posicion){
        return _instrucciones.get(posicion);
    } 
    public void procesado(){
        _procesado = true;
    }
    
}
