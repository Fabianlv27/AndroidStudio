package com.example.editoractionlistenej1;

public class biblioteca {

    public static String dninie(String dninie){
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
         int pos="XYZ".indexOf(dninie.charAt(0));
         if (pos!=-1){
            dninie= String.valueOf(pos)+dninie.substring(1);
         }
         int numero=Integer.valueOf(dninie);
        return String.valueOf(letras.charAt(numero%23));
    } ;
}
