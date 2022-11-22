package bridge;

public class Application {
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();
    final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        try {
            app();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void app() {
        bridgeGame.StartGame(inputView.readBridgeSize());

        while (bridgeGame.playing()) {
            moveAndPrint();
            if (bridgeGame.isDead()) retryGame();
        }

        outputView.printResult(bridgeGame.isDead(), bridgeGame.getTotalTry());
    }

    public static void moveAndPrint() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getCurStep(), bridgeGame.isDead());
    }

    public static void retryGame() {
        String command = inputView.readGameCommand();
        bridgeGame.retry(command);
        outputView.outputReset(command);
    }
}
