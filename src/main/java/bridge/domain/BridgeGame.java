package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import bridge.utils.Constants.OutputState;
import bridge.utils.Constants.Result;
import bridge.utils.Constants.BridgeShape;
import bridge.utils.Constants.Command;

public class BridgeGame {

    private static List<String> bridge;
    private static int attemptCount = 0;

    private List<String> upline;
    private List<String> downline;
    private int bridgeIndex;
    private String result;

    public BridgeGame() {
        this.upline = new ArrayList<String>();
        this.downline = new ArrayList<String>();
        this.result = Result.FAIL;
        this.bridgeIndex = 0;
    }

    public static String attemptCountToString() {
        return OutputState.TOTAL_ATTEMPT + BridgeGame.attemptCount;
    }

    public static void increaseAttemptCount() {
        BridgeGame.attemptCount += 1;
    }

    public String resultToString() {
        return OutputState.SUCCESS_OR_NOT + result;
    }

    public static void setBridge(List<String> bridge) {
        BridgeGame.bridge = bridge;
    }

    public boolean isSuccessFinish() {
        if (BridgeGame.bridge.size() == this.bridgeIndex) {
            this.result = Result.SUCCESS;
            return true;
        }
        this.result = Result.FAIL;
        return false;
    }

    public String uplineToString() {
        return BridgeShape.START_SYMBOL + String.join(BridgeShape.SEPERATOR, this.upline) + BridgeShape.END_SYMBOL;

    }

    public String downlineToString() {
        return BridgeShape.START_SYMBOL + String.join(BridgeShape.SEPERATOR, this.downline) + BridgeShape.END_SYMBOL;
    }

    public boolean isCorrectDirection(String command) {
        return BridgeGame.bridge.get(bridgeIndex).equals(command);
    }

    private void drawLine(List<String> selectedLine, List<String> oppositeLine, String movementShape) {
        selectedLine.add(movementShape);
        oppositeLine.add(BridgeShape.BLOCK);
    }

    private void addMovement(List<String> selectedLine, List<String> oppositeLine, boolean isCorrect) {
        this.bridgeIndex += 1;
        if (isCorrect) {
            drawLine(selectedLine, oppositeLine, BridgeShape.MOVABLE);
            return;
        }
        drawLine(selectedLine, oppositeLine, BridgeShape.UNMOVABLE);
    }

    private boolean isCorrectMovement(List<String> selectedLine, List<String> unselectedLine, String direction) {
        boolean isCorerct = isCorrectDirection(direction);
        addMovement(selectedLine, unselectedLine, isCorerct);
        return isCorerct;
    }

    public boolean move(String direction) {
        List<String> selectedLine = this.upline;
        List<String> unselectedLine = this.downline;
        if (direction.equals(Command.DOWN)) {
            selectedLine = this.downline;
            unselectedLine = this.upline;
        }
        return isCorrectMovement(selectedLine, unselectedLine, direction);
    }

    public boolean retry(String command) {
        return command.equals(Command.RETRY);
    }
}
