package com.example.prueba;

public class UnirCadenas {
    public static void main(String[] args) {
        String[] arrayStrings = {"FristWord", "SecondWord", "THIRDWORD"};

        try {
            if (arrayStrings.length > 10) {
                throw new IllegalArgumentException("el array supera el limite de 10 de largo.");
            }

            StringBuilder result = new StringBuilder();
            for (String str : arrayStrings) {
                if (!str.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("El array debe contener solo letras en ingles y espacios.");
                }
                result.append(str.toLowerCase()).append(" ");
            }

            System.out.println(result.toString().trim());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

