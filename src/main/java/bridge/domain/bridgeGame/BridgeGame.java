package bridge.domain.bridgeGame;

import bridge.domain.bridgeGame.bridgeMap.BridgeMap;
import bridge.domain.bridgeGame.gameStatics.GameStatics;

import java.util.Queue;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final GameStatics gameStatics;
    private final BridgeMap bridgeMap;

    private BridgeGame(GameStatics gameStatics, BridgeMap bridgeMap) {
        this.gameStatics = gameStatics;
        this.bridgeMap = bridgeMap;
    }

    public static BridgeGame initGame() {
        return new BridgeGame(GameStatics.initStatics(), BridgeMap.initMap());
    }

    public boolean crossSuccess() {
        return gameStatics.getCrossResult();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction, boolean crossSuccess) {
        bridgeMap.addCrossResult(direction, crossSuccess);
        gameStatics.updateCrossResult(crossSuccess);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeMap.reset();
        gameStatics.increaseAttemptCount();
    }

    public String bridgeMap() {
        return bridgeMap.toString();
    }

    public Queue<String> gameStatics() {
        return gameStatics.getStaticsString();
    }
}
