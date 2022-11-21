package bridge.game;

import static bridge.exception.ErrorEnum.INVALID_BRIDGE_GAME_MOVE_STATUS;
import static bridge.exception.ErrorEnum.INVALID_DIRECTION_INPUT;
import static bridge.game.BridgeGameStatus.FINISH;
import static bridge.game.BridgeGameStatus.RUNNING;
import static bridge.game.BridgeGameStatus.STOP;

import bridge.validation.Validator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge answerBridge;
    private final Bridge currentBridge;
    private BridgeGameStatus status;
    private int tryCount;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = new Bridge(answerBridge);
        this.currentBridge = new Bridge();
        status = RUNNING;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        Validator.validateStatusAtMove(status);
        Validator.validateDirectionInput(direction);
        int currentIndex = currentBridge.size();
        String answer = answerBridge.getDirectionAt(currentIndex);

        matchBridge(answer, direction);
    }

    private void matchBridge(String answer, String direction) {
        tryUpdateWithU(answer, direction);
        tryUpdateWithD(answer, direction);
        updateStatus();
    }

    private void tryUpdateWithU(String answer, String direction) {
        if (answer.equals("U") && answer.equals(direction)) {
            currentBridge.updateUpperCorrect();
        }
        if (answer.equals("U") && !answer.equals(direction)) {
            currentBridge.updateUpperWrong();
        }
    }

    private void tryUpdateWithD(String answer, String direction) {
        if (answer.equals("D") && answer.equals(direction)) {
            currentBridge.updateLowerCorrect();
        }
        if (answer.equals("D") && !answer.equals(direction)) {
            currentBridge.updateLowerWrong();
        }
    }

    private void updateStatus() {
        String lastUpper = currentBridge
                .getUpper()
                .get(currentBridge.size() - 1);
        String lastLower = currentBridge
                .getLower()
                .get(currentBridge.size() - 1);
        checkFinish(lastUpper, lastLower);
        checkStop(lastUpper, lastLower);
    }

    private void checkFinish(String lastUpper, String lastLower) {
        if ((lastUpper.equals("O") || lastLower.equals("O"))
                && currentBridge.size() == answerBridge.size()) {
            this.status = FINISH;
        }
    }

    private void checkStop(String lastUpper, String lastLower) {
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
    public List<List<String>> progressMap() {
        return List.of(currentBridge.getUpper(), currentBridge.getLower());
    }

    public List<List<String>> answerMap() {
        return List.of(answerBridge.getUpper(), answerBridge.getLower());
    }

    public int tryTimes() {
        return this.tryCount;
    }
}
