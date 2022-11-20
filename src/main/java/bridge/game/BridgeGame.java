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

    public List<String> getBridge_answer() {
        return bridge_answer;
    }

    public List<String> getBridge_userMove() {
        return bridge_userMove;
    }

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
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

}
