package com.kevinolarte.ejr.tema07.ejr06;



import com.kevinolarte.lib.Conf;
import com.kevinolarte.lib.Input;
import com.kevinolarte.lib.Menus;

public class MainEjer06 {
    private static final int LIMIT_VAMOR_DEFAULT = 10;
    private final Bicicleta bicis[];
    private int posActual = 0;
    public MainEjer06(){
        this.bicis = new Bicicleta[LIMIT_VAMOR_DEFAULT];
        boolean salir = false;
        do{
            Menus.print(new String[]{" GESTIÓN DE BICICLETAS ", "Añadir bicicletas...","Veder bicicletas","Consultar bicicleta...", "Mostrar stock"});
            int valor = Input.pedirInt("Seleccione una opcioón");
            switch (valor) {
                case 1:
                    comprarBici();
                    break;
                case 2:
                    venderBici();
                    System.out.println("Continar...");
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consultaBici();
                    break;
                case 4:
                    mostarStock();
                    System.out.println("Continar...");
                    Input.scanner.nextLine();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(!salir);
    }

    /**Metodo para mostrar subMenu de consutla */
    private void consultaBici(){
        boolean salir = false;

        do{
            Menus.print(new String[]{"CONSULTA BICIS", "Consulta por referencia...", "Consulta por marca...", "Conuslta por modelo..."});
            int valor = Input.pedirInt("Seleccione una opcioón");
            switch (valor) {
                case 1:
                    consRef();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 2:
                    consMarc();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consMod();
                    System.out.println("Continuar....");
                    Input.scanner.nextLine();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Fuera de rango");
                    Conf.sleep(400);
                    break;
            }

        }while(!salir);
    }

    /**Buscar una bici por Referencia */
    private void consRef(){
        String referencia = String.valueOf(Input.pedirIntPositivo("INgresa la referencia"));
        boolean encontrado = false;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getReferecncia().equals(referencia)) {
                System.out.println(bicis[i].toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("Fuera de Stock");
        }
    }
    /**Buscar una bici por Marca */
    private void consMarc(){
        String marca = Input.pedirStringTexto("Ingresa la marca de la bici");
        boolean encontrado = false;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getMarca().equals(marca)) {
                System.out.println(bicis[i].toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("Fuera de Stock");
        }
    }
    /**Buscar una bici por Modelo */
    private void consMod(){
        String modelo = Input.pedirStringTexto("Ingresa el modelo de la bici");
        boolean encontrado = false;
        for (int i = 0; i < posActual; i++) {
            if (bicis[i].getModelo().equals(modelo)) {
                System.out.println(bicis[i].toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println("Fuera de Stock");
        }
    }

    /*** Metodo para comprarBicis */
    private void comprarBici(){
        String marca =Input.pedirStringTexto("Ingrese el numero de la marca");
        String modelo = Input.pedirStringTexto("Pedir modelo de la marca");
        double peso = Input.pedirDoublePositivo("Ingresa el peso de la bici"); 
        double tamañoRuedas = Input.pedirDoublePositivo("Ingresa el tamaño de la rueda"); 
        boolean motor = Input.pedirBoolean("La bici tine motor?"); 
        String fehca = Input.pedirFecha("Ingrese la fecha de la fabricacion");
        bicis[posActual] = new Bicicleta(marca, modelo, peso, tamañoRuedas, motor, fehca);
        posActual++;
    }

    /** Metodo para vender las bicis */
    private void venderBici(){
        if (posActual == 0) {
            System.out.println("No hay Stock");
        }
        else{
            String referencai = String.valueOf(Input.pedirIntPositivo("Ingrese el numero de referencia"));
            for (int i = 0; i < posActual; i++) {
                if (bicis[i].getReferecncia().equals(referencai)) {
                    bicis[i] = null;
                    if (posActual > 1) {
                        bicis[i] = bicis[posActual];
                        bicis[posActual] = null;
                    }
                    posActual --;
                }
            }
        }
        
        
    }


    /** Metodo para mostar el stock de las bicis. */
    private void mostarStock(){
        if (posActual == 0) {
            System.out.println("No hay Stock");
        }
        else{
            for (int i = 0; i < posActual; i++) {
                System.out.println(bicis[i].toString());
            }
        }
    }
    
}
