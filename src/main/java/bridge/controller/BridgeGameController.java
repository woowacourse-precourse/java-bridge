package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.GameCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(inputView.readBridgeSize(), bridgeMaker);
    }


    public void start() {
        while (true) {
            String movingCommand = inputView.readMoving();
            String sign = bridgeGame.move(movingCommand);
            bridgeGame.getBridgeGameResult().addResult(movingCommand, sign);
            outputView.printMap(bridgeGame.getBridgeGameResult());
            if (!crossingBridge(sign)) {
                break;
            }
//            if (bridgeGame.getBridge().compareLength(bridgeGame.getUser())) {
//                break;
//            }
            if (compareBridgeLength()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getBridgeGameResult(), bridgeGame);
    }

    public boolean crossingBridge(String sign) {
        if (!bridgeGame.getBridgeGameResult().getComparison(sign)) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean compareBridgeLength() {
        return bridgeGame.getBridge().compareLength(bridgeGame.getUser());
    }

    public boolean isRestart(String sign) {
        return GameCommand.fromCommand(sign)
                .getRestart();
    }
}