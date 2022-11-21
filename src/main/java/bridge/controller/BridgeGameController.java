package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.CommandType;
import bridge.ResultType;
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
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge, new MoveLog(bridgeSize));
        play(bridgeGame, bridgeSize);
    }

    public void play(BridgeGame bridgeGame, int bridgeSize) {
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
                play(bridgeGame, bridgeSize);
            }
            if (bridgeGame.getIndex() == bridgeSize) {
                outputView.printResult(bridgeGame, resultType);
                break;
            }
        }
    }

}
