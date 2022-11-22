package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> answer = new ArrayList<String>();
    private final String wrongAnswer = "X";
    private final String rightAnswer = "O";
    private int numberOfAttempts = 1;
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, String movingPoint) {
        String currentAnswer = bridge.get(answer.size());
        if(currentAnswer.equals(movingPoint)){
            answer.add(rightAnswer);
            return answer;
        }
        answer.add(wrongAnswer);
        return answer;
    }

    public int getNumberOfAttempts(){
        return numberOfAttempts;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if(answer.get(answer.size() - 1).equals(wrongAnswer)) {
            answer.remove(answer.size() - 1);
            numberOfAttempts += 1;
        }
    }
}