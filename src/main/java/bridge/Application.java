package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameService gameService = new BridgeGameService();
        gameService.init();
        gameService.start();
    }
}
