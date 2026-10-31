package jericothcastellar.imc.rmi.cli;

import jericothcastellar.imc.rmi.lib.DatosImc;
import jericothcastellar.imc.rmi.lib.IRemotaCalculoImc;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.Client;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conexión al servidor en localhost:9007
            CallHandler invocador = new CallHandler();
            Client cliente = new Client("localhost", 9007, invocador);

            // Obtiene referencia al objeto remoto
            IRemotaCalculoImc remoto = (IRemotaCalculoImc) 
                    cliente.getGlobal(IRemotaCalculoImc.class);

            // Envía datos de prueba
            DatosImc datos = new DatosImc(70, 1.75f); // peso=70kg, altura=1.75m
            datos = remoto.calcularImc(datos);

            // Muestra resultado
            System.out.println("IMC: " + datos.getResultado());
            System.out.println("Interpretacion: " + datos.getInterpretacion());

            cliente.close();
        } catch (Exception ex) {
            System.out.println("Error en cliente: " + ex.getMessage());
        }
    }
}
