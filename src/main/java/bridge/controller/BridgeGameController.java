package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.CommandType;
import bridge.MovingType;
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
            MovingType movingType = bridgeGame.move(userMove);
            outputView.printMap(bridgeGame.getMoveLog());
            if (bridgeGame.getIndex() == bridgeSize) {
                System.out.println("최종 게임 결과");
                outputView.printMap(bridgeGame.getMoveLog());
                outputView.printResult(movingType, bridgeGame.getTrial());
                break;
            }
            if (movingType.getState().equals("실패")) {
                if (inputView.readGameCommand().equals(CommandType.QUIT.getCommands())) {
                    System.out.println("최종 게임 결과");
                    outputView.printMap(bridgeGame.getMoveLog());
                    outputView.printResult(movingType, bridgeGame.getTrial());
                    break;
                }
                bridgeGame.retry();
                play(bridgeGame, bridgeSize);
            }
        }
    }

}
