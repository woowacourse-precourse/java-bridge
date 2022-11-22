package bridge;

import bridge.model.BridgeMap;

import java.util.Iterator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMap bridgeMap;
    private List<String> answer;
    private Iterator<String> answerChecker;

    public BridgeGame(BridgeMap bridgeMap, List<String> answer) {
        this.bridgeMap = bridgeMap;
        this.answer = answer;
        this.answerChecker = answer.iterator();
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Move move) {
        String result = compareWithCurrentAnswer(move.getLocation());
        bridgeMap.insertMove(result, move.getOrder());
        if (result.equals("X")) {
            return false;
        }
        return true;
    }

    private String compareWithCurrentAnswer(String move) {
        if (move.equals(answerChecker.next())) {
            return "O";
        }
        return "X";
    }

    public boolean isEnd() {
        if (answerChecker.hasNext()) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.bridgeMap = BridgeMap.generateMap();
        resetAnswerChecker();
    }

    private void resetAnswerChecker() {
        answerChecker = answer.iterator();
    }
}
