package memoria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ListaProcesos {
    private final ArrayList<Proceso> list;
    private int rafaga =0;
    private int quantun = 1;
    private ArrayList<Pagina> lista_paginas_virtual = new ArrayList<Pagina>();
    private Pagina[] lista_paginas_ram;
    private Pagina pagina_ejecutada;
   // private Principal principal = null;
    public ListaProcesos(){
        list = new ArrayList<>();
    }
    public void setPagina(Pagina pag){
        pagina_ejecutada = pag;
    }
    public Pagina getPagina(){
        return pagina_ejecutada;
    }
    /*public void setPrincipal(Principal princi){
        principal = princi;
    }  
    public Principal getPrincipal(){
        return principal;
    } */ 
    public void setRafaga(int _rafaga){
        rafaga = _rafaga;
    }
    public int getRafaga(){
        return rafaga;
    }
    public List<Proceso> getListadeProcesos(){
        return list;
    }

    public void agregarProceso(Proceso p){
        list.add(p);
    }	   	
    public int tamano(){
        return list.size();
    }
    public int getQuantun(){
        return quantun;
    }
    public void setQuantun(int _quantun){
        quantun  = _quantun;
    }
    public void eliminar(Proceso p){
	list.remove(p);
    }
    public Proceso getProceso(int i){
	return list.get(i);
    }
    public void setProceso(int pos, Proceso proceso){
        list.set(pos, proceso);
    }
    public void imprimir(){
        for (Proceso list1 : list) {
            System.out.print("Nombre = " + list1.getNombreProceso() + "\n");
            System.out.print("Llegada = " + list1.getTiempoLlegada()+ "\n");
            System.out.print("Rafaga = " + list1.getTiempoRafaga()+ "\n");
            System.out.print("Prioridad = " + list1.getPrioridad()+ "\n");
            System.out.print("\n");
        }
    }
    private BufferedReader abrirArchivo(String file){
      
        BufferedReader br = null;
        try {
         URL url = getClass().getResource(file);
         if (url == null) url = new URL(file);
         URLConnection site    = url.openConnection();
         InputStream is        = site.getInputStream();
         InputStreamReader isr = new InputStreamReader(is);
          br = new BufferedReader(isr);
         return br;
      } catch(IOException e) {
          System.out.println(e.getMessage()); 

      }
        return br;
    }
    
    private String leerArchivo(String file){
        String builder = "";
        String leer = "";
        BufferedReader br = abrirArchivo(file);
        if(br !=null) {
             try {
                 while ((builder = br.readLine()) != null) {
                      leer += builder;
                 }} catch (IOException ex) {
                 Logger.getLogger(ListaProcesos.class.getName()).log(Level.SEVERE, null, ex);
             }
        }  
        return leer;   
    }
    public String [] getProcesos(String file){
        String procesos [] = leerArchivo(file).split("-");
         return procesos;
    }
    //creo los proceso con sus respectivas paginas
    public void cargarList(String file) {
        //obtengos todos los procesos
         String lee [] = getProcesos(file);
         //los recorro
         for(int i= 1;i<lee.length;i++){
             //creo un proceso
            Proceso proceso = new Proceso();
            //Obtengo su nombre
            String elem [] = lee[i].split("\\{");
            proceso.setNombreProceso(elem[0]);
            //Obtengo sus atributos
            int inicio = lee[i].indexOf("{")+1;
            int fin = lee[i].indexOf("}");
            String attrProceso = lee[i].substring(inicio, fin);
            String attrArray [] = attrProceso.split(";");
            //Obetngo el tiempo de llegada
            String tiempoLlArray [] = attrArray[0].split(":"); 
            proceso.setTiempoLlegada(Integer.parseInt(tiempoLlArray[1].trim()));
            //Obetengo el tiempo de rafaga
            String tiempoRArray [] = attrArray[1].split(":"); 
            proceso.setTiempoRafaga(Integer.parseInt(tiempoRArray[1].trim()));
            //Obtengo las paginas
            int inicioP= attrArray[2].indexOf("[") +1;
            int finP = attrArray[2].indexOf("]");
            String paginasArray = attrArray[2].substring(inicioP, finP);
            //Obterngo los atributos de todas las paginas paginas
            String attrPaginaArray [] = paginasArray.split(",");
            for(int x=0; x<attrPaginaArray.length;x++){
                //obtengo el identificador de la pagina
                String identificadorArray[] = attrPaginaArray[x].split(":");
                //creo una paginas
                Pagina pag = new Pagina(proceso,Integer.parseInt(identificadorArray[0].trim()));
                //obtengo las instruccioines
                String inst []= identificadorArray[1].split("/n");
                for(int a=0;a<inst.length;a++){
                    pag.add_instruccion(inst[a]);
                }
                //guardo la pagina en el proceso
                proceso.agregarPagina(pag);
                
            }
            //guardo el proceso en la pagina
            list.add(proceso);
         }
    }
    public ListaProcesos ordenarPorTiempoLlegada(ListaProcesos lista,int orden){
        for(int a=orden ;a<lista.tamano();a++){
            for(int i = orden;i<lista.tamano(); i++){
                    Proceso aux  = null;//variable auxiliar
                    int incrementar = i + 1;//la siguiente posicion
                    if ((incrementar < lista.tamano() &&
                            (lista.getProceso(i).getTiempoLlegada()> lista.getProceso(incrementar).getTiempoLlegada()))){
                        
                        
                        aux = lista.getProceso(incrementar);
                        lista.setProceso(incrementar, lista.getProceso(i));
                        lista.setProceso(i,aux);
                    }else{incrementar --;}
                }
     }
        return lista;
    }
        // utilizamos Lista de procesos para mantener las diferentes memorias (ram y virtual)
    // Array de paginas en Memoria Ram
    public void setArrayPaginasRam(Pagina[] lista){
        lista_paginas_ram = lista;
    }
    public Pagina[] getArrayPaginasRam(){
        return lista_paginas_ram;
    }
    
    
    // list de paginas en memoria virtual
    public void setListaPaginasVirtual(ArrayList<Pagina> lista_paginas){
        lista_paginas_virtual = lista_paginas;
    }
    public ArrayList<Pagina> getListaPaginasVirtual(){
        return lista_paginas_virtual;
    }
}