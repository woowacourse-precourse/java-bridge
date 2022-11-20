package bridge.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge_answer;
    private List<String> bridge_userMove = new ArrayList<>();

    public enum BridgeShape {
        DOWN(0, "D"),
        UP(1, "U");

        private int integerValue;
        private String stringValue;

        BridgeShape(int integerValue, String stringValue) {
            this.integerValue = integerValue;
            this.stringValue = stringValue;
        }

        public int getIntegerValue() {
            return integerValue;
        }

        public String getStringValue() {
            return stringValue;
        }
    }

    // getter
    public List<String> getBridge_answer() {
        return bridge_answer;
    }

    public List<String> getBridge_userMove() {
        return bridge_userMove;
    }

    // setter
    public void setBridgeAnswer(List<String> bridge_answer) {
        this.bridge_answer = bridge_answer;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMoveDirection) {
        bridge_userMove.add(userMoveDirection);
    }

    /**
     * 게임 성공 여부 확인
     * <p>
     * 성공 조건
     * 1. 다리를 끝까지 건넜을 경우
     * 2. 마지막까지 이동할 수 있는 칸을 선택했을 경우
     *
     * @param userNumberOfMoves 사용자의 이동 횟수
     * @return 성공 시 true 반환 / 실패 시 false 반환
     */
    public boolean checkIfGameIsSucceed(int userNumberOfMoves) {
        if (userNumberOfMoves == bridge_answer.size()) {
            return bridge_userMove.equals(bridge_answer);
        }
        return false;
    }

    /**
     * 게임 실패 여부 확인
     * 실패 조건: 이동할 수 없는 칸을 선택한 경우
     *
     * @param userNumberOfMoves 사용자의 이동 횟수
     * @return 실패 시 true 반환 / 실패가 아닐 시 false 반환
     */
    public boolean checkIfGameIsFailed(int userNumberOfMoves) {
        int currentPositionIndex = userNumberOfMoves - 1;
        String userCurrentPosition = bridge_userMove.get(currentPositionIndex);
        String answerCurrentPosition = bridge_answer.get(currentPositionIndex);
        return userCurrentPosition.compareTo(answerCurrentPosition) != 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}
