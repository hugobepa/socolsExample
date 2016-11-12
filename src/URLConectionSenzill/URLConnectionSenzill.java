/*
 *  String getContentEncoding(). Obté la codificació de caràcters que el
    contingut del recurs fa servir.
    int getContentLength(). Aconsegueix la longitud del contingut que indica
    la capçalera.
    String getContentType() Retorna el tipus de contingut d’acord amb
    l’estàndard HTTP. Aquesta especificació per exemple tipifica un document de text
    com a text/plain, un document HTML com a text/html, una imatge JPG
    com a image/jpg, etc.
    long getDate(). Ofereix la data de creació/modificació del recurs con un
    valor numèric de tipus long
 *
 */
package URLConectionSenzill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * cd  /home/hugo/NetBeansProjects/Socols1/src/URLConectionSenzill
 * Terminal:
 *$java URLConnectionSenzill
 * @author hugo
 */
public class URLConnectionSenzill
{
    public static void main(String[] args) 
    {
        try {
            URL url = new URL("https://www.amrood.com");
            URLConnection con = url.openConnection();
            HttpURLConnection connection = null;
            //comprobar si lleva http
         if(con instanceof HttpURLConnection) {
            connection = (HttpURLConnection) con;
         }else {
            System.out.println("Please enter an HTTP URL.");
            return;
         }
         
         BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
         String urlString = "";
         String current;
         
         while((current = in.readLine()) != null) {
            urlString += current;
         }
           System.out.println(urlString); 
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(URLConnectionSenzill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(URLConnectionSenzill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
