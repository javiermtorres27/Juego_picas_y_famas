package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static ArrayList<Jugador> jugadores = new ArrayList<>();

    public static void mostrarMenu() {
        System.out.println("---------------------");
        System.out.println("Bienvenido al famoso juego Picas y Famas.\nSelecciona una opción:");

        int respuesta = 3;

        do {
            System.out.println("1. Ingresar/Eliminar Jugadores.");
            System.out.println("2. Jugar una partida Rápida.");
            System.out.println("3. Salir del juego.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta) {
                case 1:
                    showMenuJugadores();
                    break;
                case 2:
                    //acá iría el juego
                    break;
                case 3:
                    System.out.println("Hasta la próxima.");
                    break;
                default:
                    System.out.println("---------------------");
                    System.out.println("Por favor, selecciona una opción.");
            }
        } while (respuesta != 3);
    }



    public static void showMenuJugadores() {

        int respuesta = 3;


        do {
            System.out.println("---------------------");
            System.out.println("1. Registrar jugador.");
            System.out.println("2. Eliminar jugador.");
            System.out.println("3. Regresar al menú anterior.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta) {
                case 1:
                    //ingresar jugadores

                    for (int i = 0; i < 3-jugadores.size(); i++) {
                        System.out.println("---------------------");
                        System.out.println("Falta(n) "+(2-jugadores.size())+" jugador(es) por registrar.");

                        System.out.println("Escriba el nombre del jugador número "+(jugadores.size()+1)+":");
                        sc = new Scanner(System.in);
                        String nombre = sc.nextLine();
                        System.out.println("Escriba la edad de: " + nombre);
                        int edad = Integer.valueOf(sc.nextInt());
                        jugadores.add(new Jugador(jugadores.size()+1,nombre, edad));

                    }
                    //System.out.println(MenuVarios.jugadores.get(0).getId());
                    //System.out.println(MenuVarios.jugadores.get(1).getId());
                    System.out.println("Hay "+jugadores.size()+" jugadores registrados.");

                    break;
                case 2:
                    showListaJugadores();
                    break;
                case 3:
                    mostrarMenu();
                    break;
                default:
                    System.out.println("Por favor, selecciona una opción.");
            }
        } while (respuesta != 3);


    }

    public static void showListaJugadores(){

        //System.out.println(jugadores.size());

        int respuesta =3;

        do{
            System.out.println("---------------------");
            System.out.println("Escribe el número del jugador a eliminar o cancela:");

            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println((i + 1) + ". " + jugadores.get(i).getName()+".");
            };
            System.out.println("3. Cancelar.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    //System.out.println("Está seguro que desea eliminar a: "+Jugador.jugadores.get(0).name+" ??");
                    if(jugadores.size()>0){
                        jugadores.remove(0);
                        break;
                    }else{
                        System.out.println("No existe jugador número 1");
                        break;
                    }
                case 2:
                    if(jugadores.size()==2){
                        jugadores.remove(1);
                        break;
                    }else {
                        System.out.println("No existe jugador número 2");
                        break;
                    }
                case 3:
                    showMenuJugadores();
                    break;
                default:
                    System.out.println("Por favor selecciona una opción.");

            }

        }while (respuesta !=3);


    }


}
