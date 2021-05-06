package com.example.AlkemyLabs.model;

public enum TypeRole {

    ADMINISTRADOR("ADMINISTRADOR","El administrador podrá gestionar las materias, profesores, cupos de inscripción."),
    ALUMNO("ALUMNO","El usuario podrá seleccionar las materias en las que desea inscribirse");

    private String nombre;
    private String descripcion;


    TypeRole(String nombre,String descripcion){
        this.nombre=nombre;
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

    public String getNombre() {return this.nombre;}
    public String getDescripcion(){
        return this.descripcion;
    }

}
