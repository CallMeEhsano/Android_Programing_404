// this code written in 1404-07-14
// بهینه سازی کد اول که دریافت 5 عدد و مرتب کردن آن بود


package J3;


import javax.swing.*;
import java.util.Arrays;
/*
getting number from user with JOption and sorting that
 */
public class EX1 {
    static int[]sorting(int[] array){
        Arrays.sort(array);
        return array;
    }
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null , "enter 5 number ");

        String []str = new String[5];
        for (int i = 0; i < 5; i++) {
            str[i] = JOptionPane.showInputDialog(null, "enter " + i + "th number");
        }
        //casting string to number
        int []num = new int[5];
        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        int[]sortedArray = sorting(num);
        StringBuilder result = new StringBuilder("Sorted numbers:\n");
        for (int number : sortedArray) {
            result.append(number).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());



    }
}
