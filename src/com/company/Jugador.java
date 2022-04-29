package com.company;

public class Jugador {

    private int id;
    private String name;
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    Jugador(int id, String name, int edad){
        //id++;
        this.id = id;
        this.name = name;
        this.edad = edad;
        System.out.println("El nombre del jugador creado es: "+name);
    }

    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("ID jugador: "+id);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name = name.toUpperCase();
    }


}
