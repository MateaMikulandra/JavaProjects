
package javaapplication188;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Podaci {
    public static void main(String[] args) {
                       
    ArrayList lista = new ArrayList();
    String text = "John.Davidson/05051988/Belgrade "
                + "Michael.Barton/01011968/Krakov "
                + "Ivan.Perkinson/23051986/Moscow";
    for (int i = 0; i < lista.size(); i++)
    System.out.println(lista);
    
    String[] textArray = text.split("[./ ]");
        for(int i=0;i<textArray.length;i+=4){
            String ime = textArray[i];
            String prezime = textArray[i+1];
            String datumRodjenja = textArray[i+2];
            String mestoRodjenja = textArray[i+3];
            
    LocalDate datum = LocalDate.parse(datumRodjenja, DateTimeFormatter.ofPattern("ddMMyyyy"));
            
            
        Person p = new Person(ime,prezime,datum,mestoRodjenja);
            lista.add(p);
        }
        for(Object o: lista)
            System.out.println((Person) o);
    }
        }
            
    

