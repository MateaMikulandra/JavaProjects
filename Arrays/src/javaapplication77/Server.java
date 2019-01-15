
package javaapplication77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(100);
        while(true){
        Socket s = server.accept();
        new Racunanje(s).start();
        }      
}
}