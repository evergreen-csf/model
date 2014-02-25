import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
	
	public UserInput() {
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome! Enter a name:");

		String chosenName = scanner.nextLine();
		System.out.println("You have chosen " + chosenName);
		System.out.println("Welcome! Enter a gender (M/F):");
		String chosenGender = scanner.nextLine();
		System.out.println("You have chosen " + chosenGender);
		BabyName chosenBaby = null;
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("names.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		String line = null;
		do {
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			if (line == null) {
				break;
			}
			String[] tokens = line.split(" ");
			String name = tokens[0];
			String gender = tokens[1];
			List<Integer> rankByDecade = new ArrayList<Integer>();
			BabyName newBaby = new BabyName(name, gender, rankByDecade);
			for (int i = 2; i < tokens.length; i++) {
				rankByDecade.add(Integer.parseInt(tokens[i]));
				System.out.println(tokens[i]);
			}
			if (chosenName.equals(name)) {
				chosenBaby = newBaby;
			}
		} while (line != null);
		
		if (chosenBaby != null) {
			System.out.println("We found our baby!");
			System.out.println(chosenBaby.toString());
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
