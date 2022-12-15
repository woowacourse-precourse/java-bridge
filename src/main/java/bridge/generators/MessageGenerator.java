package bridge.generators;

import bridge.domain.MovingResult;
import bridge.domain.enums.BlockStatus;

public class MessageGenerator {
    public static final String NO_SELECT = "   ";
    public static final String CORRECT = " O ";
    public static final String WRONG = " X ";
    public static final String SEPARATE = "|";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";
    public static final String NEXT_LINE = "\n";

    public static String createMovedMessage(final MovingResult movingResult) {
        return OPEN_BRACKET + createBridgeMessage(movingResult, BlockStatus.UP) + CLOSE_BRACKET
                + NEXT_LINE
                + OPEN_BRACKET + createBridgeMessage(movingResult, BlockStatus.DOWN) + CLOSE_BRACKET;
    }

    private static String createBridgeMessage(final MovingResult movingResult, final BlockStatus expectedStatus) {
        StringBuilder topResult = new StringBuilder();
        movingResult.getBlocks()
                .stream()
                .limit(movingResult.getCurrentMovedIndex())
                .map(chooseStatus -> convertStatusToResult(chooseStatus, expectedStatus))
                .forEach(topResult::append);
        topResult.append(movingResult.getLastMoveResult(expectedStatus));
        return topResult.toString();
    }


    private static String convertStatusToResult(final BlockStatus chooseStatus, final BlockStatus expectedStatus) {
        if (chooseStatus == expectedStatus) {
            return CORRECT + SEPARATE;
        }
        return NO_SELECT + SEPARATE;
    }
}
