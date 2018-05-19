package memoria;
/**
 *
 * @author katia Chaparro
 */
import java.awt.Color;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Proceso {
    private  String nombreProceso;
    private  Color color ;
    private  int tiempoLlegada;
    private  int tiempoRafaga;
    private  int prioridad;
    private  int tiempoCiclo;
    private  String estado;
    private int tejecutado;
    private int tiempoNoEjecutado;
    
    public Proceso(){
        nombreProceso = "";
        color = Color.darkGray;
        tiempoLlegada = 0;
        tiempoRafaga = 0;
        prioridad = 0;
        estado="";
        tiempoCiclo = 0;
        tejecutado=0;
        tiempoNoEjecutado=0;
        

}
    public int getTiempoCiclo(){
        return tiempoCiclo;
    }
    public void setTiempoCiclo(int num){
        tiempoCiclo = num;
    }
    public int getTiempoLlegada(){
        return tiempoLlegada;
    }

    public int getTiempoRafaga(){
        return tiempoRafaga;
    }
    public int getPrioridad(){
        return prioridad;
    }

    public String getNombreProceso(){
        return nombreProceso;
    }

    public Color getColor() {
        return (color); 
    }
    public void setTiempoLlegada(int tiempo){
      tiempoLlegada=tiempo;  
    }

    public void setTiempoRafaga(int tiempo){
        tiempoRafaga = tiempo;
        tiempoNoEjecutado = tiempoRafaga;
    }
    public void setPrioridad(int p){
        prioridad= p;
    }

    public void setNombreProceso(String nombre){
        nombreProceso = nombre;
    }

    public void setColor(Color c) {
        color = c; 
    }
    public String getEstado (){
        return estado;
    }
    public void setEstado(String _estado){
        estado = _estado;
        int time = 0;
        for(int i = 0; i<time; i++){
            try {
                setTiempoCiclo( i + 1);//es solo para no empezar a contar de 0
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void setTEjecutado(int ejecutado){
        tejecutado = ejecutado;
        tiempoNoEjecutado = tiempoNoEjecutado - 1;
    }
    public int getTEjecutado(){
        return tejecutado;
    }
    public int getTiempoNoEjecutado(){
        return tiempoNoEjecutado;
    }
    //public void setTNoEjecutado(int noEjecutado){
    //   tNoEjecutado = noEjecutado;
    //}
}