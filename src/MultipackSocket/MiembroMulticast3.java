/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultipackSocket;
import java.net.*;
import java.io.*;
/**
 *http://www.it.uc3m.es/amarin/uc3m/java/ui/index.html
 * http://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsUDP/
 * @author hugo
 */
public class MiembroMulticast3 {
  public static void main(String args[]) {
    // args[0] es el mensaje enviado al grupo y args[1] es la direccion del grupo
    try { 
      String sms="William Hart: Entonces no deberías llevar ese cuerpo.";  
      InetAddress grupo = InetAddress.getByName("localhost");
      MulticastSocket socket = new MulticastSocket(6789);

      // Se une al grupo
      socket.joinGroup(grupo);

      // Envia el mensaje
      byte[] m = sms.getBytes();
      DatagramPacket mensajeSalida =
	new DatagramPacket(m, m.length, grupo, 6789);
      socket.send(mensajeSalida);

      byte[] bufer = new byte[1000];
      String linea;

      // Se queda a la espera de mensajes al grupo, hasta recibir "Adios"
      while (true) {
	DatagramPacket mensajeEntrada =
	  new DatagramPacket(bufer, bufer.length);
	socket.receive(mensajeEntrada);
	linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
	System.out.println("Recibido:" + linea);
	if (linea.equals("Adios")) break;
      }

      // Si recibe "Adios" abandona el grupo
      socket.leaveGroup(grupo);
    } catch (SocketException e) {
      System.out.println("Socket:" + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO:" + e.getMessage());
    }
  }
}

