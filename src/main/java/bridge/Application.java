package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            MainGame mainGame = new MainGame();
            mainGame.startRound();
            mainGame.playRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
