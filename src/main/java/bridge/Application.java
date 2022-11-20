package bridge;
import bridge.service.GameLauncher;

public class Application {
    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.run();
    }
}
