///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package utsprogjarclient;
//
//import java.io.*;
//import java.net.*;
//import java.util.*; 
//
///**
// *
// * @author dhz
// */
//public class UTSProgjarClient {
//    
//    /**
//     * @param args the command line arguments
//     */
//    private static InetAddress host;
//    private static final int PORT = 6666;
//    public static void main(String[] args) {
//        try {
//           host = InetAddress.getLocalHost();
//        }
//        catch(UnknownHostException uhEx) {
//           System.out.println("\nHost ID not found!\n");
//           System.exit(1);
//        }
//        
//        sendMessages();
//     }
//    
//     private static void sendMessages() {
//        Socket socket = null;
//        try {
//            byte[] buf = new byte[10];
//            socket = new Socket("10.151.34.155",6666);
//            
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
//            
////            Scanner networkInput = new Scanner(socket.getInputStream());
////            PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);
//            //Set up stream for keyboard entry...
//            Scanner userEntry = new Scanner(System.in);
//            
//            
//            String message, response;
//            os.write("username:5113100006\n".getBytes());
//            os.flush();
//            int len;
//            do {
//                System.out.print("Enter message (press Enter to exit): ");
//                message = userEntry.nextLine();
//                //Send message to server on the
//                //socket's output stream...
//                //Accept response from server on the
//                //socket's intput stream...
//                
////                networkOutput.println(message);
////                response = networkInput.nextLine();
//                
//                //Display server's response to user...
//                
//                buf = new byte[10];
//                len = is.read(buf);
//                if(len == -1) {
//                    break;
//                }
//                
//                System.out.print(new String(buf));
//                //System.out.println("\nSERVER> " + response);
//            } while (true);//!message.equals(""));
//        }
//        catch(IOException ioEx) {
//            ioEx.printStackTrace();
//        }
//        finally {
//           try {
//               System.out.println("\nClosing connection...");
//               socket.close();
//           }
//           catch(IOException ioEx) {
//               System.out.println("Unable to disconnect!");
//               System.exit(1);
//           }
//        }
//    }
//} 


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utsprogjarclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baskoro
 */
public class UTSProgjarClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            byte[] buf = new byte[10];
            
            Socket socket = new Socket("10.151.34.155", 6666);
            //Socket socket = new Socket("localhost", 6666);
            
//            DataInputStream is;
//            PrintStream os;
            
//            InputStream is = socket.getInputStream();
//            OutputStream os = socket.getOutputStream();
            
            DataInputStream is = new DataInputStream(socket.getInputStream());
            PrintStream os = new PrintStream(socket.getOutputStream());
            
//            is = new DataInputStream(clientSocket.getInputStream());
//            os = new PrintStream(clientSocket.getOutputStream());
            
            os.write("username:5113100006\n".getBytes());
            os.flush();
            
            
            
            
            //+, -, *, mod
            
            
            
//            os.write(s.getBytes());
//            os.flush();
//            
//            if(is.toString()=="") return;
            os.write("result:2479\n".getBytes());
            os.flush();
//            
//            os.write("result:511\n".getBytes());
//            os.flush();
            
            int len;
            while(true) {
                buf = new byte[10];
                len = is.read(buf);
                if(len == -1) {
                    break;
                }
                
//                String s1 = new String(buf+"\n");
//                String[] s2 = s1.split("\\s+");
//                //if(s2[1].equals(""));
//                int int1 = Integer.parseInt(s2[0]);
//                int int2 = Integer.parseInt(s2[2]);
//                int jawaban = 0;
//                if(s2[1]=="+")
//                    jawaban = int1 + int2;
//                else if(s2[1]=="-")
//                    jawaban = int1 - int2;
//                else if(s2[1]=="*")
//                    jawaban = int1 * int2;
//                else if(s2[1]=="mod")
//                    jawaban = int1 % int2;
//                String result = "result:" + Integer.toString(jawaban) + "\n";
                
                System.out.print(new String(buf));
            }
            System.out.println("asafgsdagsdag");
            os.close();
            is.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(UTSProgjarClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}