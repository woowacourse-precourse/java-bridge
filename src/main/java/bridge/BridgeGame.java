package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    final static String DOWN = "D";
    final static String UP = "U";
    final static String CAN_GO = " O |";
    final static String NOT_SELECT = "   |";
    final static String CANNOT_GO = " X |";

    private final List<String> resultSteps;
    private final int bridgeSize;
    private StringBuilder down;
    private StringBuilder up;
    private int location;

    public BridgeGame(List<String> resultSteps, int bridgeSize) {
        this.up = new StringBuilder("[");
        this.down = new StringBuilder("[");
        this.resultSteps = resultSteps;
        this.bridgeSize = bridgeSize;
        this.location = 0;
    }

    public String getDown() {
        return down.toString();
    }

    public String getUp() {
        return up.toString();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String move) {
        if (move.equals(resultSteps.get(location))) {
            correct(move);
            if (location == bridgeSize - 1) {
                return 1;
            }
            location++;
            return 0;
        }
        notCorrect(move);
        return -1;
    }

    private void correct(String nextStep) {
        if (nextStep.equals(DOWN)) {
            down.append(CAN_GO);
            up.append(NOT_SELECT);
        } else if (nextStep.equals(UP)) {
            up.append(CAN_GO);
            down.append(NOT_SELECT);
        }
    }

    private void notCorrect(String nextStep) {
        location++;
        if (nextStep.equals(UP)) {
            up.append(CANNOT_GO);
            down.append(NOT_SELECT);
        } else if (nextStep.equals(DOWN)) {
            down.append(CANNOT_GO);
            up.append(NOT_SELECT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.location = 0;
        this.up = new StringBuilder("[");
        this.down = new StringBuilder("[");
    }

    public String isSuccess() {
        if (!up.toString().contains("X") && !down.toString().contains("X")) {
            return "성공";
        }
        return "실패";
    }
}
