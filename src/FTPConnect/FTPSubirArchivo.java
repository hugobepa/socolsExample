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
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;



public class FTPSubirArchivo {
    
    public static void main(String[] args) throws IOException {
                FTPClient ftpclient = new FTPClient();
                FileInputStream fis = null;
                boolean result;
                String ftpServerAddress = "localhost";
                String userName = "admin";
                String password = "admin";

                try {
                        ftpclient.connect(ftpServerAddress);
                        result = ftpclient.login(userName, password);

                        if (result == true) {
                                System.out.println("Logged in Successfully !");
                        } else {
                                System.out.println("Login Fail!");
                                return;
                        }
                        ftpclient.setFileType(FTP.BINARY_FILE_TYPE);

                        ftpclient.changeWorkingDirectory("/");

                        File file = new File("D:/File.doc");
                        String testName = file.getName();
                        fis = new FileInputStream(file);

                        // Upload file to the ftp server
                        result = ftpclient.storeFile(testName, fis);

                        if (result == true) {
                                System.out.println("File is uploaded successfully");
                        } else {
                                System.out.println("File uploading failed");
                        }
                        ftpclient.logout();
                } catch (FTPConnectionClosedException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                ftpclient.disconnect();
                        } catch (FTPConnectionClosedException e) {
                                System.out.println(e);
                        }
                }
        }

    
}
