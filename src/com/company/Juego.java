package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Juego {

    public static void juego() {

        //juego PICAS Y FAMAS (2 JUGADORES) Version 3 (con numeros aleatorios)----------------------------------
        Scanner sc = new Scanner(System.in);
        int rondas = 1;
        int turno = 1;
        int numeroAleatorio;
        int cantidadNumeros;

        do {
            System.out.println("-----------------------------");
            System.out.println("Sólo se puede jugar con un número entre 3 y 7 cifras.");
            System.out.println("Escriba la cantidad de cifras de los numeros que se van a adivinar:");
            cantidadNumeros = sc.nextInt();
        }while (cantidadNumeros<3 || cantidadNumeros>7);

        String numero1 = "";
        String numero2 = "";

        //se busca un numero aleatorio válido para el jugador N.1
        Stack<Integer> listaNumeros1 = new Stack<>();

        for (int i = 0; i < cantidadNumeros; i++) {
            numeroAleatorio = (int) Math.floor(Math.random() * (0 - 10) + 10);
            while (listaNumeros1.contains(numeroAleatorio)) {
                numeroAleatorio = (int) Math.floor(Math.random() * (0 - 10) + 10);
            }
            listaNumeros1.push(numeroAleatorio);
        }
        for (int i = 0; i < cantidadNumeros; i++) {
            numero1 += listaNumeros1.get(i);
            //System.out.println(numero1);
        }

        //se busca un numero aleatorio válido para el jugador N.2
        Stack<Integer> listaNumeros2 = new Stack<>();
        for (int i = 0; i < cantidadNumeros; i++) {
            numeroAleatorio = (int) Math.floor(Math.random() * (0 - 10) + 10);
            while (listaNumeros2.contains(numeroAleatorio)) {
                numeroAleatorio = (int) Math.floor(Math.random() * (0 - 10) + 10);
            }
            listaNumeros2.push(numeroAleatorio);
        }

        for (int i = 0; i < cantidadNumeros; i++) {
            numero2 += listaNumeros2.get(i);
            //System.out.println(numero2);
        }

        String numeroUsuario1 = "";
        String numeroUsuario2 = "";
        int famas = 0;
        int picas = 0;
        String a;
        String b;
        int ultimoTurno = 0;

        String jugador1;
        String jugador2;

        jugador1 = (Menu.jugadores.size()>0)? "JUGADOR N."+Menu.jugadores.get(0).getId() + ": "+
                Menu.jugadores.get(0).getName():"JUGADOR N.1";
        jugador2 = (Menu.jugadores.size()==2)? "JUGADOR N."+Menu.jugadores.get(1).getId() + ": "+
                Menu.jugadores.get(1).getName():"JUGADOR N.2";

        boolean esEntero = false;

        do {
            System.out.println("Esta es la ronda #: " + rondas);
            if (turno == 1) {
                System.out.println(jugador1);
                System.out.println("Escriba un número de " + cantidadNumeros + " cifras");
                numeroUsuario2 = sc.next();
                if (isNumeric(numeroUsuario2)==false){
                    System.out.println("Debe digitar un número entero positivo de 4 cifras.");
                }else{
                    if (numeroUsuario2.length() != cantidadNumeros) {
                        System.out.println("El número no tiene " + cantidadNumeros + " cifras");
                    } else {
                        for (int i = 0; i < cantidadNumeros; i++) {
                            a = numeroUsuario2.substring(i, i + 1);
                            for (int j = 0; j < cantidadNumeros; j++) {
                                b = numero2.substring(j, j + 1);
                                if (a.equals(b)) {
                                    famas+= (i==j)? 1:0;
                                    picas+= (i!=j)? 1:0;
                                }
                            }
                        }
                        System.out.println("Famas: " + famas + "\nPicas: " + picas);
                        famas = 0;
                        picas = 0;
                        turno = 2;
                        System.out.println("-----------------------");
                    }
                }

            } else {
                if (numeroUsuario2.equals(numero2)) {
                    ultimoTurno = 1;
                    System.out.println("ULTIMA OPORTUNIDAD. El jugador N.1 ya adivinó el número.");
                }
                System.out.println(jugador2);
                System.out.println("Escriba un número de " + cantidadNumeros + " cifras");
                numeroUsuario1 = sc.next();
                if (isNumeric(numeroUsuario1) == false) {
                    System.out.println("Debe digitar un número entero positivo de 4 cifras.");
                } else {
                    if (numeroUsuario1.length() != cantidadNumeros) {
                        System.out.println("El número no tiene " + cantidadNumeros + " cifras");
                    } else {
                        for (int i = 0; i < cantidadNumeros; i++) {
                            a = numeroUsuario1.substring(i, i + 1);
                            for (int j = 0; j < cantidadNumeros; j++) {
                                b = numero1.substring(j, j + 1);
                                if (a.equals(b)) {
                                    famas+= (i==j)? 1:0;
                                    picas+= (i!=j)? 1:0;
                                }
                            }
                        }
                        System.out.println("Famas: " + famas + "\nPicas: " + picas);
                        famas = 0;
                        picas = 0;
                        rondas++;
                        turno = 1;
                        System.out.println("-----------------------");
                        ultimoTurno = (numeroUsuario1.equals(numero1))? 1:0;
                        /*if (numeroUsuario1.equals(numero1)) {
                            ultimoTurno = 1;
                        }

                         */
                    }
                }
            }

        } while ((!numeroUsuario1.equals(numero1) && !numeroUsuario2.equals(numero2)) || ultimoTurno == 0);
        if (numeroUsuario2.equals(numero2)) {
            System.out.println("Enhorabuena, "+jugador1 +" ha adivinado el número: " + numero2);
            System.out.println("Usted ha adivinado el número en: " + (rondas - 1) + " ronda(s).");
            System.out.println("El número de "+jugador2+" era: " + numero1);
            System.out.println("---------------------------------------------------------------");
        }
        if (numeroUsuario1.equals(numero1)) {
            System.out.println("Enhorabuena, "+jugador2 +" ha adivinado el número: " + numero1);
            System.out.println("Usted ha adivinado el número en: " + (rondas - 1) + " ronda(s).");
            System.out.println("El número de "+jugador1+" era: " + numero2);
            System.out.println("---------------------------------------------------------------");
        }

    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;
        int enteroPositivo;

        try {
            Integer.parseInt(cadena);
            enteroPositivo = Integer.parseInt(cadena);
            if (enteroPositivo<0){
                resultado = false;
            }else{
                resultado = true;
            }
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

}
