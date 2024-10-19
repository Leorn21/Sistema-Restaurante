package restaurante;

import java.util.*;
public class Sistema {
 
    List mozos=new ArrayList();
    List platos=new ArrayList();
    List pedidos=new ArrayList();
    Set clientes=new HashSet();
    
    public Sistema(){
        mozos=new ArrayList();
        platos=new ArrayList();
        pedidos=new ArrayList();
        clientes= new HashSet();
    }
    public void menu(){
        cargarPlatos();
        cargarMozos();
        Scanner sc=new Scanner(System.in);
        int op;
        System.out.println("BIENVENIDO A NUESTRO SISTEMA DE RESTAURANTE:\n");
        do{
            System.out.println("""
                               Que quiere hacer
                               1-Cargar pedido mesa
                               2-Listar todos los pedidos
                               3-Listar todos los platos del menu
                               4-Listar todos los mozos que atienden las mesas
                               5-Terminar de usar el sistema de restaurante""");
            op=Integer.parseInt(sc.nextLine());
            switch(op){
                case 1:
                    listarPlatos();
                    cargarPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    listarPlatos();
                    System.out.println("\nPresione Enter para continuar");
                    sc.nextLine();
                    break;
                case 4:
                    mostrarMozos();
                    break;
                case 5:
                    System.out.println("Adios!");
                    break;
            }
        }while(op!=5);
    }
    
    public void cargarPedido(){
        Scanner sc=new Scanner(System.in);
        int plato;
        String nombre;
        String apellido;
        String DNI;
        String mozoAsignado="";
        int numeroMesa;
        
        System.out.println("\nSeleccione su numero de plato deseado:");
        plato=Integer.parseInt(sc.nextLine());
        System.out.println("\nIngrese el numero de mesa deseado:");
        numeroMesa=Integer.parseInt(sc.nextLine());
        System.out.println("\nIngrese el nombre del cliente:");
        nombre=sc.nextLine();
        System.out.println("\nIngrese el apellido del cliente:");
        apellido=sc.nextLine();
        System.out.println("\nIngrese el DNI del cliente:");
        DNI=sc.nextLine();
        if (numeroMesa>=1 && numeroMesa<=5){
            mozoAsignado="Juan Carlos Romero";
        }else if(numeroMesa>=6 && numeroMesa<=10){
            mozoAsignado="Roberto Gutierrez";
        }else if(numeroMesa>=11 && numeroMesa<=15){
            mozoAsignado="Analia Gonzalez";
        }else if(numeroMesa>=16 && numeroMesa<=20){
            mozoAsignado="Walter Diaz";
        }else{
            System.out.println("Numero invalido");
        }
        clientes.add(new Cliente(nombre,apellido,DNI));
        pedidos.add(platos.get(plato-1)+"\nMesa nro:"+numeroMesa+"\nMozo que atiende: "+mozoAsignado
        +"\nCliente:\nNombre:"+nombre+"\nApellido:"+apellido);
        System.out.println("El pedido se cargó con exito. Presione enter para continuar.");
        sc.nextLine();
    }
    
    public void listarPedidos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\nSus pedidos hasta el momento son:");
        for(Object elemento:pedidos){
            System.out.println(elemento+"\n");
        }
        System.out.println("\nPresione Enter para continuar.");
        sc.nextLine();
    }
    
    public void mostrarMozos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nLos mozos disponibles son: ");
        for(Object elemento:mozos){
            System.out.println(elemento);
        }
        System.out.println("\nPresione Enter para continuar.");
        sc.nextLine();
    }
    
    public void listarPlatos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nLos platos disponibles son: ");
        int i=1;
        for(Object elemento:platos){
            System.out.println(i+"-"+elemento);
            i++;
        }
    }
    
    public void cargarMozos(){
        mozos.add("Mesas 1 a 5: Juan Carlos Romero");
        mozos.add("Mesas 6 a 10: Roberto Gutierrez");
        mozos.add("Mesas 11 a 15: Analia Gonzalez");
        mozos.add("Mesas 16 a 20: Walter Diaz");
    }
    
    public void cargarPlatos(){
        platos.add("Bife a la Criolla - Precio:$7100");
        platos.add("Milanesa a la Napolitana - Precio:$6200");
        platos.add("Pizza Especial de Jamón y Queso - Precio:$7800");
        platos.add("Spaguettis a la Carbonara - Precio:$6000");
        platos.add("Ravioles a los 4 Quesos - Precio:$6500");
        platos.add("Pollo al Champignon - Precio:$6800");
        platos.add("Salmón a la Pimienta Negra - Precio:$7500");
    }
}
