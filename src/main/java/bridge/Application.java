package bridge;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        bridgeGame.start(inputView.readBridgeSize());
        while (!bridgeGame.checkSuccess()) {
            outputView.printMap(bridgeGame.move(inputView.readMoving()));
            if (!checkRetry()) {
                return;
            }
        }
        outputView.printResult(bridgeGame.generateResultMap(), true, bridgeGame.getAttempts());
    }

    private static boolean checkRetry() {
        if (bridgeGame.checkFail()) {
            if (!bridgeGame.retry(inputView.readGameCommand())){
                outputView.printResult(bridgeGame.generateResultMap(), false, bridgeGame.getAttempts());
                return false;
            }
        }
        return true;
    }
}
