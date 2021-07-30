package methodsExercises;
import java.util.*;

public class FirstCharCapital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter any text: ");
        String userInput = sc.nextLine();

        System.out.println(firstCharToTitleCase(userInput));
    }

    public static String firstCharToTitleCase(String string) {
        StringBuilder output = new StringBuilder();
        
        String[] words = string.split(" ");

        for(String word : words) {
            boolean firstOne = true;
            for (char c : word.toCharArray()) {
                if (firstOne && String.valueOf(c).matches("\\w")) {
                    output.append(String.valueOf(c).toUpperCase());
                    firstOne = false;
                } else {
                    output.append(String.valueOf(c).toLowerCase());
                }
            }
            output.append(" ");
        }
        return output.toString();
    }
}