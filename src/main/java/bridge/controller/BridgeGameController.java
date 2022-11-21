package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.type.CommandType;
import bridge.type.ResultType;
import bridge.MoveLog;
import bridge.util.Message;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public void run() {
        outputView.printMessage(Message.START);
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize), new MoveLog(bridgeSize));
        playBridgeGame(bridgeGame);
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        while (true) {
            String userMove = inputView.readMoving();
            ResultType crossBridgeResult = bridgeGame.move(userMove);
            outputView.printMap(bridgeGame.getMoveLog());
            if (isGameFinshed(bridgeGame, crossBridgeResult)) {
                break;
            }
        }
    }

    private boolean isGameFinshed(BridgeGame bridgeGame, ResultType crossBridgeResult) {
        if (bridgeGame.getIndex() == bridgeGame.getBridgeSize()) {
            outputView.printResult(bridgeGame, crossBridgeResult);
            return true;
        }
        if (crossBridgeResult.getState().equals(ResultType.FAIL.getState())) {
            return isGivedUp(bridgeGame, crossBridgeResult);
        }
        return false;
    }

    private boolean isGivedUp(BridgeGame bridgeGame, ResultType crossBridgeResult) {
        String userAnswer = inputView.readGameCommand();
        if (userAnswer.equals(CommandType.QUIT.getCommands())) {
            outputView.printResult(bridgeGame, crossBridgeResult);
            return true;
        }
        bridgeGame.retry();
        return false;
    }
}