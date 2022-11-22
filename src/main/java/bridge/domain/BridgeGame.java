package bridge.domain;

import bridge.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> answerDirections;
    private final List<String> playerDirections;
    private int trial;

    public BridgeGame(List<String> answerDirections) {
        this.answerDirections = answerDirections;
        playerDirections = new ArrayList<>();
        trial = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        playerDirections.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        undoLastMove();
        trial++;
    }

    private void undoLastMove() {
        playerDirections.remove(playerDirections.size() - 1);
    }

    public List<String> getAnswerDirections() {
        return Collections.unmodifiableList(answerDirections);
    }

    public List<String> getPlayerDirections() {
        return Collections.unmodifiableList(playerDirections);
    }

    public int getTrial() {
        return trial;
    }
}
