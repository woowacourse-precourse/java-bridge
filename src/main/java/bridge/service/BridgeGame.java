package bridge.service;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.Player;
import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeSize;
    private Bridge gameBridge;
    private Player gamePlayer;
    private int gameCount = 1;

    public void setBridge(int inputSize){
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.gameBridge = new Bridge(maker.makeBridge(inputSize));
        this.gamePlayer = new Player();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveSquare) {
        gamePlayer.movePlayerBridge(moveSquare);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gamePlayer.resetPlayerBridge();
        gameCount++;
    }

    public void stop(){
        return;
    }

    public boolean isRight(){
        return gamePlayer.compareBridge(gameBridge);
    }

    public boolean isSame(){
        return gamePlayer.isSame(gameBridge);
    }

    public String showPlayerBridgeToString(boolean isRight){
        return gamePlayer.toString(isRight);
    }

    public int getGameCount(){
        return gameCount;
    }
}
