package bridge;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        try {
            outputView.printStartMessage();
            BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
            loop(bridgeGame);
            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void loop(BridgeGame bridgeGame) {
        while (bridgeGame.keepGoing()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            bridgeGame.setStatus(bridgeGame.calculateStatus());
            if (bridgeGame.getStatus().equals("실패") || bridgeGame.getStatus().equals("성공")) {
                bridgeGame.setNumberOfTry(bridgeGame.getNumberOfTry() + 1);
                if (bridgeGame.getStatus().equals("실패")) bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }
}
