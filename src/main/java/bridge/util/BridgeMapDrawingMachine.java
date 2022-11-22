package bridge.util;

import bridge.domain.MovementType;
import bridge.domain.Bridge;
import bridge.domain.GameResult;

import java.util.List;

public class BridgeMapDrawingMachine {

    public static final String BLANK = "   |";
    public static final String O = " O |";
    public static final String X = " X |";
    public static final String FIRST = "[";
    public static final String MIDDLE = "]\n[";
    public static final String LAST = "]";

    public static String draw(GameResult gameResult) {
        if (gameResult.isSuccess()) {
            return drawSuccessCase(gameResult);
        }
        return drawFailCase(gameResult);
    }

    private static String drawSuccessCase(GameResult gameResult) {
        Bridge selectedBridge = gameResult.getSelectedBridge();
        List<String> bridges = selectedBridge.getBridges();
        StringBuilder upLine = makeLine(MovementType.UP, bridges, bridges.size());
        StringBuilder downLine = makeLine(MovementType.DOWN, bridges, bridges.size());
        return mergeTwoLine(upLine, downLine);
    }

    private static String drawFailCase(GameResult gameResult) {
        Bridge selectedBridge = gameResult.getSelectedBridge();
        List<String> bridges = selectedBridge.getBridges();
        StringBuilder upLine = makeLine(MovementType.UP, bridges, bridges.size() - 1);
        StringBuilder downLine = makeLine(MovementType.DOWN, bridges, bridges.size() - 1);
        appendFailBridge(gameResult, upLine, downLine);
        return mergeTwoLine(upLine, downLine);
    }

    private static void appendFailBridge(GameResult gameResult, StringBuilder upLine, StringBuilder downLine) {
        Bridge selectedBridge = gameResult.getSelectedBridge();
        String failBridge = selectedBridge.getLastBridge();
        if (MovementType.UP.getCode().equals(failBridge)) {
            appendFail(upLine, downLine);
            return;
        }
        appendFail(downLine, upLine);
    }

    private static void appendFail(StringBuilder failLine, StringBuilder blankLine) {
        failLine.append(X);
        blankLine.append(BLANK);
    }


    private static StringBuilder makeLine(MovementType movementType, List<String> bridges, int numberOfBridge) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < numberOfBridge; count++) {
            String bridge = bridges.get(count);
            updateLine(stringBuilder, bridge, movementType);
        }
        return stringBuilder;
    }

    private static void updateLine(StringBuilder stringBuilder, String bridge, MovementType movementType) {
        if (checkBridge(bridge, movementType)) {
            stringBuilder.append(O);
            return;
        }
        stringBuilder.append(BLANK);
    }

    private static boolean checkBridge(String bridge, MovementType movementType) {
        return movementType.getCode().equals(bridge);
    }

    private static String mergeTwoLine(StringBuilder upLine, StringBuilder downLine) {
        deleteLastChar(upLine, downLine);
        return FIRST + upLine + MIDDLE + downLine + LAST;
    }

    private static void deleteLastChar(StringBuilder upLine, StringBuilder downLine) {
        upLine.deleteCharAt(upLine.length() - 1);
        downLine.deleteCharAt(downLine.length() - 1);
    }
}
