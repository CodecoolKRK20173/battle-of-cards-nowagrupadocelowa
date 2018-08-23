public class Main {
    Game game = new Game();

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();
    }

    public void startGame(){
        // boolean end_of_game = false;
        // while(end_of_game != true){
        //     game.playGame();
        // }
        game.playGame();
    }
}