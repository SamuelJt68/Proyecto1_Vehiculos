package ControladorSesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Seguridad {

    public boolean validarCredenciales(String login, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/datos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals(login) && data[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return false;
    }

    public boolean validarCredencialesCliente(String nombre, String email) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/clientes.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 2 && data[0].equals(nombre) && data[1].equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return false;
    }
}
