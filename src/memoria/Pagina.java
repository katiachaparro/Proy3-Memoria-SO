/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.List;

/**
 *
 * @author Escurra
 */
public class Pagina {
    Proceso _padre;
    int _identificador;
    List <String> _instrucciones;
    boolean _procesado = false;
    
    public Pagina(Proceso padre,int identificador){
        _identificador = identificador;
        _padre = padre;
    }
    public void add_instruccion(String instruccion){
        _instrucciones.add(instruccion);
    }
    public void procesado(){
        _procesado = true;
    }
    
}
