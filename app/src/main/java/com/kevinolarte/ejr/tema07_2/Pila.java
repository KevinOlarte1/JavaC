package com.kevinolarte.ejr.tema07_2;

public class Pila {
    private int[] pila;
    private int lenght;

    public Pila(int capacidad) {
        pila = new int[capacidad];
        lenght = -1;
    }
    public void push(int elemento){
        if (isFull())
            ampliar();
           
        pila[++lenght] = elemento;
    }

    private void ampliar(){
        int newArray[] = new int[pila.length * 2];
        for (int i = 0; i < pila.length; i++) {
            newArray[i] = pila[i];
        } 
        pila = newArray;
    }
    private boolean isFull(){
        if(lenght == pila.length-1)
            return true;
        return false;
    }
    public boolean isEmpty(){
        return lenght == -1;
    }
    
}
