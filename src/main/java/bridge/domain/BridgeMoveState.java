package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 결과를 관리하는 클래스
 */
public class BridgeMoveState {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = " ";
    private static final String MOVE = "O";
    private static final String STOP = "X";

    private final List<String> upState;
    private final List<String> downState;

    public BridgeMoveState() {
        this.upState = new ArrayList<>();
        this.downState = new ArrayList<>();
    }

    /**
     * @param moving   이동할 칸
     * @param mobility 이동 가능성
     */
    public void update(String moving, boolean mobility) {
        String state = makeState(mobility);

        if (moving.equals(UP)) {
            upState.add(state);
            downState.add(BLANK);
        }

        if (moving.equals(DOWN)) {
            downState.add(state);
            upState.add(BLANK);
        }
    }

    private String makeState(boolean mobility) {
        if (mobility) {
            return MOVE;
        }
        return STOP;
    }

    public List<String> getUpState() {
        return upState;
    }

    public List<String> getDownState() {
        return downState;
    }
}
