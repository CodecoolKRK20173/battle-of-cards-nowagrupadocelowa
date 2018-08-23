import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInterface{
    public static UserInterface SINGLETON = null;

    public UserInterface(){
        if (SINGLETON == null){
            SINGLETON = this;
        }
    }

    public void print(String message){
        System.out.print(message);
    }
    
    public void println(String message){
        System.out.println(message);
    }

    public void printCentered(String message, int width){
        print(center(message, width));
    }

    public void printlnCentered(String message, int width){
        println(center(message, width));
    }

    public String input(String question){
        BufferedReader keyboardInput = null;
        try {
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            println(question);
            String answer = keyboardInput.readLine();
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String center(String string, int width){
        int padSize = width - string.length();
        int padStart = string.length() + (padSize / 2);

        string = String.format("%" + padStart + "s", string);
        string = String.format("%-" + width + "s", string);

        return string;
    }

    public String generateLine(String fill, int width){
        StringBuilder lineBuilder = new StringBuilder();

        for (int i=0; i<width; i++){
            lineBuilder.append(fill);
        }

        return lineBuilder.toString();
    }
}