package bridge;

public class Application {
    final static BridgeGame bridgeGame = new BridgeGame();
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();


    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");

        try {
            app();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void app() {
        bridgeGame.makeGame(inputView.readBridgeSize());

        while (bridgeGame.playing()) {
            moveAndPrint();
            if (bridgeGame.getDeath()) retryAndReset();
        }
        
        outputView.printResult(bridgeGame.getDeath(), bridgeGame.getTryCount());
    }

    public static void moveAndPrint() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getCurStep(), bridgeGame.getDeath());
    }

    public static void retryAndReset() {
        String command = inputView.readGameCommand();
        bridgeGame.retry(command);
        outputView.outputReset(command);
    }
}
