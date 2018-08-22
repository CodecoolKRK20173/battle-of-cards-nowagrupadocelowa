public class Main {
    Game game = new Game();
    PreparePlayers preparePlayer = new PreparePlayers();

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();
    }

    public void startGame(){
        PreparePlayers.preparePlayer();
        game.playGame();
    }
}