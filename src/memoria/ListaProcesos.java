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
    private int quantun = 4;
   // private Principal principal = null;
    public ListaProcesos(){
        list = new ArrayList<>();
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
    private BufferedReader leerArchivo(String file){
      
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
    public void cargarList(String file) {
         String lee;
         BufferedReader br = leerArchivo(file);
        if(br !=null) {
             try {
                 while ((lee = br.readLine()) != null) {
                     String[] linea = lee.split(",");
                     Proceso p = new Proceso();
                     p.setNombreProceso(linea[0]);
                     p.setTiempoLlegada(Integer.parseInt(linea[1]));
                     p.setTiempoRafaga(Integer.parseInt(linea[2]));
                     p.setPrioridad(Integer.parseInt(linea[3]));
                     list.add(p);
                 }} catch (IOException ex) {
                 Logger.getLogger(ListaProcesos.class.getName()).log(Level.SEVERE, null, ex);
             }
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
}
