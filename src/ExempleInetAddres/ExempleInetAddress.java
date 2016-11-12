/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExempleInetAddres;

/**
 * Ejemplo InetAddress
 * @author hugo
 */
//importar paquetes
import java.net.*; 
public class ExempleInetAddress 
{
    
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress Address = InetAddress.getLocalHost();
        System.out.println("Exemple getLocalHost(): " + Address);
        Address = InetAddress.getByName("starwave.com");
         System.out.println("Exemple getByName(\"starwave.com\"): " + Address);
         byte[] ipAddr = new byte[]{127, 0, 0, 1};
         Address=InetAddress.getByAddress(ipAddr);
         System.out.println("Exemple getByAddress(new byte[]{127, 0, 0, 1}): " + Address); 
        Address = InetAddress.getByName("173.194.67.104");
         System.out.println("Exemple getByName(\"173.194.67.104\"): " + Address);
         InetAddress SW[] =InetAddress.getAllByName("www.nba.com");        
         System.out.println("Exemple  getAllByName(\"www.nba.com\": ): " + SW[0] );
        
        
        InetAddress[] addresses = new InetAddress[2];
        addresses[0] = InetAddress.getLoopbackAddress();
        addresses[1] = InetAddress.getByName("ioc.xtec.cat");
        for(InetAddress adress: addresses){
        if(adress.isLoopbackAddress()){
        System.out.println(adress.getHostName() + " té una adreça loopback");
        }else{
        System.out.println(adress.getHostName() + " no té una adreça loopback");
        }
        }
        
        
    }
    
            
    
}
