package bridge;

public class BridgeGameManager {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    private BridgeGame bridgeGame = new BridgeGame();
    private InputView inputView = new InputView();

    public void BridgeGameManager() {

    }

    public void GameStart() {
        System.out.println(START_MESSAGE + "\n");
        inputView.readBridgeSize();
    }
}
