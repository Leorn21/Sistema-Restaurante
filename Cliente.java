package restaurante;


public class Cliente extends Persona{
    String DNI;
    public Cliente(String nombre,String apellido,String DNI){
        super(nombre,apellido);
        this.DNI=DNI;
    }
}
