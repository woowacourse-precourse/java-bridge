package bridge.Service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Service {

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public Service() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    // 게임 시작 메세지 출력 기능
    public void welcomeGame() {
        outputView.printWelcomeMessage();
    }
}
