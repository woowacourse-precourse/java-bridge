package bridge;

public class Controller {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    public void startGame() throws IllegalAccessException {
        do {
            // 크기 입력 받기
            // for문으로 다리 건너기
        } while (getRetry());
    }

    private boolean getRetry() throws IllegalAccessException {
        String command = inputView.readGameCommand();
        return command.equals("R");
    }
}
