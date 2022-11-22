package bridge;

import java.util.List;

import constants.*;

/**
 * 이동, 재시작, 정답 유무 확인 등의 실행 방법 정의
 */
public class BridgeGame {
    private final List<String> bridge;
    private String bridgeMessage;
    BridgeMessageMaker bridgeMessageMaker;
    GameInfo gameInfo;

    public BridgeGame(List<String> bridge, GameInfo gameInfo) {
        bridgeMessageMaker = new BridgeMessageMaker(bridge);
        this.gameInfo = gameInfo;
        this.bridge = bridge;
    }

    public void makeBridgeMessage(String moving) {
        bridgeMessage = bridgeMessageMaker.makeBridgeMessage(moving, gameInfo.getCurrentPosition());
    }

    public void checkSuccessOrFail(String moving) {
        gameInfo.setSuccessOrFail(checkMoving(moving));
    }

    public void move() {
        if (!gameInfo.getSuccessOrFail()) {
            gameInfo.setGameRound(Constants.RETRY);
            return;
        }
        gameInfo.setGameRound(Constants.CONTINUE);
        isCorrectMoving();
    }

    private void isCorrectMoving() {
        gameInfo.setCurrentPosition(gameInfo.getCurrentPosition() + 1);
        if (gameInfo.getCurrentPosition() == bridge.size()) {
            gameInfo.setSuccessOrFail(true);
            gameInfo.setGameRound(Constants.GAMEOVER);
        }
    }

    public void retry(String gameCommand) {
        if (gameCommand.equals(Constants.RESTART)) {
            gameInfo.setTrialCount(gameInfo.getTrialCount() + 1);
            gameInfo.setCurrentPosition(0);
            return;
        }
        gameInfo.setGameRound(Constants.GAMEOVER);
    }

    private boolean checkMoving(String moving) {
        return moving.equals(bridge.get(gameInfo.getCurrentPosition()));
    }

    public String getBridgeMessage() {
        return bridgeMessage;
    }
}
