package bridge.view;

import bridge.config.Direction;
import bridge.model.BridgePrinter;
import bridge.model.PieceMove;

import java.util.Stack;

public class BridgeConsolePrinter implements BridgePrinter {

    public static final String DELIMITER = "|";
    public static final String START_OF_BRIDGE = "[";
    public static final String END_OF_BRIDGE = "]";
    public static final String SUCCESS_MOVE = " O ";
    public static final String FAIL_MOVE = " X ";
    public static final String NEXT_LINE = "\n";
    public static final String EMPTY_CELL = "   ";

    @Override
    public String getPrintable(Stack<PieceMove> moveTrace) {
        StringBuilder upLine = new StringBuilder();
        StringBuilder downLine = new StringBuilder();

        recordStartOfBridge(upLine, downLine);
        recordFirstCell(moveTrace, upLine, downLine);
        recordRemainCellsWithDelimiter(moveTrace, upLine, downLine);
        recordEndOfBridge(upLine, downLine);

        return mergeLines(upLine, downLine);
    }

    private static void recordFirstCell(Stack<PieceMove> moveTrace, StringBuilder upLine, StringBuilder downLine) {
        if (!moveTrace.isEmpty()) {
            upLine.append(traceToPrintable(moveTrace.get(0), Direction.UP));
            downLine.append(traceToPrintable(moveTrace.get(0), Direction.DOWN));
        }
    }

    private static void recordRemainCellsWithDelimiter(Stack<PieceMove> moveTrace, StringBuilder upLine, StringBuilder downLine) {
        for (int idx = 1; idx < moveTrace.size(); idx++) {
            upLine.append(DELIMITER).append(traceToPrintable(moveTrace.get(idx), Direction.UP));
            downLine.append(DELIMITER).append(traceToPrintable(moveTrace.get(idx), Direction.DOWN));
        }
    }

    private static void recordStartOfBridge(StringBuilder upLine, StringBuilder downLine) {
        upLine.append(START_OF_BRIDGE);
        downLine.append(START_OF_BRIDGE);
    }

    private static void recordEndOfBridge(StringBuilder upLine, StringBuilder downLine) {
        upLine.append(END_OF_BRIDGE);
        downLine.append(END_OF_BRIDGE);
    }

    private static String mergeLines(StringBuilder upLine, StringBuilder downLine) {
        return upLine.append(NEXT_LINE).append(downLine).toString();
    }

    private static String traceToPrintable(PieceMove move, Direction linePosition) {
        if (move.getDirection() != linePosition) {
            return EMPTY_CELL;
        }
        return traceToResult(move);
    }

    private static String traceToResult(PieceMove move) {
        if (move.getSuccess()) {
            return SUCCESS_MOVE;
        }
        return FAIL_MOVE;
    }

}
