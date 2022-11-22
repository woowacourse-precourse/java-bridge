package bridge;

import java.util.List;

public class BridgeGameController {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String QUIT_MESSAGE = "최종 게임 결과";
    private static final String RETRY_COMMAND = "R";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        printStartMessage();
        BridgeGame bridgeGame = new BridgeGame(initializeBridge());
        crossingBridge(bridgeGame);
        printGameResult(bridgeGame);
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    private void crossingBridge(BridgeGame bridgeGame) {
        while (bridgeGame.isPlaying()) {
            bridgeGame.move(getMoveCommand());
            printBridgeMap(bridgeGame);
        }

        if (bridgeGame.isOver()) {
            retryOrQuit(bridgeGame);
        }
    }

    private void printGameResult(BridgeGame bridgeGame) {
        printQuitMessage();
        outputView.printResult(bridgeGame);
    }

    private void retryOrQuit(BridgeGame bridgeGame) {
        String inputGameCommand = inputView.readGameCommand();
        if (inputGameCommand.equals(RETRY_COMMAND)) {
            bridgeGame.retry();
            crossingBridge(bridgeGame);
        }
    }

    private void printQuitMessage() {
        System.out.println(QUIT_MESSAGE);
    }

    private String getMoveCommand() {
        return inputView.readMoving();
    }

    private void printBridgeMap(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame);
    }

    private List<String> initializeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = inputView.readBridgeSize();

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
