package controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private static final boolean SUCCESS = true;
    private static final boolean FAIL = false;

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private int bridgeLengthIndex = 0, gameAttempts = 1;
    private String rOrQ = "";
    private boolean success = SUCCESS;

    public Controller(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        play();
    }

    private void play() {
        List<String> bridge = bridgeInit();
        while (bridgeLengthIndex < bridge.size()) {
            printResult(bridge);
            checkFailure();
            if (checkQuit()) break;
            checkRetry();
        }
        checkResult();
    }

    private void checkResult() {
        if (success) outputView.printResult(SUCCESS, gameAttempts);
        if (!success) outputView.printResult(FAIL, gameAttempts);
    }

    private void checkRetry() {
        if (bridgeGame.retry(rOrQ)) {
            gameAttempts += 1;
            bridgeLengthIndex = 0;
            outputView.upOutputBoard.clear();
            outputView.downOutputBoard.clear();
            rOrQ = "";
        }
    }

    private boolean checkQuit() {
        if (bridgeGame.quit(rOrQ)) {
            success = FAIL;
            rOrQ = "";
            return true;
        }
        return false;
    }

    private void checkFailure() {
        if (outputView.upOutputBoard.contains("X") || outputView.downOutputBoard.contains("X"))
            rOrQ = inputView.readGameCommand();
    }

    private void printResult(List<String> bridge) {
        outputView.printMap(bridgeLengthIndex, inputView.readMoving(), bridge);
        bridgeLengthIndex += 1;
    }

    private List<String> bridgeInit() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return bridge;
    }
}
