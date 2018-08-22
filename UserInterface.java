public class UserInterface{
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
            System.out.println(e);
        }
            return null;
    }
}