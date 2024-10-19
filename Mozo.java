package restaurante;


public class Mozo extends Persona{
    String mesaAsignada;
    public Mozo(String nombre,String apellido,String mesaAsignada){
        super(nombre,apellido);
        this.mesaAsignada = mesaAsignada;
    }
}
