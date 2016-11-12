/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDPSenzill;

/**
 *
 * @author hugo
 */
import java.net.*;
import java.io.*;

public class ClienteUDP {

  // Los argumentos proporcionan el mensaje y el nombre del servidor
  public static void main(String args[]) {

    try {
           /*CONSTRUIMOS EL MENSAJE PARA ENVIAR*/
       //Datos para crear el mensaje 
      String sms="El hombre es lo que falla en la humanidad\n"
              + "y solo se puede hablar bien. Cuando este muerto\n";  
      DatagramSocket socketUDP = new DatagramSocket();
      byte[] mensaje = sms.getBytes();
      //InetAddress hostServidor = InetAddress.getByName(args[1]);
      InetAddress hostServidor = InetAddress.getByName("localhost");
      int puertoServidor = 6789;

      // Construimos un datagrama para enviar el mensaje al servidor
      DatagramPacket peticion =
        new DatagramPacket(mensaje, sms.length(), hostServidor,
                           puertoServidor);
             /* ENVIAR MENSAJE  */
      // Enviamos el datagrama
      socketUDP.send(peticion);
                /*RECIBIR  RESPUESTA*/
      // Construimos el DatagramPacket que contendrá la respuesta
      byte[] bufer = new byte[1000];
      DatagramPacket respuesta =
        new DatagramPacket(bufer, bufer.length);
      socketUDP.receive(respuesta);

      // Enviamos la respuesta del servidor a la salida estandar
      System.out.println("Respuesta: " + new String(respuesta.getData()));
                 /*CORTO Y CAMBIO*/        
      // Cerramos el socket
      socketUDP.close();

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}

