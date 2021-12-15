package com.company;

public class Utilidades {
    private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
}
