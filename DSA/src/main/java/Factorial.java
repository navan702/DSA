import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Factorial to be calculated for ? :");
        int input = sc.nextInt();

        System.out.println( "Factorial : "+ new Factorial().findFactorial(input));
    }

    private int findFactorial(int input) {
        if(input == 0 || input == 1){
            return 1;
        }
        return input * findFactorial(input - 1);
    }
}
