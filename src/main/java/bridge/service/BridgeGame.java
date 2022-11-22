package bridge.service;

import bridge.bo.Bridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int INITIAL_TRY_NUMBER = 1;
    private final List<String> userMoves;
    private final List<Boolean> results;
    private final Bridge bridge;
    private Iterator<String> bridgeIterator;
    private int tries;

    public BridgeGame(Bridge bridge) {
        this.results = new ArrayList<>();
        this.userMoves = new ArrayList<>();
        this.bridge = bridge;
        this.tries = INITIAL_TRY_NUMBER;
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

    public boolean move(String move, String answerMove) {
        boolean result = isCorrectMove(move, answerMove);
        userMoves.add(move);
        results.add(result);
        return result;
    }

    private boolean isCorrectMove(String userMove, String answerMove) {
        return userMove.equals(answerMove);
    }

    public void retry() {
        userMoves.clear();
        results.clear();
        tries++;
        bridgeIterator = bridge.getIterator();
    }

    public void finish() {
        while (bridgeIterator.hasNext()) {
            bridgeIterator.next();
        }
    }
}
