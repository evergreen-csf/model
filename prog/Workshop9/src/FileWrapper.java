import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileWrapper {

    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File("names.txt"));
            int lineCount = input.nextInt();
            System.out.println("We will try to read " + lineCount + " lines.");
            String[] lines = new String[lineCount];
            for (int i = 0; i < lineCount; i++) {
            	lines[i] = input.nextLine();
            }
            Arrays.sort(lines);
            for (int i = 0; i < lineCount; i++) {
            	System.out.println(lines[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("You must copy names.txt to this directory" +
                               " before running the testing program.");
            e.printStackTrace();
            System.exit(1);
        }
        
    }

}
