package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    List<String> answerBridge;
    List<String> upBridge;
    List<String> downBridge;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = answerBridge;
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 결과를 저장하고 맞히면 true 리턴
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input, int index) {
        if(input.equals("U")) {
            if(isCorrect(answerBridge.get(index), input)) {
                upBridge.add("O");
                downBridge.add(" ");
                return true;
            }
            upBridge.add("X");
            downBridge.add(" ");
        }
        else if(input.equals("D")) {
            if(isCorrect(answerBridge.get(index), input)) {
                upBridge.add(" ");
                downBridge.add("O");
                return true;
            }
            downBridge.add("X");
            upBridge.add(" ");
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        return input.equals("R");
    }

    private boolean isCorrect(String answer, String input) {
        return input.equals(answer);
    }
}
