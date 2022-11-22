package bridge.model;

public class BridgePiece {

    private static final int REACHED_END = 1;
    private static final int COMPARE_SAME = 2;
    private static final int COMPARE_DIFFERENT = 3;
    private static final int ZERO = 0;

    private static int currentPlace = 0;
    private final String userInputMove;

    BridgePiece(String userInput) {
        this.userInputMove = userInput;
    }

    public int compareWithAnswer(final BridgeAnswer bridgeAnswer) {
        int compareResult = bridgeAnswer.compareWithUserMove(currentPlace, userInputMove);
        if (compareResult == REACHED_END) {
            return REACHED_END;
        } else if (compareResult == COMPARE_SAME) {
            currentPlace++;
            return COMPARE_SAME;
        }
        return COMPARE_DIFFERENT;
    }

    public static void replayCurrentPlaceReset(final BridgeAnswer bridgeAnswer) {
        currentPlace = ZERO;
        bridgeAnswer.resetCurrentSpot();
    }
}
