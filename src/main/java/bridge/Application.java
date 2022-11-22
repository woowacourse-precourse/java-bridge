package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            PlayGame playGame = new PlayGame();
            playGame.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
