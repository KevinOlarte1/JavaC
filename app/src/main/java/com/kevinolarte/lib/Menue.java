package com.kevinolarte.lib;

import java.util.Scanner;

public class Menue {
    private static Scanner scanner = new Scanner(System.in);
    private static final int CAPACIDAD_INICIAL = 5;
    private final String texto;
    private Menue[] opciones;
    private int numOpciones;

    public Menue(String texto) {
        this.texto = texto;
        this.opciones = null;
        numOpciones = 0;
    }

    private void ampliarCapacidad(){
        Menue[] copia = new Menue[opciones.length * 2];
        for (int i = 0; i <opciones.length ; i++) {
            copia[i] = opciones[i];
        }
        opciones = copia;
    }

    public Menue addOpcion(String texto){
        if (opciones == null){
            opciones = new Menue[CAPACIDAD_INICIAL];
        }
        if (numOpciones == opciones.length){ //El array esta bien

        }
        Menue resultado = new Menue(texto);
        opciones[numOpciones] = resultado;
        numOpciones++;
        return resultado;
    }
    public int mostrarMenu(){
        boolean valido;
        int opcion;
        do {
            System.out.println(this);
            opcion = Integer.parseInt(scanner.nextLine());
            valido = opcion >=1 && opcion <= numOpciones;

        }while (!valido);
        return opcion;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***").append(texto).append("***");
        for (int i = 0; i <numOpciones; i++) {
            sb.append(i+1).append(opciones[i].texto).append("\n");
        }
        sb.append("----------------------------");
        sb.append("Elige una opcion: ");
        return sb.toString();
    }
    public String toStringLetras(){
        String letras = "abcdefghijklmnñopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        sb.append("***").append(texto).append("***");
        for (int i = 0; i <numOpciones; i++) {
            sb.append(letras.charAt(i)).append(opciones[i].texto).append("\n");
        }
        sb.append("----------------------------");
        sb.append("Elige una opcion: ");
        return sb.toString();
    }
    
}
