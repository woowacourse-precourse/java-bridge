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
import java.util.List;

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

    public void play(BridgeGame bridgeGame) {
        while (true) {
            String userMove = inputView.readMoving();
            ResultType resultType = bridgeGame.move(userMove);
            outputView.printMap(bridgeGame.getMoveLog());
            if (resultType.getState().equals(ResultType.FAIL.getState())) {
                if (inputView.readGameCommand().equals(CommandType.QUIT.getCommands())) {
                    outputView.printResult(bridgeGame, resultType);
                    break;
                }
                bridgeGame.retry();
                play(bridgeGame);
            }
            if (bridgeGame.getIndex() == bridgeGame.getBridgeSize()) {
                outputView.printResult(bridgeGame, resultType);
                break;
            }
        }
    }

}
