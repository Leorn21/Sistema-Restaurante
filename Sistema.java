package restaurante;

import java.util.*;
public class Sistema {
 
    List mozos=new ArrayList();
    List platos=new ArrayList();
    List pedidos=new ArrayList();
    Set clientes=new HashSet();
    
    public Sistema(){ //Constructor
        mozos=new ArrayList();
        platos=new ArrayList();
        pedidos=new ArrayList();
        clientes= new HashSet();
    }
    public void menu(){  //Menu de opciones que se le da al usuario hasta que decida dejar de utilizar el sistema
        cargarPlatos();
        cargarMozos();  //Llamamos a las funciones que "hard-codean" los platos del menú y los nombres de los mozos en las listas
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
                    listarPlatos(); //Funcion que imprime la lista de los platos disponibles en el menu
                    cargarPedido(); //Funcion que se encarga de solicitar los datos del cliente y del pedido, y asignar el mozo correspondiente a la mesa
                    break;
                case 2:
                    listarPedidos(); //Funcion que imprime la lista de los pedidos que han sido realizados al restaurante
                    break;
                case 3:
                    listarPlatos();
                    System.out.println("\nPresione Enter para continuar");
                    sc.nextLine();
                    break;
                case 4:
                    mostrarMozos(); //Funcion que imprime los mozos dispoibles y de que mesas son responsables
                    break;
                case 5:
                    System.out.println("Adios!");
                    break; //Fin del programa
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
        //Carga de los datos del cliente y del pedido
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
        //Asignacion de mozo de acuerdo a la mesa seleccionada por el cliente
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
        clientes.add(new Cliente(nombre,apellido,DNI)); //Se agrega el cliente al HashSet para tener un registro de los clientes
        pedidos.add(platos.get(plato-1)+"\nMesa nro:"+numeroMesa+"\nMozo que atiende: "+mozoAsignado //Se agrega el pedido a la lista
        +"\nCliente:\nNombre:"+nombre+"\nApellido:"+apellido);
        System.out.println("El pedido se cargó con exito. Presione enter para continuar.");
        sc.nextLine();
    }
    
    public void listarPedidos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n\nSus pedidos hasta el momento son:");
        for(Object elemento:pedidos){ //ForEach que recorre la lista de pedidos
            System.out.println(elemento+"\n");
        }
        System.out.println("\nPresione Enter para continuar.");
        sc.nextLine();
    }
    
    public void mostrarMozos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nLos mozos disponibles son: ");
        for(Object elemento:mozos){ //ForEach que recorre la lista de mozos
            System.out.println(elemento);
        }
        System.out.println("\nPresione Enter para continuar.");
        sc.nextLine();
    }
    
    public void listarPlatos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\nLos platos disponibles son: ");
        int i=1;
        for(Object elemento:platos){ //ForEach que recorre la lista de platos del menu
            System.out.println(i+"-"+elemento);
            i++;
        }
    }
    
    public void cargarMozos(){ //Hard-codeo de los mozos y las mesas que atienden
        mozos.add("Mesas 1 a 5: Juan Carlos Romero");
        mozos.add("Mesas 6 a 10: Roberto Gutierrez");
        mozos.add("Mesas 11 a 15: Analia Gonzalez");
        mozos.add("Mesas 16 a 20: Walter Diaz");
    }
    
    public void cargarPlatos(){ //Hard-codeo de los platos disponibles en el menu y sus precios para la visualizacion del cliente
        platos.add("Bife a la Criolla - Precio:$7100");
        platos.add("Milanesa a la Napolitana - Precio:$6200");
        platos.add("Pizza Especial de Jamón y Queso - Precio:$7800");
        platos.add("Spaguettis a la Carbonara - Precio:$6000");
        platos.add("Ravioles a los 4 Quesos - Precio:$6500");
        platos.add("Pollo al Champignon - Precio:$6800");
        platos.add("Salmón a la Pimienta Negra - Precio:$7500");
    }
}
