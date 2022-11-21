package bridge.controller;

import bridge.combinator.BridgeCombinator;
import bridge.constant.ResultState;
import bridge.model.BridgeGame;
import view.input.InputView;
import bridge.combinator.BridgeCase;
import view.output.OutputView;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeCombinator bridgeCombinator = new BridgeCombinator();

    private static BridgeGame bridgeGame;
    private static int bridgeSize;


    public void start() {
        outputView.printStartMessage();
        bridgeGame = new BridgeGame(getBridgeSize());
        run();
    }

    public void run() {   // ** refactoring
        bridgeInit();

        for (int index = 0; index < bridgeSize; index++) {
            BridgeCase bridgeCase = bridgeGame.move(getBridgeToMove(), index);
            sendBridgeShape(bridgeCase);
            if (!bridgeCase.isAnswer()) {
                handlingWrongAnswer(); return;
            }
        }
        sendResult(ResultState.SUCCESS);
    }

    public void bridgeInit() {
        bridgeCombinator.bridgeInit();
    }

    public int getBridgeSize() {
        bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    public String getBridgeToMove() {
        return inputView.readMoving();
    }

    public String getRetryCode() {
        return inputView.readGameCommand();
    }

    public void handlingWrongAnswer() {
        if (bridgeGame.retry(getRetryCode())) {
            run();
            return;
        }
        sendResult(ResultState.FAIL);
    }

    public void sendBridgeShape(BridgeCase bridgeCase) {
        bridgeCombinator.drawBridge(bridgeCase);
        outputView.printMap(bridgeCombinator.combineBridge());
    }

    public void sendResult(ResultState resultState) {
        outputView.printResult(bridgeCombinator.combineBridge());
        outputView.printStatistic(bridgeGame.getCount(), resultState.getResult());
    }
}