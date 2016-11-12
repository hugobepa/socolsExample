/*



 */
package CreacioURL;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author hugo
 */
public class CreacioURL 
{
    public static void main(String[] args) throws MalformedURLException 
    {
        URL myURL = new URL("http://example.com/pages/");
        URL page1URL = new URL(myURL, "page1.html");
        URL page2URL = new URL(myURL, "page2.html");
        
        //URL(URL baseURL, String relativeURL)
         URL page1BottomURL = new URL(page1URL,"#BOTTOM");
         
        System.out.println("myURL: " +myURL.toString());
        System.out.println("myURL: " +page1URL.toString());
        System.out.println("myURL: " +page2URL.toString());
         
    }
}
