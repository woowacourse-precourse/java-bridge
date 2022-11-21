package bridge.controller;

import bridge.BridgeMaker;
import bridge.model.Bridge;
import bridge.model.Direction;
import bridge.model.GameCondition;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public static final int RANGE_START = 3;
    public static final int RANGE_END = 20;
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void execute() {
        OutputView.printMessage(START_MESSAGE);
        BridgeGame bridgeGame = getValidBridgeGame();
        while (isContinue(bridgeGame))
            ;
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getPlayer());
    }

    private BridgeGame getValidBridgeGame() {
        while (true) {
            try {
                return generateBridgeGame();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BridgeGame generateBridgeGame() {
        int size = inputView.readBridgeSize();
        Bridge bridge = generateBridge(size);
        return new BridgeGame(bridge);
    }

    private Bridge generateBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(bridge);
    }

    private boolean isContinue(BridgeGame bridgeGame) {
        try {
            return canMove(bridgeGame);
        } catch (IllegalStateException e) {
            return tryAgain(bridgeGame);
        }
    }

    private boolean canMove(BridgeGame bridgeGame) {
        Direction direction = inputView.readMoving();
        boolean result = bridgeGame.move(direction);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        return result;
    }

    private boolean tryAgain(BridgeGame bridgeGame) {
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
        GameCondition condition = inputView.readGameCommand();
        return bridgeGame.retry(condition);
    }

}
