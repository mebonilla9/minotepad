/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.minotepad.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Lord_Nightmare
 */
public final class Archivador {

    public static void guardarArchivo(String texto, File archivoGuardado) throws FileNotFoundException {
        PrintStream escritor = new PrintStream(archivoGuardado);
        escritor.print(texto);
        escritor.flush();
        escritor.close();
    }

    public static String abrirArchivo(File rutaArchivo) throws IOException{
        // Forma noob de crear el buffer de escritura
        /*FileInputStream fis = new FileInputStream(rutaArchivo);
        InputStreamReader isr =new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);*/

        // Forma Pro de crear el buffer de escritura con objetos anonimos
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(rutaArchivo)
                )
        );

        String linea;
        StringBuilder contenido = new StringBuilder();
        while ((linea = br.readLine()) != null) {
            contenido.append(linea);
        }
        br.close();
        return contenido.toString();
    }

}
