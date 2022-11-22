package bridge.game;

import bridge.domain.Direction;

public class GameStatus {

    private static final String O = "O";
    private static final String X = "X";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String OPENER = "[ ";
    private static final String CLOSER = " ]";
    private static final String SEPARATOR = " | ";
    private static final String EMPTY = " ";

    private boolean isStart;
    private boolean isFail;
    private int tryCount;
    private StringBuilder up;
    private StringBuilder down;

    public GameStatus() {
        isStart = true;
        tryCount = 1;
        init();
    }

    private void init() {
        up = new StringBuilder(OPENER);
        down = new StringBuilder(OPENER);
        isStart = true;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public String getStatus(Direction direction) {
        if (isFail) {
            addStatus(direction, X);
            return FAIL;
        }
        return SUCCESS;
    }

    public void restart() {
        tryCount++;
        init();
    }

    public void move(Direction direction) {
        addStatus(direction, O);
    }

    public void makeFail(Direction direction) {
        addStatus(direction, X);
        isFail = true;
    }

    private void addStatus(Direction direction, String status) {
        if (direction.isUp()) {
            addUp(status);
            return;
        }
        addDown(status);
    }

    public String getBridgeStatus() {
        return up + CLOSER + '\n' + down + CLOSER;
    }

    private void addUp(String status) {
        addStatus(up, down, status);
    }

    private void addDown(String status) {
        addStatus(down, up, status);
    }

    private void addStatus(StringBuilder notEmpty, StringBuilder empty, String status) {
        if (!isStart) {
            notEmpty.append(SEPARATOR);
            empty.append(SEPARATOR);
        }

        notEmpty.append(status);
        empty.append(EMPTY);

        isStart = false;
    }

}
