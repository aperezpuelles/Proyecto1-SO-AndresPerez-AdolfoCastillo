/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.so;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Ignacio
 */
public class ConfiguracionTXT {
    private String rutaArchivo;

    public ConfiguracionTXT(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        verificarYCrearArchivo();
    }
    
    public void verificarYCrearArchivo() {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                guardarParametros(2, 15, 2, 1, 1, 1, 1, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] leerParametros() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        int[] parametros = new int[8]; 
        for (int i = 0; i < parametros.length; i++) {
            parametros[i] = Integer.parseInt(reader.readLine());
        }
        return parametros;
    }

    public void guardarParametros(int duracion, int diasEntrega, int placaBase, int cpu, int ram, int fuente, int grafica, int ensamblador) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(duracion + "\n");
            writer.write(diasEntrega + "\n");
            writer.write(placaBase + "\n");
            writer.write(cpu + "\n");
            writer.write(ram + "\n");
            writer.write(fuente + "\n");
            writer.write(grafica + "\n");
            writer.write(ensamblador + "\n");
        }
    }
}
