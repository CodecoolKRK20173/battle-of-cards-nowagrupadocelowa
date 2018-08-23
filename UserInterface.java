import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserInterface{
    Scanner scanner = new Scanner(System.in);

    public void print(String message){
        System.out.println(message);
    }

    public String input(String question){
        BufferedReader keyboardInput = null;
        try {
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(question);
            String answer = keyboardInput.readLine();
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
    }

    // public int input(int number){
    //     number = scanner.nextInt();
        
    //     return number;
    // }
}