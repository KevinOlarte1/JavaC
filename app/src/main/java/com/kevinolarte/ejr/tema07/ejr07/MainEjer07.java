package com.kevinolarte.ejr.tema07.ejr07;

import com.google.common.primitives.Booleans;
import com.kevinolarte.lib.Conf;
import com.kevinolarte.lib.Input;
import com.kevinolarte.lib.Menus;
import java.time.LocalDate;

public class MainEjer07 {

    CentroSalud centro = new CentroSalud(0);
    public MainEjer07(){
        
        int ingreso = 0;
        do{
            Menus.print(new String[]{"      URGENCIAS      ", "Nuevo paciente...","Atender Paciente...","Consultas...","Alta Medica..."});
            ingreso = Input.pedirIntPositivo("Ingrese un valor del menu");
            switch (ingreso) {
                case 1:
                    nuevoPaciente();
                    Input.scanner.nextLine();
                    break;
                case 2:
                    //atenderPaciente();
                    Input.scanner.nextLine();
                    break;
                case 3:
                    consultas();
                    Input.scanner.nextLine();
                    break;
                case 4:
                    //altaMedica();
                    Input.scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Conf.sleep(400);
                    break;
                default:
                    System.out.println("Numero fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(ingreso != 0);
    }

    /**
     * Metodo para añadir nuevo paciente
     */
    private void nuevoPaciente(){
        String sip = Input.pedirString("Ingresa el sip del paciente");
        String nombre = Input.pedirString("Ingresa el nombre del paciente");
        boolean sexo = Input.pedirBoolean("Hombre(Si) - Mujer(No)");
        int edad = Input.pedirInt("Ingresa la edad del paciente");
        String fecha = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy-MM-dd HH:mm:ss");
        String sintomas = Input.pedirString("Ingrese los sintomas del paciente");
        boolean conseguir = centro.nuevoPaciente(sip, nombre, sexo, edad, LocalDate.parse(fecha), sintomas);
        if (conseguir) 
            System.out.println("Nuevo paciente añadido");
        else
            System.out.println("Error");
    }

    private void consultas(){
        int ingreso = 0;
        do{
            Menus.print(new String[]{"      Consultas      ", "Por sip...", "por fecha...", "Estadisticas", "Mostrar historico mensual"});
            ingreso = Input.pedirIntPositivo("Ingrese un numero del menu");
            switch (ingreso) {
                case 1:
                    porSip();
                    Input.scanner.nextLine();
                    break;
                case 2:
                    porFecha();
                    Input.scanner.nextLine();
                    break;
                case 3:
                    estadisticas();
                    Input.scanner.nextLine();
                    break;
                case 4:
                    mostrarHistorico();
                    Input.scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    Conf.sleep(400);
                    break;
                default:
                    System.out.println("Numero fuera de rango");
                    Conf.sleep(400);
                    break;
            }
        }while(ingreso != 0);
    }
    
    private void estadisticas(){
        System.out.println(centro.estadisticas());
    }
    private void porFecha(){
        String fechaInico = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy-MM-dd HH:mm:ss");
        boolean fin = Input.pedirBoolean("Queres ingresar fecha fin si o no");
        String fechaFin;
        Consultas c[];
        if (fin) 
        {
            fechaFin = Input.pedirFecha("Ingresa la fecha de entreada del siguente formato yyyy-MM-dd HH:mm:ss");
             c= centro.otenerPacientesFecha(LocalDate.parse(fechaInico), LocalDate.parse(fechaFin));
        }
        else{
            c = centro.otenerPacientesFecha(LocalDate.parse(fechaInico));
        }
        for (Consultas consultas : c) {
            System.out.println(consultas.toString());
        }
        

        
    }

    /*
     * Metodo para mostrar los Pacientes por sip.
     */
    private void porSip(){
        String sip = Input.pedirString("Ingrese el sip del paciente");
        Consultas c[] = centro.obtenerPacientesSip(sip);
        for (Consultas consultas : c) {
            System.out.println(consultas.toString());
        }
    }

    /**Metodo para ver todo el historico del celtro */
    private void mostrarHistorico(){
        System.out.println(centro.mostarHistorico());
    }
}