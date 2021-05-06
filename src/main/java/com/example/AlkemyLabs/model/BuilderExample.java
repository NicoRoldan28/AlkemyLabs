package com.example.AlkemyLabs.model;

public class BuilderExample {
    private Integer id;
    private String name;
    private String lastName;
    private Integer dni;

    public BuilderExample(Integer id,String name,String lastName,Integer dni){
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.dni=dni;
    }
    public BuilderExample(){
        this.id=null;
        this.name=null;
        this.lastName=null;
        this.dni=null;
    }

    public BuilderExample id(Integer id){
        this.id=id;
        return this;
    }

    public BuilderExample name(String name){
        this.name=name;
        return this;
    }

    public BuilderExample lastName(String lastName){
        this.lastName=lastName;
        return this;
    }

    public BuilderExample dni(Integer dni){
        this.dni=dni;
        return this;
    }
    public static void main(String[] args){
        BuilderExample builderExample= new BuilderExample();
        builderExample.id(28);
        builderExample.name("nicolas");
        builderExample.lastName("roldan");
        builderExample.dni(41306781);
    }
}
