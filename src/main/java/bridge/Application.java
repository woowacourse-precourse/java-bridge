package bridge;

public class Application {

    public static InputView inputView = new InputView();
    public static BridgeGame bridgeGame = new BridgeGame();
    public static OutputView outputView = new OutputView();
    public static String movingResult;
    public static boolean stopFlag = false;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeGame.startGame(inputView.readBridgeSize());
        crossTheBridge();
        outputView.printResult(bridgeGame.getGameData(), bridgeGame.checkGameResult());
    }

    public static void crossTheBridge() {
        while (!bridgeGame.checkArrive() && !stopFlag) {
            movingResult = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getGameData());
            if (movingResult.equals("X")) {
                stopFlag = bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }
}