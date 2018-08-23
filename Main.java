public class Main {
    Game game;

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();
    }

    private Main(){
        game = new Game();
        new UserInterface();
    }

    public void startGame(){
        // boolean end_of_game = false;
        // while(end_of_game != true){
        //     game.playGame();
        // }
        game.playGame();
    }
}