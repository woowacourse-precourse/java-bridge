package bridge.Controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Message.Message;
import bridge.View.InputView;
import bridge.View.OutputView;

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

    public void playGame() throws IllegalArgumentException {
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

    private void pickMovingDirection(List<String> bridge) {
        while (bridgeGame.getTryCount() < bridge.size()) {
            if (bridgeGame.move(inputView.readMoving()) == false) {
                outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
                String retryFlag = inputView.readGameCommand();
                if (isQuit(retryFlag)) break;
                if (isRetry(retryFlag)) continue;
            }
            outputView.printMap(bridgeGame.getUpperBridge(), bridgeGame.getLowerBridge());
            bridgeGame.increaseBridgeIndex();
        }
    }

    private List<String> makeAnswerBridge() throws IllegalArgumentException {
        bridgeGame.setAnswerBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        List<String> bridge = bridgeGame.getAnswerBridge();
        return bridge;
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
