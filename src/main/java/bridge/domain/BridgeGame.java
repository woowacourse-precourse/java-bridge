package bridge.domain;

import static bridge.util.Constant.*;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Round round;
    private GameAttempt gameAttempt;
    private BridgeState bridgeState;

    public BridgeGame(Round round, GameAttempt gameAttempt, BridgeState bridgeState){
        this.round = round;
        this.gameAttempt = gameAttempt;
        this.bridgeState = bridgeState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    // 게임 성공여부 나타내는 기능
    public String checkGameSuccess(String userInput, List<String> bridge) {
        if(round.getRound() == bridge.size() && userInput.equals(bridge.get(round.getRound()-1))) {
            return SUCCESS;
        }
        return FAIL;
    }

    public GameAttempt getGameAttempt() {
        return gameAttempt;
    }

    public BridgeState getBridgeState() {
        return bridgeState;
    }

}
