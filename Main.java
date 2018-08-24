public class Main {
    Game game;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.startGame();
    }

    private Main() throws InterruptedException {
        game = new Game();
        new UserInterface();
    }

    public void startGame() throws InterruptedException {
        // boolean end_of_game = false;
        // while(end_of_game != true){
        //     game.playGame();
        // }
        game.playGame();
    }
}