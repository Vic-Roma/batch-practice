package com.vititor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        //declaracion de directorios y archivo a utilizar
        Path entrada = Path.of("data", "ventas.csv");
        Path salida = Path.of("output");


        //Files.createDirectories(...) puede lanzar una IOException la cual es una unchecked exception 
        //la cual java nos obliga a manejarla
        try {
            //Crea directorios de salida
            Files.createDirectories(salida);
            
            
        if(!Files.exists(entrada)){
            System.out.println("No se encontro archivo");
            return;
        }

        if(!Files.isRegularFile(entrada)){
            System.out.println("No es un archivo regular");
            return;
        }

        if(!Files.isReadable(entrada)){
            System.out.println("El archivo no permite lectura");
            return;
        }

        System.out.println("Archivo preparado");
        } catch (IOException e) {

            System.out.println("Error al preparar archivo: " + e.getMessage());
        }
        







    }
}