package com.company;

import java.util.Scanner;

public class Menu {

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
                    break;
                case 2:
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

}
