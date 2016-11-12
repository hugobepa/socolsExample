/*
 *  try {
         URL url = new URL("https://www.amrood.com/index.htm?language=en#j2se");
         
         System.out.println("URL is " + url.toString());
         System.out.println("protocol is " + url.getProtocol());
         System.out.println("authority is " + url.getAuthority());
         System.out.println("file name is " + url.getFile());
         System.out.println("host is " + url.getHost());
         System.out.println("path is " + url.getPath());
         System.out.println("port is " + url.getPort());
         System.out.println("default port is " + url.getDefaultPort());
         System.out.println("query is " + url.getQuery());
         System.out.println("ref is " + url.getRef());
      }catch(IOException e) {
         e.printStackTrace();
      }
 */
package URLTrabajar;

import java.io.IOException;
import java.net.URL;

/**
 *
 * @author hugo
 */
public class URLTrabajar 

{
    public static void main(String[] args) 
    {
         try {
         URL url = new URL("https://ioc.xtec.cat");
         
         System.out.println("URL is toString(): " + url.toString());
         System.out.println("protocol is getProtocol(): " + url.getProtocol());
         System.out.println("authority is getAuthority(): " + url.getAuthority());
         System.out.println("file name is getFile(): " + url.getFile());
         System.out.println("host is getHost(): " + url.getHost());
         System.out.println("path is getPath(): " + url.getPath());
         System.out.println("port is getPort(): " + url.getPort());
         System.out.println("default port is .getDefaultPort(): " + url.getDefaultPort());
         System.out.println("query is getQuery(): " + url.getQuery());
         System.out.println("ref is getRef(): " + url.getRef());
      }catch(IOException e) {
         e.printStackTrace();
      }
    }
}
