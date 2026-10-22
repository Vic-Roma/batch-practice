package com.vititor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        //declaracion de directorios y archivo a utilizar
        Path entrada = Path.of("data", "ventas.csv");
        Path salida = Path.of("output", "salida_test.txt");

        //Files.createDirectories(...) puede lanzar una IOException la cual es una unchecked exception 
        //la cual java nos obliga a manejarla
        try {
            //Crea directorios de salida
            Files.createDirectories(salida.getParent());

            //System.out.println("hola " + salida);
            if (!Files.exists(entrada)) {
                System.out.println("No se encontro archivo");
                return;
            }

            if (!Files.isRegularFile(entrada)) {
                System.out.println("No es un archivo regular");
                return;
            }

            if (!Files.isReadable(entrada)) {
                System.out.println("El archivo no permite lectura");
                return;
            }

            System.out.println("Archivo preparado");
            System.out.println();
        } catch (IOException e) {

            System.out.println("Error al preparar archivo: " + e.getMessage());
        }

        try (BufferedReader bReader = Files.newBufferedReader(entrada);
             BufferedWriter bWriter = Files.newBufferedWriter(salida)) {

            String linea;
            int numFilas = 0;
            while ((linea = bReader.readLine()) != null) {
                numFilas++;

                bWriter.write(linea);
                bWriter.newLine();
            }

            System.out.print("Número de filas: " + numFilas);

        } catch (Exception e) {
            System.err.println(
                    "Error al leer el archivo: " + e.getMessage()
            );
        }

    }
}
