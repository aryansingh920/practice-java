import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random rand = new Random();
            
            int randomNumber = rand.nextInt(100) + 1;
            
            System.out.println(randomNumber);
            
            System.out.println("Enter your guess 1-100 : ");
            String inpuString = scanner.next();
            int playerGuess = Integer.parseInt(inpuString);

            //for string : scanner.nextLine();
            // for first white line scanner.next()
            // scanner.nextFloat();
            
            
            if (playerGuess == randomNumber) {
                System.out.println("Correct");
            } else if (randomNumber > playerGuess) {
                System.out.println("The number is higher");
            } else {
                System.out.println("Number is lower");
            }
        }
    }
}
