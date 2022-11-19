package bridge.controller;

import static bridge.domain.UpDownBridge.initBridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.Message;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static List<String> bridges;
    private static int inputSize;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static boolean status = true;
    private static int bridgeLocation = 0;
    private static int count = 1;

    public void start() {
        System.out.println(Message.START_GAME.getMessage());
        inputSize = inputView.inputBridgeSize();
        bridges = bridgeMaker.makeBridge(inputSize);
        System.out.println(bridges);
        setGame();
        outputView.printResult();
    }

    private static void setGame() {
        while (status && bridgeLocation < inputSize) {
            String inputDirection = inputView.inputMovingDirection();
            String moveResult = bridgeGame.move(bridges.get(bridgeLocation), inputDirection);
            setCurrentState(moveResult);
            outputView.printMap(inputDirection, moveResult);
            bridgeGame.retry(moveResult);
            bridgeLocation++;
        }
    }

    private static void setCurrentState(String moveResult) {
        if (moveResult.equals(Message.MOVE_FAIL.getMessage())) {
            status = false;
        } else if (moveResult.equals(Message.MOVE_SUCCESS.getMessage())) {
            status = true;
        }
    }

    public static void restartGame() {
        bridgeLocation = 0;
        count++;
        initBridge();
        status = true;
        setGame();
    }

    public static boolean getStatus() {
        return status;
    }

    public static int getCount() {
        return count;
    }
}
