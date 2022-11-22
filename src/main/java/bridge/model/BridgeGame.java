package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String STEP_WRONG = "X";
    private final Bridge answerMove;
    private List<String> playerMove;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.answerMove = new Bridge(bridgeMaker.makeBridge(size));
        this.playerMove = new ArrayList<>();
    }

    public boolean isEnd() {
        return playerMove.equals(answerMove.getBridge());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String step) {
        playerMove.add(step);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.playerMove = new ArrayList<>();
    }

    public List<List<String>> getGameMap() {
        answerMove.makeAllMap(playerMove);
        return answerMove.getBridgeMap();
    }

    public GameStatus getStatus() {
        if (answerMove.getBridgeMap()
                .stream()
                .anyMatch(map -> map.contains(STEP_WRONG))) {
            return GameStatus.FAIL;
        }
        return GameStatus.SUCCESS;
    }
}
