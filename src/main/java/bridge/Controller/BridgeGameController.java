package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.message.Error;
import bridge.message.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView;
    OutputView outputView;
    private boolean isSuccess;

    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";


    public BridgeGameController() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        isSuccess = true;
    }

    public void playGame() {
        outputView.printGameStart();
        List<String> bridge = makeAnswerBridge();
        pickMovingDirection(bridge);
        outputView.printResult(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
        System.out.print(Message.GAME_SUCCESS_OR_FAILURE);
        showWhetherGameSuccess();
        showTryCount();
    }

    private void showTryCount() {
        System.out.print(Message.TRY_COUNT);
        System.out.println(bridgeGame.getTryCount());
    }

    private void showWhetherGameSuccess() {
        if (isSuccess) {
            System.out.println(SUCCESS);
        }
        if (!isSuccess) {
            System.out.println(FAILURE);
        }
    }

    private String userCorrectDirection() {
        do {
            try {
                String moving = inputView.readMoving();
                return moving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private String userCorrectRetryInput() {
        do {
            try {
                String retry = inputView.readGameCommand();
                return retry;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private void pickMovingDirection(List<String> bridge) {
        while (bridgeGame.getUpperBridge().size() < bridge.size()) {
            String direction = userCorrectDirection();
            if (!bridgeGame.move(direction)) {
                outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
                String retryInput = userCorrectRetryInput();
                if (isRetry(retryInput)) continue;
                if (isQuit(retryInput)) break;
            }
            prepareNextInput();
        }
    }

    private void prepareNextInput() {
        outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
        bridgeGame.increaseBridgeIndex();
    }

    private List<String> makeAnswerBridge() {
        do {
            try {
                int size = inputView.readBridgeSize();
                bridgeGame.setAnswerBridge(bridgeMaker.makeBridge(size));
                List<String> bridge = bridgeGame.getAnswerBridge();
                return bridge;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    private boolean isRetry(String retryFlag) {
        if (retryFlag.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private boolean isQuit(String retryFlag) {
        if (retryFlag.equals("Q")) {
            isSuccess = false;
            return true;
        }
        return false;
    }
}
