package com.codedifferently.casino.utilities.cardenums;

public enum Color{
    
    BLACK("Black"), RED("Red");

    private final String color;

    private Color(String color){
        this.color = color;
    }

    public String returnColor(){
        return color;
    }
}