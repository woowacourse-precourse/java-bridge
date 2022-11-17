package bridge;

import bridge.view.InputView;

public class GameManager {

    private GameManager() {

    }

    public static void execute() {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }

    private void startGame() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeRandomNumberGenerator());
        int tryCount = 0;
        GameCommand gameCommand;

        while (true) {
            gameCommand = play(bridgeGame);
            if (gameCommand.isFinish()) {
                // TODO: 결과 출력
                break;
            }
            if (gameCommand.isRetry()) {
                bridgeGame.retry();
            }
        }
    }

    private GameCommand play(BridgeGame bridgeGame) {
        try {
            bridgeGame.move(InputView.readMoving());
            if (bridgeGame.isFinish()) {
                return GameCommand.FINISH;
            }
        } catch (IllegalArgumentException e) {
            return getUserDecision();
        }

        return GameCommand.PROGRESS;
    }

    private GameCommand getUserDecision() {
        String input = InputView.readGameCommand();
        GameCommand.checkStatus(input);

        return GameCommand.getStatus(input);
    }

}
