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
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;



public class FTPBajarArchivo {
     public static void main(String[] args) throws IOException {
                FTPClient ftpClient = new FTPClient();
                FileOutputStream fos = null;
                boolean result;
                try {
                        // Connect to the localhost
                        ftpClient.connect("localhost");

                        // login to ftp server
                        result = ftpClient.login("", "");
                        if (result == true) {
                                System.out.println("Successfully logged in!");
                        } else {
                                System.out.println("Login Fail!");
                                return;
                        }
                        String fileName = "uploadfile.txt";
                        fos = new FileOutputStream(fileName);

                        // Download file from the ftp server
                        result = ftpClient.retrieveFile(fileName, fos);

                        if (result == true) {
                                System.out.println("File downloaded successfully !");
                        } else {
                                System.out.println("File downloading failed !");
                        }
                        ftpClient.logout();
                } catch (FTPConnectionClosedException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                if (fos != null) {
                                        fos.close();
                                }
                                ftpClient.disconnect();
                        } catch (FTPConnectionClosedException e) {
                                System.err.println(e);
                        }
                }
        }

    
}
