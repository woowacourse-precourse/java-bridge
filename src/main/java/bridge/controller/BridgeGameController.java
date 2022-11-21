package bridge.controller;

import static bridge.domain.UpDownBridge.initBridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
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
        System.out.println(Message.START_GAME.getMessage());
        System.out.println(Message.INPUT_SIZE.getMessage());
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
            System.out.println(Message.SELECT_DIRECTION.getMessage());
            String inputDirection = inputView.inputMovingDirection();
            String moveResult = bridgeGame.move(bridges.get(bridgeLocation), inputDirection);
            setCurrentState(moveResult);
            outputView.printMap(inputDirection, moveResult);
            restartGame(moveResult);
            bridgeLocation++;
        }
    }

    private static void restartGame(String moveResult) {
        if (moveResult.equals("X")) {
            System.out.println(Message.ASK_RESTART.getMessage());
            String input = inputView.inputGameRestart();
            if (input.equals(Message.RESTART.getMessage())) {
                bridgeGame.retry();
                count++;
            }
        }
    }

    private static void setCurrentState(String moveResult) {
        if (moveResult.equals(Message.MOVE_FAIL.getMessage())) {
            status = false;
        } else if (moveResult.equals(Message.MOVE_SUCCESS.getMessage())) {
            status = true;
        }
    }
}
