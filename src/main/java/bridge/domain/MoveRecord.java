package bridge.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoveRecord {
    final static String NOT_CROSSED = " ";
    final static String BRIDGE_PIECE_SEPARATOR = " | ";
    final static String RECORD_START_BRACKET = "[ ";
    final static String RECORD_END_BRACKET = " ]";
    final static String RECORD_SEPARATOR = "\n";
    private final Map<BridgeLine, StringBuilder> record;

    public MoveRecord() {
        record = new HashMap<>();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new StringBuilder(RECORD_START_BRACKET));
        });
    }

    private void recordOneLine(BridgeLine bridgeLine, String bridgePieceState) {
        record.get(bridgeLine).append(bridgePieceState);
    }

    public void recordMovement(MoveResult moveResult, String moveCommand) {
        BridgeLine bridgeLineToMove = BridgeLine.findByCommand(moveCommand);
        recordOneLine(bridgeLineToMove, moveResult.getSymbol());
        record.keySet().stream()
                .filter(bridgeLine -> !bridgeLine.equals(bridgeLineToMove))
                .forEach(bridgeLine -> recordOneLine(bridgeLine, NOT_CROSSED));
    }

    public String getRecord(BridgeLine bridgeLine) {
        return String.join(BRIDGE_PIECE_SEPARATOR, record.get(bridgeLine).toString()) + RECORD_END_BRACKET;
    }

    public String getRecord() {
        StringBuilder multipleRecord = new StringBuilder();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            multipleRecord.append(getRecord(bridgeLine));
            multipleRecord.append(RECORD_SEPARATOR);
        });
        return multipleRecord.toString();
    }

    public void resetRecord() {
        record.clear();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new StringBuilder(RECORD_START_BRACKET));
        });
    }
}