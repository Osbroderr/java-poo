package com.page57_58;

public class Exo1 {
    public static void main(String[] args) {
        String reversed = reverseString("Voici une phrase à mettre à l'envers");

        System.out.println(reversed);
    }

    public static String reverseString(String newString) {
        String myStringAfter = newString.trim().replaceAll(" +", " ");
        String[] myStringArray = myStringAfter.split("");

        String reversed = "";
        int i;

        for (i = myStringArray.length - 1; i >= 0; i--) {
            reversed += myStringArray[i];
        }

        return reversed;
    }
}
