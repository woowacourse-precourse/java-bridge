package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void play() {
        printStartMessage();
        BridgeGame bridgeGame = new BridgeGame(initializeBridge());
        crossingBridge(bridgeGame);
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    private void crossingBridge(BridgeGame bridgeGame) {
        while (!bridgeGame.isOver()) {
            bridgeGame.move(getMoveCommand());
            printBridgeMap(bridgeGame);
        }
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
