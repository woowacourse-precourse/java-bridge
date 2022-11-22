package bridge.model;

import bridge.validator.BrideGameValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INDEX_ZERO = 0;
    private static final String GAME_RETRY = "R";
    private final List<String> userAnswerSheet;

    public BridgeGame(final int size) {
        this.userAnswerSheet = new ArrayList<>(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(final String movingCommand) {
        this.userAnswerSheet.add(movingCommand);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(final String retryCommand) {
        if (retryCommand.equals(GAME_RETRY)) {
            this.userAnswerSheet.clear();
            return true;
        }
        return false;
    }

    public boolean isDone(final Bridge bridge) {
        if (!isWin(bridge)) {
            return true;
        }
        return bridge.getBridgeSize() == this.userAnswerSheet.size();
    }

    public boolean isWin(final Bridge bridge) {
        for (int i = INDEX_ZERO; i < this.userAnswerSheet.size(); ++i) {
            if (!bridge.getResult(this.userAnswerSheet.get(i), i)) {
                return false;
            }
        }
        return true;
    }

    public int getUserAnswerSheetSize() {
        return this.userAnswerSheet.size();
    }

    public String getUserAnswerByIndex(final int index) {
        return this.userAnswerSheet
                .get(BrideGameValidator.checkBridgeIndexValid(this.userAnswerSheet.size(), index));
    }
}
