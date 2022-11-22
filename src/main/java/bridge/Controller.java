package bridge;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void startGame() throws IllegalAccessException {
        outputView.printLabel("다리 건너기 게임을 시작합니다.\n");
        initBridgeGame();
        do {
            if (tryGame()) {
                outputView.printResult(bridgeGame, "성공", bridgeGame.getTryCount());
                break;
            }
            outputView.printResult(bridgeGame,"실패", bridgeGame.getTryCount());
        } while(getRetry());
    }

    private void initBridgeGame() {
        outputView.printLabel("다리의 길이를 입력해주세요.");

        int size = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
    }

    private boolean tryGame() {
        while (true) {
            if (bridgeGame.isSuccess()) {
                return true;
            }
            moveStep();
            if (!bridgeGame.isRightStep()) return false;
        }
    }

    private void moveStep() {
        outputView.printLabel("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String move = inputView.readMoving();
        bridgeGame.move(move);
        outputView.printMap(bridgeGame.getInputBridge(), bridgeGame.getBridge());
    }

    private boolean getRetry() {
        outputView.printLabel("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String command = inputView.readGameCommand();
        if (command.equals("R")) bridgeGame.retry();
        return command.equals("R");
    }
}
