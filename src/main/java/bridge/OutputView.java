package bridge;

import static bridge.OutputViewDetail.*;

public class OutputView {
    String upperBridge = "";
    String lowerBridge = "";

    private boolean isUp(BridgeGame bridgeGame){
        return bridgeGame.getBridgePosition().equals(BridgeDirection.U.toString());
    }

    private boolean isDown(BridgeGame bridgeGame){
        return bridgeGame.getBridgePosition().equals(BridgeDirection.D.toString());
    }

    private boolean isOnGoing(BridgeGame bridgeGame){
        return (1 < bridgeGame.bridgeIndex && bridgeGame.bridgeIndex < bridgeGame.bridge.size());
    }

    private void makeUpperBridge(BridgeGame bridgeGame) {
        if (isUp(bridgeGame) && bridgeGame.isCorrect) {
            upperBridge += CAN_MOVE.getMessage();
        }
        if (isUp(bridgeGame) && !bridgeGame.isCorrect) {
            upperBridge += CANNOT_MOVE.getMessage();
        }
        if (isDown(bridgeGame)) {
            upperBridge += NONE.getMessage();
        }
    }

    private void makeLowerBridge(BridgeGame bridgeGame) {
        if (isDown(bridgeGame) && bridgeGame.isCorrect) {
            lowerBridge += CAN_MOVE.getMessage();
        }
        if (isDown(bridgeGame) && !bridgeGame.isCorrect) {
            lowerBridge += CANNOT_MOVE.getMessage();
        }
        if (isUp(bridgeGame)) {
            lowerBridge += NONE.getMessage();
        }
    }

    private void addLine(BridgeGame bridgeGame) {
        if (isOnGoing(bridgeGame)) {
            upperBridge += MIDDLE_LINE.getMessage();
            lowerBridge += MIDDLE_LINE.getMessage();
        }
    }

    public void makeBridgeMap(BridgeGame bridgeGame) {
        addLine(bridgeGame);
        makeUpperBridge(bridgeGame);
        makeLowerBridge(bridgeGame);
    }

    public void removeRecentBridge() {
        upperBridge = upperBridge.substring(0, upperBridge.length() - 4);
        lowerBridge = lowerBridge.substring(0, lowerBridge.length() - 4);
    }

    public void printMap() {
        System.out.println(START_LINE.getMessage() + upperBridge + END_LINE.getMessage());
        System.out.println(START_LINE.getMessage() + lowerBridge + END_LINE.getMessage());
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT.getMessage());
        printMap();
        printSuccessOrFail(bridgeGame);
        printTryNumber(bridgeGame);
    }

    public void printSuccessOrFail(BridgeGame bridgeGame) {
        if (bridgeGame.isSuccess){
            System.out.println(NEW_LINE.getMessage() + String.format(SUCCESS_OR_FAIL.getMessage(), SUCCESS.getMessage()));
        }
        if (!bridgeGame.isSuccess) {
            System.out.println(NEW_LINE.getMessage() + String.format(SUCCESS_OR_FAIL.getMessage(), FAIL.getMessage()));
        }
    }

    public void printTryNumber(BridgeGame bridgeGame) {
        System.out.println(String.format(TRY_NUMBER.getMessage(), bridgeGame.getTryNumber()));
    }

    public void printStartGame() {
        System.out.println(START_GAME.getMessage());
    }

    public void inputBridgeSize() {
        System.out.println(NEW_LINE.getMessage() + INPUT_BRIDGE_SIZE.getMessage());
    }

    public void inputMoving() {
        System.out.println(NEW_LINE.getMessage() +  INPUT_MOVING.getMessage());
    }

    public void restartOrQuit() {
        System.out.println(NEW_LINE.getMessage() +  RESTART_OR_QUIT.getMessage());
    }
}
