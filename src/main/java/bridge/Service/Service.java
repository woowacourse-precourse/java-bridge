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

    // 게임 초기화 기능
    public void initGame() {
        do {
            try {
                createBridge();
                break;
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
            }
        } while (true);
    }

    // 다리 만드는 기능
    private void createBridge() {
        outputView.printInputBridgeSize();
        bridgeGame.createBridge(inputView.readBridgeSize());
    }
}
