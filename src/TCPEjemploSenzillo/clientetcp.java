/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCPEjemploSenzillo;

/**
 *
 * @author hugo
 */
import java.net.*; //Se importa la libreria java.net
import java.io.*; //Se importa la libreria java.io
 
//Se declara la clase clientetcp
public class clientetcp {
 
	//Se declara el método principal main que recibe un parámetro
   public static void main(String argv[]) {
 
// Si no recibe ning�n par�metro escribira esta linea y saldr� 
// del programa
      /*if (argv.length == 0) {
         System.err.println("java clientetcp servidor");
         System.exit(1);
      }*/
 
 
// Creamos una instancia BuffererReader en la 
// que guardamos los datos introducido por el usuario       
 
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
// declaramos un objeto socket para realizar la comunicaci�n
      Socket socket;
 
// declaramos un objeto de tipo InetAddress para la direcci�n
      InetAddress address;
 
// declaramos e instanciamos un objeto de tipo byte 
      byte[] mensaje_bytes = new byte[256];
 
// declaramos una variable de tipo string
      String mensaje="";
 
// Declaramos un bloque try y catch para controlar la ejecuci�n del subprograma 
      try {
 
// Obtenemos la direcci�n que el usuario a pasado como argumento 	  
         address=InetAddress.getByName("localhost");
 
// Instanciamos un socket con la direcci�n del destino y el 
// puerto que vamos a utilizar para la comunicaci�n
         socket = new Socket("localhost",6162);
 
// Declaramos e instanciamos el objeto DataOutputStream
// que nos valdr� para enviar datos al servidor destino
         DataOutputStream out =
            new DataOutputStream(socket.getOutputStream());
 
 
 
         DataInputStream in2 =
             new DataInputStream(socket.getInputStream());
 
         //Mandamos la palabra HELLO al servidor
         out.writeUTF("HELLO");
 
         //devuelve el servidor
         mensaje = in2.readUTF();
 
         // contenido de mensaje devuelto
         System.out.println(mensaje);
 
 
 
// Creamos un bucle do while en el que enviamos al servidor el mensaje
// los datos que hemos obtenido despues de ejecutar la funci�n
// "readLine" en la instancia "in"
 
 
         do {
 
            mensaje="";
            mensaje = in.readLine();   
 
            out.writeUTF(mensaje);
            mensaje = in2.readUTF();
            System.out.println(mensaje);
 
         } while (!mensaje.startsWith("END"));
      }
// utilizamos el catch para capturar los errores que puedan surgir
      catch (Exception e) {
// si existen errores los mostrar� en la consola y despu�s saldr� del
// programa
 
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}