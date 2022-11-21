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

        private final int integerValue;
        private final String stringValue;

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
     * TODO: 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param userMoveDirection 사용자가 입력한 이동할 방향
     */
    public void move(String userMoveDirection) {
        bridge_userMove.add(userMoveDirection);
    }

    /**
     * TODO: 게임 성공 여부 확인
     * <p>
     * 성공 조건 : 다리 끝까지 이동할 수 있는 칸을 선택했을 경우
     * 1. 사용자의 이동 횟수와 정답 다리의 길이가 같으며,
     * 2. 사용자가 다리 상에서 이동한 발자취를 그려보았을 때 정답 다리와 모양이 똑같을 경우
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
     * TODO: 게임 실패 여부 확인
     * <p>
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
     * TODO: 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * bridge_userMove 초기화
     */
    public void retry() {
        bridge_userMove = new ArrayList<>();
    }

}
