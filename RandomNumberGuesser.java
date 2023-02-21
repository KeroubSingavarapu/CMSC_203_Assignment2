import java.util.Scanner;

public class RandomNumberGuesser extends RNG {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		int minGuess = 0, maxGuess =100, rN, guesses, userInput;
		String choice;

		do {

			rN = RNG.rand();

			minGuess = 0;

			maxGuess = 100;

			guesses = 0;

			System.out.println("Enter your first guess ");

			userInput = input.nextInt();

			while(userInput < minGuess || guesses > maxGuess) {
				RNG.inputValidation(userInput, minGuess, maxGuess);
				userInput = input.nextInt();
			}
			if(userInput >= minGuess && guesses <= maxGuess) {
				RNG.inputValidation(userInput, minGuess, maxGuess);
			}
			
			guesses++;

			while(userInput != rN) {
				System.out.println("Number of guesses is: " + guesses);
				if(guesses == 7) {
					System.out.println("Your trial is over");
					break;
				}
				if(userInput > rN) {
					System.out.println("Your guess is too high");
					maxGuess = userInput; }
				else if(userInput < rN) {
					System.out.println("Your guess is too low");
					minGuess = userInput;
				}

				System.out.println("Enter the next guess between " + minGuess + " and " + maxGuess);

				userInput = input.nextInt();

				while(userInput < minGuess || userInput > maxGuess) {
					RNG.inputValidation(userInput, minGuess, maxGuess);
					userInput = input.nextInt();
				}

				if(userInput >= minGuess && userInput <= maxGuess) {
					RNG.inputValidation(userInput, minGuess, maxGuess);
				}
				guesses++;
			}

			if(userInput == rN) {
				System.out.println("Congratulations! You guessed the number correctly!");
			}

			input.nextLine();

			System.out.println("Try again? (yes/no)");

			choice = input.nextLine();

		} while(choice.equalsIgnoreCase("yes"));
		
		System.out.println("Thanks for playing!");
	}
}