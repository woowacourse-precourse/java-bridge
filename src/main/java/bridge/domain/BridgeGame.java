package bridge.domain;

import static bridge.domain.BridgeMove.*;
import static bridge.domain.BridgeMoveJudgment.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private final List<BridgeMoveJudgment> moveResult = new ArrayList<>();
    private int tryCount = 0;
    private int retryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<BridgeMoveJudgment> move(List<String> bridge, String movingSpace) {
        String bridgeSpace = bridge.get(tryCount);
        tryCount = tryCount + 1;
        List<BridgeMoveJudgment> bridgeMoveJudgments = compareMovingSpace(movingSpace, bridgeSpace);
        moveResult.add(bridgeMoveJudgments.get(0));
        moveResult.add(bridgeMoveJudgments.get(1));
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<BridgeMoveJudgment> retry(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            tryCount = 0;
            retryCount = retryCount + 1;
            moveResult.clear();
            return moveResult;
        }
        if (gameCommand.equals(QUIT)) {
            return moveResult;
        }
        throw new IllegalStateException("[ERROR] 메소드를 잘못 사용하셨습니다.");
    }

    /**
     * 게임 실패 여부 검사할 때 사용하는 메서드
     */
    public boolean isFailGame() {
        if (moveResult.contains(WRONG)) {
            return true;
        }
        return false;
    }

    /**
     * 게임 실패 여부 최종 결과 검사할 때 사용하는 메서드
     */
    public boolean isFailFinalGame(List<String> bridge) {
        if (isFailGame() || bridge.size() != (moveResult.size() / 2)) {
            return true;
        }
        return false;
    }

    /**
     * 게임 총 재시도한 횟수 확인할 때 사용하는 메서드
     */
    public int checkRetryCount() {
        return retryCount;
    }

    /**
     * 사용자 이동한 칸과 다리 칸 비교해서 정해진 형식 리턴 메서드
     */
    private List<BridgeMoveJudgment> compareMovingSpace(String movingSpace, String bridgeSpace) {
        if (movingSpace.equals(UPPER)) {
            boolean correctSpace = isCorrectSpace(movingSpace, bridgeSpace, UPPER);
            return choiceCorrectOrWrong(correctSpace, UPPER_CORRECT, UPPER_WRONG);
        }
        if (movingSpace.equals(LOWER)) {
            boolean correctSpace = isCorrectSpace(movingSpace, bridgeSpace, LOWER);
            return choiceCorrectOrWrong(correctSpace, LOWER_CORRECT, LOWER_WRONG);
        }
        throw new IllegalStateException("[ERROR] 메소드를 잘못 사용하셨습니다.");
    }

    /**
     * 이동한 칸이 맞는 칸인지 확인 메서드
     */
    private boolean isCorrectSpace(String movingSpace, String bridgeSpace, String move) {
        boolean correctSpace = false;
        if (movingSpace.equals(move)) {
            if (bridgeSpace.equals(movingSpace)) {
                correctSpace = true;
            }
        }
        return correctSpace;
    }

    /**
     * 이동한 칸이 맞거나 틀리면 정해진 형식 리턴 메서드
     */
    private List<BridgeMoveJudgment> choiceCorrectOrWrong(
            boolean correctSpace, BridgeMove correct, BridgeMove wrong) {
        if (correctSpace) {
            return correct.moveJudgments;
        }
        return wrong.moveJudgments;
    }
}
