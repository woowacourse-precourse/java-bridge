package bridge.controller;

import static bridge.domain.UpDownBridge.initBridge;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.messages.Message;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static List<String> bridges;
    private static boolean status = true;
    private static int inputSize;
    private static int bridgeLocation = 0;
    private static int count = 1;

    public BridgeGameController() {
        bridgeLocation = 0;
        status = true;
        initBridge();
        runGame();
    }

    public void start() {
        outputView.printStartGame();
        outputView.printInputSize();
        inputSize = inputView.inputBridgeSize();
        bridges = bridgeMaker.makeBridge(inputSize);
        runGame();
        outputView.printResult();
    }

    public static boolean getStatus() {
        return status;
    }

    public static int getCount() {
        return count;
    }

    private static void runGame() {
        while (status && bridgeLocation < inputSize) {
            outputView.printInputDirection();
            String inputDirection = inputView.inputMovingDirection();
            String moveResult = bridgeGame.move(bridges.get(bridgeLocation), inputDirection);
            bridgeGame.retry(moveResult);
            outputView.printMap(inputDirection, moveResult);
            askRestartGame(moveResult);
            bridgeLocation++;
        }
    }

    private static void askRestartGame(String moveResult) {
        if (moveResult.equals(Message.MOVE_FAIL.getMessage())) {
            outputView.printInputRestart();
            String inputRestart = inputView.inputGameRestart();
            selectRestartAndQuit(inputRestart);
        }
    }

    private static void selectRestartAndQuit(String inputRestart) {
        if (inputRestart.equals(Message.RESTART.getMessage())) {
            new BridgeGameController();
            count++;
        }
        if (inputRestart.equals(Message.QUIT.getMessage())) {
            status = false;
        }
    }
}
