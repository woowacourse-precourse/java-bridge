package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.combinator.BridgeCombinator;
import bridge.constant.ResultState;
import bridge.model.BridgeGame;
import view.input.InputView;
import bridge.combinator.BridgeCase;
import view.output.OutputView;

public class BridgeGameController {
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeCombinator bridgeCombinator = new BridgeCombinator();

    private static BridgeGame bridgeGame;
    private static int bridgeSize;


    public void start() {
        outputView.printStartMessage();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()), 0);
        run();
    }

    public void run() {
        bridgeInit();
        move();
    }

    public void bridgeInit() {
        bridgeCombinator.bridgeInit();
    }

    public void move() {
        for (int index = 0; index < bridgeSize; index++) {
            BridgeCase bridgeCase = bridgeGame.move(getBridgeToMove(), index);
            sendBridgeShape(bridgeCase);
            if (!bridgeCase.isAnswer()) {
                handlingWrongAnswer(); return;
            }
        }
        sendResult(ResultState.SUCCESS);
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