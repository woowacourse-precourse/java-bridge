package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<List<String>> gradingBoard;
    private final List<String> answerBridge;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        this.gradingBoard = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param nextStep 다음 내딪을 위치. 위 칸이면 "U", 아래 칸이면 "D"
     * @return 현재까지의 점수판(gradingBoard)과 내딪은 위치가 정답인지 여부(isCorrect)를 표현한다.
     */
    public BridgeGameResultDto move(String nextStep) {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    /**
     * 다음 내딪을 칸을 잘 내딪었는지 확인하는 메서드
     * @param nextStep 다음 내딪을 위치. 위 칸이면 "U", 아래 칸이면 "D"
     * @return nextStep이 정답이면 true, 정답이 아니면 false
     */
    private boolean compareNextStep(String nextStep) {
        int nextPosition = gradingBoard.get(0).size();
        if (answerBridge.get(nextPosition).equals(nextStep)) {
            return true;
        }
        return false;
    }

}
