package InClassProgram.one_1404_07_14;

import javax.swing.*;
import java.util.Arrays;
/*
getting number from user with JOption and sorting that
 */
public class EX2 {
    static int[]sorting(int[] array){
////        int temp = array[0];
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }
//
//        return array;
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
