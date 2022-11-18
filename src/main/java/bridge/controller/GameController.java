package bridge.controller;

import static bridge.controller.InputController.setBridgeSize;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void play() {
        // 다리 생성
        outputView.printStartGame();
        List<String> bridge = setBridgeSize();
        System.out.println(bridge);

        // 다리 게임
        BridgeGame bridgegame = new BridgeGame();
        bridgegame.move(bridge);

    }


}
