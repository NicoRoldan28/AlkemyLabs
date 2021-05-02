package com.example.AlkemyLabs.model;

public enum TypePersona {
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private String descripcion;

    TypePersona(String descripcion){
        this.descripcion=descripcion;
    }

    public static TypePersona find(String descripcion){
        for (TypePersona v: values()){
            if(values().toString().equalsIgnoreCase(descripcion)){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypeJugador: %s", descripcion));
    }
    public String getDescripcion(){
        return this.descripcion;
    }

}
