package org.example;

import java.util.IllegalFormatCodePointException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //declarando variable

        Scanner teclado= new Scanner(System.in);
        Random aleatorio =new Random();

        Boolean esAdministrador;
        String respuestaDelPerfil;
        Double tarifaEnergia;
        Integer opcion;
        final String contraseña="admin123*";
        String contraseñaUsuario;
        Integer contadorEnergia = 0;

        System.out.println("Bienvenido");
        System.out.print(" Eres admistrador:");
        respuestaDelPerfil=teclado.nextLine();

        //PROCESO PARA EL LOGIN
        if(respuestaDelPerfil.equalsIgnoreCase("si")){
            //admin y me van a pedir la contraseña
            System.out.print("Digita la Contraseña");
            contraseñaUsuario= teclado.nextLine();
            //comparamos la contraseña que escribieron con la constante almacenada
            if (contraseñaUsuario.equals(contraseña)){

                //felicitaciones usted es un administrador
                System.out.println("usted es un admin");

                //puedo actualizar la tarifa de energia
                System.out.print("ingrese el valor de kwh: ");
                tarifaEnergia= teclado.nextDouble();
                System.out.println("la tarifa de energia quedo en: $"+tarifaEnergia);
                Integer numeroVueltas=0; //contadorsi
                Integer contadorDePicos=0;

                //generando datos para una empresa
                //generar un ciclo que de 38 vueltas
                do {
                    numeroVueltas=numeroVueltas+1;
                    Integer numeroGenerado=aleatorio.nextInt(400)+1;
                    System.out.println("numeroGenerado");
                    contadorEnergia=contadorEnergia+numeroGenerado;
                    if (numeroGenerado>300){
                        contadorDePicos=contadorDePicos+1;
                    }


                }while (numeroVueltas<=30);
                System.out.println(numeroVueltas);
                System.out.println(contadorDePicos);

                //MENU
                System.out.println("1. ver tarifa");
                System.out.println("2. mostrar consumo promedio");
                System.out.println("3. mostrar consumo picos ");
                System.out.println("4. mostrar facttura ");
                System.out.println("5. salir");

                //REPITIENDO EL MENU
                do{
                    System.out.println("apreciado cliente, digita una opcion");
                    opcion=teclado.nextInt();

                    switch (opcion){
                        case 1:
                            System.out.println("la tarifa de kwh es: " +tarifaEnergia);
                            break;
                        case 2:
                            System.out.println("el consumo total fue: "+contadorEnergia);
                            Double promedioConsumo=contadorEnergia/30.0;
                            System.out.println("el consumo promedio es: "+promedioConsumo);
                            break;
                        case 3:
                            System.out.println("la cantidad de picos fue: "+contadorDePicos);
                        case 4:
                            System.out.println("el resumen de tu factura es ");
                            Double totalApagar=contadorEnergia+tarifaEnergia;
                            System.out.println("$...."+totalApagar);
                            break;
                        default:
                            System.out.println("opcion invalida ");
                            break;
                    }


                } while (opcion!=5);


            } else {
                System.out.println("usted es una metida");
            }

        }else{
            //EMPRESA
            System.out.println("usted es una empresa");
        }








    }
}
