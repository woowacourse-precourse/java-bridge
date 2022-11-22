package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.service.BridgeGame;
import bridge.model.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    // view 에서 입력받은 값을 model로 전달하는 컨트롤러
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        int bridgeSize = inputView.readBridgeSize();

        doGame(bridgeSize);
    }

    private void doGame(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        for (int i = 0; i < bridgeSize; i++) {
            String moveAnswer = inputView.readMoving();
        }
    }

    private void endGame() {

    }
}
