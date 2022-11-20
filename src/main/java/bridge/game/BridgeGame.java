package bridge.game;

import static bridge.game.BridgeGameStatus.FINISH;
import static bridge.game.BridgeGameStatus.RUNNING;
import static bridge.game.BridgeGameStatus.STOP;
import static bridge.game.BridgeMoveResult.CORRECT;
import static bridge.game.BridgeMoveResult.NONE;
import static bridge.game.BridgeMoveResult.WRONG;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridgeAnswer;
    private final CurrentBridge currentBridge = new CurrentBridge();
    private BridgeGameStatus status;
    private int tryCount;

    public BridgeGame(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
        status = RUNNING;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        validateMove(direction);
        int currentIndex = currentBridge.size();
        String answer = bridgeAnswer.get(currentIndex);

        matchBridge(answer, direction);
    }

    private void validateMove(String direction) {
        if (!status.equals(RUNNING)) {
            throw new IllegalStateException("[ERROR]");
        }
        if (!direction.equals("U") && !direction.equals("D")) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void matchBridge(String answer, String direction) {
        if (answer.equals("U") && answer.equals(direction)) {
            currentBridge.update(CORRECT, NONE);
        }
        if (answer.equals("U") && !answer.equals(direction)) {
            currentBridge.update(NONE, WRONG);
        }

        if (answer.equals("D") && answer.equals(direction)) {
            currentBridge.update(NONE, CORRECT);
        }
        if (answer.equals("D") && !answer.equals(direction)) {
            currentBridge.update(WRONG, NONE);
        }

        updateStatus();
    }

    private void updateStatus() {
        String lastUpper = currentBridge
                .getUpper()
                .get(currentBridge.size() - 1);
        String lastLower = currentBridge
                .getLower()
                .get(currentBridge.size() - 1);

        if ((lastUpper.equals("O") || lastLower.equals("O"))
                && currentBridge.size() == bridgeAnswer.size()) {
            this.status = FINISH;
        }

        if (lastUpper.equals("X") || lastLower.equals("X")) {
            this.status = STOP;
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentBridge.clear();
        status = RUNNING;
        tryCount += 1;
    }

    public BridgeGameStatus status() {
        return this.status;
    }

    /**
     * 진행한 다리의 정보를 반환 합니다.
     *
     * @return - size 2 * n 의 List<List<String>>,<br/> .get(0) 상단 정보, .get(1) 하단 정보
     */
    public List<List<String>> progress() {
        return List.of(currentBridge.getUpper(), currentBridge.getLower());
    }

    public int tryTimes() {
        return this.tryCount;
    }
}
