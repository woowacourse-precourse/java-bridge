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
        createBridge();
    }

    // 다리 만드는 기능
    private void createBridge() {
        outputView.printInputBridgeSize();
        bridgeGame.createBridge(inputView.readBridgeSize());
    }

    // 유저 키입력 리스트 초기화 기능
    public void initBridgeUserKeyList() {
        bridgeGame.initBridgeUserKeyList();
    }

    // 다리를 건너는 기능
    public void move() {
        outputView.printInputSpaceToMove();
        Bridge bridge = bridgeGame.move(inputView.readMoving());
        outputView.printBridge(bridge);
    }

    // 다시 게임을 시도할지 물어보는 기능
    public boolean retry() {
        do {
            try {
                outputView.printInputRetry();
                String input = inputView.readGameCommand();
                return getRetry(input);
            } catch (IllegalArgumentException error) {
                outputView.printErrorMessage(error);
            }
        } while (true);
    }


    // retry boolean값 가져오는 기능
    private boolean getRetry(String input) {
        if (bridgeGame.retry(input)) {
            return true;
        }
        return false;
    }

    // 에러메세지 출력 기능
    public void catchError(IllegalArgumentException error) {
        outputView.printErrorMessage(error);
    }
}
