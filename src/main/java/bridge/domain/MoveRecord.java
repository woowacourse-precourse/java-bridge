package bridge.domain;

import java.util.*;

public class MoveRecord {
    final static String NOT_CROSSED = " ";
    final static String BRIDGE_PIECE_SEPARATOR = " | ";
    final static String RECORD_START_BRACKET = "[ ";
    final static String RECORD_END_BRACKET = " ]";
    final static String RECORD_SEPARATOR = "\n";
    private final Map<BridgeLine, List<String>> record;

    public MoveRecord() {
        record = new HashMap<>();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }

    private void recordOneLine(BridgeLine bridgeLine, String bridgePieceState) {
        record.get(bridgeLine).add(bridgePieceState);
    }

    public void recordMovement(MoveResult moveResult, String moveCommand) {
        BridgeLine bridgeLineToMove = BridgeLine.findByCommand(moveCommand);
        recordOneLine(bridgeLineToMove, moveResult.getSymbol());
        record.keySet().stream()
                .filter(bridgeLine -> !bridgeLine.equals(bridgeLineToMove))
                .forEach(bridgeLine -> recordOneLine(bridgeLine, NOT_CROSSED));
    }

    public String getRecord(BridgeLine bridgeLine) {
        return RECORD_START_BRACKET + String.join(BRIDGE_PIECE_SEPARATOR, record.get(bridgeLine)) + RECORD_END_BRACKET;
    }

    public String getRecord() {
        List<String> multipleRecord = new ArrayList<>();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            multipleRecord.add(getRecord(bridgeLine));
        });
        return String.join(RECORD_SEPARATOR, multipleRecord);
    }

    public void resetRecord() {
        record.clear();
        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }
}