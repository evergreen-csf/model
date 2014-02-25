import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
	
	static BabyName readFile() throws IOException, FileNotFoundException {

		BufferedReader reader;
		reader = new BufferedReader(new FileReader("names.txt"));

		String line = null;
		
		// TODO: Write a do / while loop containing the following statements, while
		// TODO: the variable line is not equal to null.
		
			line = reader.readLine();
			
			// TODO: Define a String array called tokens that is to be split by whitespaces
			
			// The first two items on a line from the file are a name and a gender
			String name = tokens[0];
			String gender = tokens[1];
			
			// Creates a list of Integers to store the ranks by decade
			List<Integer> rankByDecade = new ArrayList<Integer>();

			// TODO Loop over the items in the tokens array, starting with i = 2
			// TODO with the following loop body
			
				rankByDecade.add(Integer.parseInt(tokens[i]));
				System.out.println(tokens[i]);

			// 
			if (chosenName.equals(name)) {
				chosenBaby = newBaby;
			}

			// TODO: Create a new BabyName object passing the variables name, gender, and rankByDecade as params
			// TODO:
			
		
		
		reader.close();
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome! Enter a name:");

		String chosenName = scanner.nextLine();
		
		
		System.out.println("You have chosen " + chosenName);
		System.out.println("Welcome! Enter a gender (M/F):");
		
		
		
		String chosenGender = scanner.nextLine();
		System.out.println("You have chosen " + chosenGender);
		
		// TODO: Call the method readFile with the correct parameters
		// TODO: Store its return value in a variable called chosenBaby, of type BabyName
		BabyName chosenBaby = readFile();
		// TODO: If chosenBaby is not equal to null, print it out using its toString method
		
		if (chosenBaby != null){
			System.out.println(chosenBaby.toString());
		}
		
	}
	
}
