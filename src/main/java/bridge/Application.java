package bridge;

public class Application {

    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        try {
            gameLauncher.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
