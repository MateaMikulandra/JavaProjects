
package javaapplication188;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Person {
    String ime;
    String prezime;
    LocalDate datumRodjenja;
    String mestoRodjenja;
    
    Person(String ime, String prezime, LocalDate datumRodjenja, String mestoRodjenja){
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.mestoRodjenja = mestoRodjenja;
    }   
    

    @Override
    public String toString()
    {
        String datum = datumRodjenja.format(DateTimeFormatter.ofPattern("dd.MMM yyyy."));
        return "\n Ime:" + ime + "\n Prezime:" + prezime + "\n Datum rođenja:"
                + datum + "\n Mesto Rođenja:" + mestoRodjenja;
    }    
}
