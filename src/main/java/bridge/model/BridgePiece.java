package bridge.model;

public class BridgePiece {

    private static int currentPlace = 0;
    private final String userInputMove;

    BridgePiece(String userInput) {
        this.userInputMove = userInput;
    }

    public int compareWithAnswer(BridgeAnswer bridgeAnswer) {
        int compareResult = bridgeAnswer.compareWithUserMove(currentPlace, userInputMove);
        if (compareResult == 1) {
            return 1;
        } else if (compareResult == 2) {
            currentPlace++;
            return 2;
        }
        return 3;
    }

    public static void replayCurrentPlaceReset(BridgeAnswer bridgeAnswer) {
        currentPlace = 0;
        bridgeAnswer.resetCurrentSpot();
    }
}
