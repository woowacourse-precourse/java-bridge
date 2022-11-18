package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 결과를 관리하는 클래스
 */
public class BridgeGameResult {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = " ";

    private final List<String> upStates;
    private final List<String> downStates;

    public BridgeGameResult() {
        this.upStates = new ArrayList<>();
        this.downStates = new ArrayList<>();
    }

    /**
     * @param moving    이동할 칸
     * @param moveState 이동 상태 (가능:O, 불가능:X)
     */
    public void createResult(String moving, String moveState) {
        if (moving.equals(UP)) {
            upStates.add(moveState);
            downStates.add(BLANK);
        }

        if (moving.equals(DOWN)) {
            downStates.add(moveState);
            upStates.add(BLANK);
        }
    }
}
