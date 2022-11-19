package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
     * @param moving  이동할 칸
     * @param canMove 이동 가능여부
     */
    public void update(String moving, boolean canMove) {
        String state = makeState(canMove);

        if (moving.equals(UP)) {
            upState.add(state);
            downState.add(BLANK);
        }

        if (moving.equals(DOWN)) {
            downState.add(state);
            upState.add(BLANK);
        }
    }

    private String makeState(boolean canMove) {
        if (canMove) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeMoveState that = (BridgeMoveState) o;
        return Objects.equals(upState, that.upState) && Objects.equals(downState, that.downState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upState, downState);
    }
}
