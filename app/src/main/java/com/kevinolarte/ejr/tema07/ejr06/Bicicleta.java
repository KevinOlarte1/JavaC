package com.kevinolarte.ejr.tema07.ejr06;

import java.util.Random;

import com.kevinolarte.lib.Conf;
import com.kevinolarte.lib.Randmos;

public class Bicicleta {
    private static int cont = 0;
    private final String referecncia;
    private final String marca;
    private final String modelo;
    private final double peso;
    private final double tamañoRuedas;
    private final boolean motor;
    private final String fechaFabrica;
    private final int existentcias; //Calculado, creo ??? 

    
    public Bicicleta(String marca, String modelo, double peso, double tamañoRuedas, boolean motor, String fechaFabrica){
        this.referecncia = String.valueOf(++cont);
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.tamañoRuedas = tamañoRuedas;
        this.motor = motor;
        this.fechaFabrica = fechaFabrica;
        this.existentcias = 1;

    }

    public Bicicleta obtenercopia(){
        return new Bicicleta(this.marca, this.modelo, this.peso, this.tamañoRuedas, this.motor, this.fechaFabrica);
    }
    
    //#region Getters
    public String getReferecncia() {
        return referecncia;
    }
    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public double getPeso() {
        return peso;
    }


    public double getTamañoRuedas() {
        return tamañoRuedas;
    }


    public boolean isMotor() {
        return motor;
    }


    public String getFechaFabrica() {
        return fechaFabrica;
    }


    public int getExistentcias() {
        return existentcias;
    }

    //#endregion

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((referecncia == null) ? 0 : referecncia.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bicicleta other = (Bicicleta) obj;
        if (referecncia == null) {
            if (other.referecncia != null)
                return false;
        } else if (!referecncia.equals(other.referecncia))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Bicicleta [referecncia=" + referecncia + ", marca=" + marca + ", modelo=" + modelo + ", peso=" + peso
                + ", tamañoRuedas=" + tamañoRuedas + ", motor=" + motor + ", fechaFabrica=" + fechaFabrica
                + ", existentcias=" + existentcias + "]";
    }


    

    
    

}
