package jericothcastellar.imc.rmi.net;

public class Principal {
    public static void main(String[] args) {
        Servidor servicio = new Servidor();
        try {
            servicio.iniciar();
        } catch (Exception ex) {
            System.out.println("Error al iniciar servidor: " + ex.getMessage());
        }
    }
}
