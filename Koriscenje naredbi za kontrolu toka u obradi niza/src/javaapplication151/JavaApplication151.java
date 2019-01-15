package javaapplication151;

import java.util.Arrays;

public class JavaApplication151 {

    public static void main(String[] args) {

        int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};

        int brojPoz = 0;
        int brojNeg = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                brojPoz++;
            } else if (array[i] < 0) {
                brojNeg++;
            }

        }
        int p = 0;
        int n = 0;
        int[] poz = new int[brojPoz];
        int[] neg = new int[brojNeg];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {

                poz[p] = array[i];
                ++p;
            } else if (array[i] < 0) {

                neg[n] = array[i];
                ++n;
            }
        }

        System.out.println("Pozitivni brojevi su:" + "\n" + java.util.Arrays.toString(poz));
        System.out.println("Negativni brojevi su:" + "\n" + java.util.Arrays.toString(neg));

        
            Arrays.sort(array);
            int ukupanBrojDuplikata = 0;
        for (int j = 0; j < array.length - 1; j++) {            
            int brojDupl = 1;           
            if (array[j] == array[j + 1])                 
            {
                ++ukupanBrojDuplikata;
                        
                
                System.out.println("Element " + array[j] + " se ponavlja " + ++brojDupl + " puta.");
                
            }
            
            }
        System.out.println("Ukupan broj duplikata: " + ukupanBrojDuplikata);
    }
    }

