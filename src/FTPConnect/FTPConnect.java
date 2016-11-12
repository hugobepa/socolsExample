/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTPConnect;

/**
 *
 * @author hugo
 */



 

 


import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;

public class FTPConnect {
    
    public static void main(String[] args) throws IOException {
                FTPClient ftpClient = new FTPClient();
                boolean result;
                try {
                        // Connect to the localhost
                        ftpClient.connect("localhost");

                        // login to ftp server
                        result = ftpClient.login("admin", "password");
                        if (result == true) {
                                System.out.println("Successfully logged in!");
                        } else {
                                System.out.println("Login Fail!");
                                return;
                        }
                } catch (FTPConnectionClosedException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                ftpClient.disconnect();
                        } catch (FTPConnectionClosedException e) {
                                System.out.println(e);
                        }
                }

        }

    
}
