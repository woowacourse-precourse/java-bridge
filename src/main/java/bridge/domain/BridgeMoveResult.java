package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 결과를 관리하는 클래스
 */
public class BridgeMoveResult {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = " ";
    private static final String MOVE = "O";
    private static final String STOP = "X";

    private final List<String> upStates;
    private final List<String> downStates;

    public BridgeMoveResult() {
        this.upStates = new ArrayList<>();
        this.downStates = new ArrayList<>();
    }

    /**
     * @param moving   이동할 칸
     * @param mobility 이동 가능성
     */
    public void createResult(String moving, Boolean mobility) {
        String state = makeState(mobility);

        if (moving.equals(UP)) {
            upStates.add(state);
            downStates.add(BLANK);
        }

        if (moving.equals(DOWN)) {
            downStates.add(state);
            upStates.add(BLANK);
        }
    }

    private String makeState(Boolean mobility) {
        if (mobility) {
            return MOVE;
        }
        return STOP;
    }

    public List<String> getUpStates() {
        return upStates;
    }

    public List<String> getDownStates() {
        return downStates;
    }
}
