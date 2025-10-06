
/*
getting even number in array in range 10 - 100
 */
package InClassProgram;

public class EX1 {
    public static void main(String[] args) {
        int[] evenArray = new int[45];
        for(int i = 10 , j = 0; i < 100 ; i++){
            if(i % 2 == 0){
                evenArray[j] = i;
                j++;
            }
        }
        for (int j : evenArray) {
            System.out.print(j + " ");
        }
    }
}
