package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameLauncher bridgeGameLauncher = new BridgeGameLauncher();

            bridgeGameLauncher.game();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}