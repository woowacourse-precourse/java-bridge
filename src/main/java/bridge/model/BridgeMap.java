package bridge.model;

public class BridgeMap {
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = "]";

    private final OneSide upSide;
    private final OneSide downSide;

    public BridgeMap() {
        upSide = new OneSide();
        downSide = new OneSide();
    }

    public void add(boolean isUpSide, boolean isRight) {
        if (isUpSide) {
            upSide.addRightOrWrong(isRight);
            downSide.addBlank();
            return;
        }

        upSide.addBlank();
        downSide.addRightOrWrong(isRight);
    }

    @Override
    public String toString() {
        return OPEN_BRACKET + upSide + CLOSE_BRACKET +
                "\n" + OPEN_BRACKET + downSide + CLOSE_BRACKET;
    }
}
