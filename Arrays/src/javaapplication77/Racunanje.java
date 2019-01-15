
package javaapplication77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Racunanje extends Thread {
    Socket s;
    public Racunanje(Socket s){
        this.s = s;
    }
    @Override 
    public void run(){
            super.run();
        try{
            InputStream input = s.getInputStream();
        OutputStream output = s.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = br.readLine();   
            System.out.println(line);
            String pop1 = line.split(",")[0];
            int op1 = Integer.parseInt(pop1.split(":")[1]);
            String pop2 = line.split(",")[1];
            int op2 = Integer.parseInt(pop2.split(":")[1]);
            String znak = (line.split(",")[2]);
            String rezultat = "";
            switch (znak) {
            case "+": 
                rezultat = String.valueOf(op1 + op2) ;
                     break;
            case "-": 
                rezultat = String.valueOf(op1 - op2) ;
                     break;
            case "/": 
                rezultat = String.valueOf(op1 / op2) ;
                     break;
            case "*": 
                rezultat = String.valueOf(op1 * op2) ;
                     break;
            }
            System.out.println(rezultat);
            output.write(("Rezultat je:" + rezultat +"\r\n").getBytes());
            output.flush();
        
    }   catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
        
