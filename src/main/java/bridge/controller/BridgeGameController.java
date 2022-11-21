package bridge.controller;

import bridge.constant.Result;
import bridge.constant.RetryCode;
import bridge.model.BridgeGame;
import view.input.InputView;
import view.output.OutputView;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final BridgeGame bridgeGame = new BridgeGame();
    private static int bridgeSize;
    private static int recursiveCount = 1;

    public void run(){
        getBridgeSize();
        cross();
    }

    public void getBridgeSize() {
        outputView.printStartMessage();
        bridgeSize = inputView.readBridgeSize();
        bridgeGame.createBridge(bridgeSize);
    }

    public void cross() {
        outputView.bridgeInit();
        for(int index = 0; index < bridgeSize; index++) {
            System.out.println(index);
            getBridgeToCross(index);
        }
        printResult();
    }


    public void getBridgeToCross(int index) {
        String crossToBridge = inputView.readMoving();
        boolean isAvailableMoving = bridgeGame.move(index, crossToBridge);
        outputView.printMap(isAvailableMoving, (index == 0), crossToBridge);
        if (!isAvailableMoving) {
            getRetryCode();
        }
    }

    public void getRetryCode() {
        String command = inputView.readGameCommand();

        if (command.equals(RetryCode.RETRY.getRetryCode())){
            recursiveCount += 1;
            cross();
        }
        if (command.equals(RetryCode.QUIT.getRetryCode())) {
            outputView.printResult(recursiveCount, Result.FAIL.getResult());
        }
    }

    public void printResult() {
        outputView.printResult(recursiveCount, Result.SUCCESS.getResult());
    }
}
