package com.example.AlkemyLabs.model;

public enum TypeRole {

    ADMINISTRADOR("ADMINISTRADOR"),
    USUARIO("USUARIO");

    private String descripcion;

    TypeRole(String descripcion){
        this.descripcion=descripcion;
    }

    public static TypeRole find(String descripcion){
        for (TypeRole v: values()){
            if(values().toString().equalsIgnoreCase(descripcion)){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypeRol: %s", descripcion));
    }

    public String getDescripcion(){
        return this.descripcion;
    }


}
