package bridge;

import bridge.controller.BridgeGameController;

import static bridge.model.GameStatus.QUIT;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeGameController bridgeGameController;
    public BridgeGame(){
        bridgeGameController = new BridgeGameController();
    }
    public void move() {
        while(!bridgeGameController.isSuccess() || !bridgeGameController.isPaused()){
            bridgeGameController.moveAStep();
        }
    }

    public void retry() {
        bridgeGameController.resetGame();
    }

    public void stop(){
        bridgeGameController.concludeGame();
    }

    public boolean isGameDone(){
        return bridgeGameController.isSuccess();
    }
}
