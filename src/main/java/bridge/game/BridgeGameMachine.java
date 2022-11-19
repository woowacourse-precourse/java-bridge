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
        int result = Result.CONTINUE.getStatus();
        while (result == Result.CONTINUE.getStatus()) {
            result = moveOnce();
        }
        if (result == Result.SUCCESS.getStatus()) {
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

    public int moveOnce() {
        totalView.out().enterMove();
        bridgeGame.move(totalView.in().reReadMovingWhenError());
        totalView.out().printMap(bridgeGame.showCurrentResult());
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
