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
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public void startGame() {
        outputView.printMessage(Message.START);
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize), new MoveLog(bridgeSize));
        play(bridgeGame);
    }

    private void play(BridgeGame bridgeGame) {
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
            String reGame = inputView.readGameCommand();
            if (reGame.equals(CommandType.QUIT.getCommands())) {
                outputView.printResult(bridgeGame, crossBridgeResult);
                return true;
            }
            bridgeGame.retry();
            play(bridgeGame);
        }
        return false;
    }
}
