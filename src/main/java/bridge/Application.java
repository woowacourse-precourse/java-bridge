package bridge;

public class Application {

    public static void main(String[] args) {

        BridgeGame bridgeGame = new BridgeGame();
        BridgeFactory bridgeFactory = new BridgeFactory();
        BridgeGameEngine bridgeGameEngine = new BridgeGameEngine(bridgeGame, bridgeFactory);

        printGameStart();

        bridgeGameEngine.playGame();
    }

    private static void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다");
    }
}
