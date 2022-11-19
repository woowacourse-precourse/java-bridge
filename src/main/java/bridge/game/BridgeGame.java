package bridge.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridgeAnswer;
    private final List<String> bridgeUpper = new ArrayList<>();
    private final List<String> bridgeLower = new ArrayList<>();
    private BridgeGameStatus status;
    private int tryCount;

    public BridgeGame(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
        status = BridgeGameStatus.RUNNING;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        validateMove(direction);
        int currentIndex = bridgeUpper.size();
        String answer = bridgeAnswer.get(currentIndex);

        matchBridge(answer, direction);

        //TODO
        //index out of bound, currentIndex != bridgeLower.size()

    }

    private void validateMove(String direction) {
        if (!status.equals(BridgeGameStatus.STOP)) {
            throw new IllegalStateException("[ERROR]");
        }
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (bridgeUpper.size() != bridgeLower.size()) {
            throw new IllegalStateException("[ERROR]");
        }
    }

    private void matchBridge(String answer, String direction) {
        if (answer.equals("U") && answer.equals(direction)) {
            updateBridge("O", " ");
        }
        if (answer.equals("U") && !answer.equals(direction)) {
            updateBridge(" ", "X");
        }
        if (answer.equals("D") && answer.equals(direction)) {
            updateBridge(" ", "O");
        }
        if (answer.equals("D") && !answer.equals(direction)) {
            updateBridge("X", " ");
        }
    }

    private void updateBridge(String upperAnswer, String lowerAnswer) {
        bridgeUpper.add(upperAnswer);
        bridgeLower.add(lowerAnswer);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeUpper.clear();
        bridgeLower.clear();
        status = BridgeGameStatus.RUNNING;
        tryCount += 1;
    }
}
