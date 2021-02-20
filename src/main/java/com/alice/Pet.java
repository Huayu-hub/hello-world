package com.alice;


public class Pet {

    private String name ;
    private int age ;


    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Pet() {
        this.name = "动物" ;
        this.age = 0 ;
    }

    public void settings(String name , int age ) {
        name = this.name ;
        age = this.age ;
    }

    public String getName()  {
        return this.name ;
    }

    public int getAge()  {
        return this.age ;
    }
}
