/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_progjar_dhz;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author Aldhiaz Fathra Daiva, 5113100006
 */
public class UTS_progjar_dhz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("10.151.43.147", 6666);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            
            Scanner inputlink = new Scanner(socket.getInputStream());
            Scanner input = new Scanner(System.in);
            
            String message;
            
            message = inputlink.nextLine();
            System.out.println(message);
            
            message = inputlink.nextLine();
            System.out.println(message);
            
            message = input.nextLine();
            os.write(new String("Username:" + message + "\n").getBytes());
            System.out.println("Username:" + message + "\n");
            /*No.1, input manual NRP nya*/
            
            message = inputlink.nextLine();
            System.out.println(message);
            
            message = inputlink.nextLine();
            for (;/*ever*/;) {
                System.out.println(message);
              
                String[] operator = message.split(" ");
                int hasil;
                int[] operand;
                operand = new int[4];
                operand[0] = Integer.parseInt(new String(operator[0]));
                operand[1] = Integer.parseInt(new String(operator[2]));

                if      (operator[1].equals("+"))
                    hasil = operand[0] + operand[1];
                else if (operator[1].equals("-"))
                    hasil = operand[0] - operand[1];
                else if (operator[1].equals("x"))
                    hasil = operand[0] * operand[1];
                else 
                    hasil = operand[0] % operand[1];

                message = Integer.toString(hasil);
                System.out.println(message);
                /*No.2 done \(^o^)/*/

                os.write(new String("Result:" + message + "\n").getBytes());
                message = inputlink.nextLine();
                System.out.println(message);

                if (message.startsWith("Hash")) {
                    message = inputlink.nextLine();
                    System.out.println(message);

                    message = inputlink.nextLine();
                    System.out.println(message);

                    os.write(new String("Hash:" + message + "\n").getBytes());
                    System.out.println("Hash:" + message);
                }
                message = inputlink.nextLine();

                if(message.startsWith("666")) 
                    break;
                /*No.3 done \(^o^)/*/
            }
            System.out.println(message);

            is.close();
            os.close();
            socket.close();
            
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}
