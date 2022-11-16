package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {

    private static final String GAME_START_SENTENCE = "다리 건너기 게임을 시작합니다.";

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        System.out.println(GAME_START_SENTENCE);
        int bridgeSize = inputView.readBridgeSize();
        System.out.println("bridgeSize = " + bridgeSize);

    }
}
