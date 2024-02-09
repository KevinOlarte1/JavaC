package com.kevinolarte.lib;

import java.util.Scanner;

public class Menue {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int CAPACIDAD_INI = 5;
    private String texto;
    private Menue[] opciones;
    private int numOpcion;

    public Menue(String texto){
        this.texto = texto;
        this.opciones = null;
        this.numOpcion = 0;
    }

    public Menue addOpciones(String texto){
        if (opciones == null) {
            opciones = new Menue[CAPACIDAD_INI];
        }
        opciones[numOpcion] = new Menue(texto);
        if (numOpcion == opciones.length) { // Array esta lleno!!!
            ampliarCapacidad();
        }
        Menue resultao = new Menue(texto);
        opciones[numOpcion++] = resultao;
        return resultao;
    }

    public int mostarMenu(){
        boolean valido;
        int ingreso;
        do{
            System.out.println(this);
            ingreso = Integer.parseInt(scanner.nextLine());
            valido = ingreso <= 1 || ingreso >numOpcion;
        }while(!valido);
        return ingreso;
    }


    public String toString(){
        StringBuilder stb = new StringBuilder();
        stb.append("***").append(texto).append("***");
        for (int i = 0; i < numOpcion; i++) {
            stb.append(i+1).append(opciones[i].texto).append("...\n");
        }
        stb.append("-------------------------------\n");
        stb.append("0. Para salir\n");
        stb.append("Eligue una opcion:");

        return stb.toString();
        
    }

    // I M P O R T A N T E  (OPTIMIZAR PARA SNAKE)
    private void ampliarCapacidad(){ //Metodo para ampliar copia
        Menue copia[] = new Menue[opciones.length * 2];
        for (int i = 0; i < opciones.length; i++) {
            copia[i] = opciones[i];
        }
        opciones = copia;
    }
}
