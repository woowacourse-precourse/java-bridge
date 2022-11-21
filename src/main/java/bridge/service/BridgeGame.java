package bridge.service;

import bridge.bo.Bridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int INITIAL_TRI_NUMBER = 1;
    private final List<String> userMoves;
    private final List<Boolean> results;
    private final Bridge bridge;
    private Iterator<String> bridgeIterator;
    private int tries;

    public BridgeGame(Bridge bridge) {
        this.results = new ArrayList<>();
        this.userMoves = new ArrayList<>();
        this.bridge = bridge;
        this.tries = INITIAL_TRI_NUMBER;
        this.bridgeIterator = bridge.getIterator();
    }

    public List<String> getUserMoves() {
        return userMoves;
    }

    public List<Boolean> getResults() {
        return results;
    }

    public Iterator<String> getBridgeIterator() {
        return bridgeIterator;
    }

    public int getTries() {
        return tries;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public boolean move(String move, String answerMove) {
        boolean result = isCorrectMove(move, answerMove);
        userMoves.add(move);
        results.add(result);
        return result;
    }

    private boolean isCorrectMove(String userMove, String answerMove) {
        return userMove.equals(answerMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
