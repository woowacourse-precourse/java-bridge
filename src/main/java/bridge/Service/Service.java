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
        outputView.printEmpty();
    }

    // 유저 키입력 리스트 초기화 기능
    public void initBridgeUserKeyList() {
        bridgeGame.initBridgeUserKeyList();
    }

    // 다리를 건너는 기능
    public void move() {
        outputView.printInputSpaceToMove();
        Bridge bridge = bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridge);
    }

    // 정답 유무 boolean값으로 반환
    public boolean isAnswer() {
        return bridgeGame.isAnswer();
    }

    // 다리 마지막까지 도달했는지 boolean값 반환
    public boolean isBridgeEnd() {
        return bridgeGame.isBridgeEnd();
    }

    // 다시 게임을 시도할지 물어보는 기능
    public boolean isRetry() {
        outputView.printInputRetry();
        String input = inputView.readGameCommand();
        return bridgeGame.retry(input);
    }

    // 에러메세지 출력 기능
    public void catchError(IllegalArgumentException error) {
        outputView.printErrorMessage(error);
    }

    // 게임 결과 출력
    public void gameResult() {
        outputView.printResultMessage();
        Bridge bridge = bridgeGame.getBridge();
        outputView.printMap(bridge);
        outputView.printResult(bridge);
        outputView.printNumberOfAttempts(bridge);
    }
}
