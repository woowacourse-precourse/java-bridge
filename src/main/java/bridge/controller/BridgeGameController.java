package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.GameCommand;
import bridge.exception.ExceptionHandler;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final InputView inputView;
    private final OutputView outputView;
    private final ExceptionHandler exceptionHandler;

    public BridgeGameController(InputView inputView, OutputView outputView, ExceptionHandler exceptionHandler) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.exceptionHandler = exceptionHandler;
    }

    public void start() {
        printStartMessage();

        BridgeGame bridgeGame = new BridgeGame(makeBridge());

        run(bridgeGame);

        outputView.printResult(bridgeGame);
    }

    private static void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    private List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Integer bridgeSize = exceptionHandler.handleAndRetry(inputView::readBridgeSize);
        return bridgeMaker.makeBridge(bridgeSize);
    }


    private void run(BridgeGame bridgeGame) {
        while (bridgeGame.isNormal()) {
            move(bridgeGame);
        }

        if (bridgeGame.isGameOver()) {
            retryOrQuit(bridgeGame);
        }
    }

    private void move(BridgeGame bridgeGame) {
        bridgeGame.move(exceptionHandler.handleAndRetry((inputView::readMoving)));
        outputView.printMap(bridgeGame);
    }

    private void retryOrQuit(BridgeGame bridgeGame) {
        GameCommand gameCommand = exceptionHandler.handleAndRetry(inputView::readGameCommand);
        if (gameCommand == GameCommand.RETRY) {
            bridgeGame.retry();
            run(bridgeGame);
        }
    }
}
