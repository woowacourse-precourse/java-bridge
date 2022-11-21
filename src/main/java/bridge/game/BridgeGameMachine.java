package bridge.game;

import bridge.view.TotalView;

public class BridgeGameMachine {
    private final TotalView totalView = new TotalView();
    private final GameCharacter gameCharacter = new GameCharacter();
    private final String RETRY = "R";
    private BridgeGame bridgeGame;

    public void turnOn() {
        totalView.out().start();
    }

    public void setGame() {
        totalView.out().enterBridgeSize();
        int bridgeSize = totalView.in().reReadBridgeSizeWhenError();
        bridgeGame = new BridgeGame(gameCharacter, bridgeSize);
    }

    public void playGame() {
        bridgeGame.addTotalTry();
        Result result = Result.CONTINUE;
        while (result == Result.CONTINUE) {
            result = moveOnce();
            totalView.out().printMap(bridgeGame.showCurrentMap());
        }
        if (result == Result.SUCCESS) {
            bridgeGame.success();
        }
    }

    public boolean isGameSuccess() {
        return bridgeGame.isSuccess();
    }

    public void retryGame() {
        bridgeGame.retry();
        playGame();
    }

    public Result moveOnce() {
        totalView.out().enterMove();
        String moveInput = totalView.in().reReadMovingWhenError();
        bridgeGame.moveCycle(moveInput);
        return bridgeGame.moveResult();
    }

    public boolean wantRetry() {
        totalView.out().enterGameCommand();
        if (totalView.in().reReadGameCommandWhenError().equals(RETRY)) {
            return true;
        }
        return false;
    }

    public void printResult() {
        totalView.out().printResult(bridgeGame);
    }
}
