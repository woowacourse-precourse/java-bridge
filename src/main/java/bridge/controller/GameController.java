package bridge.controller;

import static bridge.model.FinalResult.isFinalSuccess;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void play() {
        // 다리 생성
        outputView.printStartGame();
        Bridge bridge = new Bridge();

        // 다리 게임
        BridgeGame bridgegame = new BridgeGame(bridge);

        bridgegame.move();
        System.out.println(isFinalSuccess());


    }

}
