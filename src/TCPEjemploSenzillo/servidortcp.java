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
import java.net.*; //Importa la libreria java.net
import java.io.*;  //Importa la libreria java.io
 
public class servidortcp {
   //se declara una clase de nombre servidortcp
 
	 public static void main(String argv[]) {
 
// declaramos un objeto ServerSocket para realizar la comunicaci�n
      ServerSocket socket;
// creamos una varible boolean con el valor a false 
      boolean fin = false;
 
// Declaramos un bloque try y catch para controlar la ejecuci�n del subprograma
      try {
 
// Instanciamos un ServerSocket con la direcci�n del destino y el 
// puerto que vamos a utilizar para la comunicaci�n
 
         socket = new ServerSocket(6162);
 
//Bucle externo necesario para realizar nuevas peticiones
 
      do{
// Creamos un socket_cli al que le pasamos el contenido del objeto socket despu�s 
// de ejecutar la funci�n accept que nos permitir� aceptar conexiones de clientes
         Socket socket_cli = socket.accept();
 
// Declaramos e instanciamos el objeto DataInputStream
// que nos valdr� para recibir datos del cliente
 
         DataInputStream in =
            new DataInputStream(socket_cli.getInputStream());
 
// Creamos un bucle do while en el que recogemos el mensaje
// que nos ha enviado el cliente y despu�s lo mostramos
// por consola 
 
 
          DataOutputStream out =
             new DataOutputStream(socket_cli.getOutputStream());
 
 
         String mensaje =""; //Se inicializa la variable de string mensaje a vacío
         mensaje = in.readUTF(); //La variable Mensaje guarda el valor que ha mandado el cliente
 
         // Si recibimos HELLO mostramos HELLO
         if (mensaje.startsWith("HELLO")) {
        	 out.writeUTF("HELLO");
         }
 
 
         //variables necesarias para llevar la cuenta de compras
         int comp1, comp2, comp3,comp4, comp5;
         comp1= comp2= comp3=comp4= comp5= 0;
 
         //Iniciamos el bucle
         do {
 
           //Dependiendo de la sentencia que haya enviado el cliente realizaremos una acción 
 
            mensaje ="";
            mensaje = in.readUTF();
 
 
            if (mensaje.startsWith("TOTAL")) {
                 int total= 0;
                 total=comp1*10+comp2*19+comp3*26+comp4*38+comp5*40;
                 System.out.println("TOTAL :"+comp1+";"+comp2+";"+comp3+";"+comp4+";"+comp5+":"+ total );
                 out.writeUTF("TOTAL :"+comp1+";"+comp2+";"+comp3+";"+comp4+";"+comp5+":"+ total );
            }
            else if (mensaje.startsWith("COMP 1")) {
                 System.out.println(":10 €");
        	     out.writeUTF(":10 €");
                 ++comp1;
            }
            else if (mensaje.startsWith("COMP 2")) {
        	 System.out.println(":19 €");
                 out.writeUTF(":19 €");
                 ++comp2;
            }
            else if (mensaje.startsWith("COMP 3")) {
                 System.out.println(":26 €");
        	 out.writeUTF(":26 €");
                 ++comp3;
            }
            else if (mensaje.startsWith("COMP 4")) {
                 System.out.println(":38 €");
        	 out.writeUTF(":38 €");
                  ++comp4;
            }
            else if (mensaje.startsWith("COMP 5")) {
                 System.out.println(":40 €");
        	 out.writeUTF(":40 €");
                 ++comp5;
            }
            else if (mensaje.startsWith("ANUL 1")) {
 
                 if (comp1>=1){
                 System.out.println(":-10 €");
        	 out.writeUTF(":-10 €");                     
                 --comp1;
                 }
            }
            else if (mensaje.startsWith("ANUL 2")) {
 
                 if (comp2>=1){
        	 System.out.println(":-19 €");
        	 out.writeUTF(":-19 €");                     
                 --comp2;
                 }
            }
            else if (mensaje.startsWith("ANUL 3")) {
 
                 if (comp3>=1){
                 System.out.println(":-26 €");
        	 out.writeUTF(":-26 €");                     
                 --comp3;
                 }
            }
            else if (mensaje.startsWith("ANUL 4")) {
 
                 if (comp4>=1){
                 System.out.println(":-38 €");
        	     out.writeUTF(":-38 €");
                 --comp4;
                 }
            }
            else if (mensaje.startsWith("ANUL 5")) {
 
                 if (comp5>=1){
                 System.out.println(":-40 €");
        	     out.writeUTF(":-40 €");    
                 --comp5;
                 }
            }
            else if (mensaje.startsWith("END")) {
                 System.out.println("END");
                 out.writeUTF("END");
            }
 
            else {
            System.out.println("ERROR");
            out.writeUTF("ERROR");
            }
 
         } 
         while (!mensaje.startsWith("END"));
         socket_cli.close();
      }        
      while (1>0);
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