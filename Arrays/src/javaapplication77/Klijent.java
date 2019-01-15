package javaapplication77;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Klijent {

    public static Choice myChoice;

    public static void main(String[] args) {
        Frame f = new Frame("Racunanje");
        LayoutManager layOut = new FlowLayout();
        Label l = new Label("Uneti");
        f.add(l);
        f.setLayout(layOut);

        f.setSize(450, 450);
        f.setVisible(true);


        TextField tf1 = new TextField("Prvi broj:",20);
        TextField tf2 = new TextField("Drugi broj:",20);
        TextField tf3 = new TextField(20);
        tf3.setEnabled(false);

        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.setBackground(Color.ORANGE);
        
        myChoice = new Choice();
        myChoice.add("+");
        myChoice.add("-");
        myChoice.add("*");
        myChoice.add("/");
        f.add(myChoice);

        Button b = new Button("Klikni");
        f.add(b, BorderLayout.LINE_END);
        b.setPreferredSize(new Dimension(300, 50));
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String znak = (myChoice.getSelectedItem());
                {

                    try {
                        Socket s = new Socket("localhost", 100);
                        InputStream input = s.getInputStream();
                        OutputStream output = s.getOutputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(input));

                        String poruka;
                        poruka = l.getText()+ tf1.getText().trim() + "," + tf2.getText().trim() + "," + znak;

                        output.write((poruka + "\r\n").getBytes());
                        output.flush();

                        String rezultat = br.readLine();
                        tf3.setText(rezultat);

                    } catch (IOException exc) {
                        System.out.println(exc.getMessage());
                    }

                }
            }
        });

        f.add(b);

        Button ex = new Button("Izlaz");
        ex.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        f.add(ex);
        f.setVisible(true);

    }
}
