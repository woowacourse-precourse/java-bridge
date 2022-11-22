package bridge.domain;

import bridge.domain.type.BridgeLineType;
import bridge.domain.type.MoveResultType;

import java.util.*;

public class MoveRecord {
    final static String NOT_CROSSED = " ";
    final static String BRIDGE_PIECE_SEPARATOR = " | ";
    final static String RECORD_START_BRACKET = "[ ";
    final static String RECORD_END_BRACKET = " ]";
    final static String RECORD_SEPARATOR = "\n";
    private final Map<BridgeLineType, List<String>> record;

    public MoveRecord() {
        record = new HashMap<>();
        Arrays.stream(BridgeLineType.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }

    private void recordOneLine(BridgeLineType bridgeLineType, String bridgePieceState) {
        record.get(bridgeLineType).add(bridgePieceState);
    }

    public void recordMovement(MoveResultType moveResultType, String moveCommand) {
        BridgeLineType bridgeLineTypeToMove = BridgeLineType.findByCommand(moveCommand);
        recordOneLine(bridgeLineTypeToMove, moveResultType.getSymbol());
        record.keySet().stream()
                .filter(bridgeLine -> !bridgeLine.equals(bridgeLineTypeToMove))
                .forEach(bridgeLine -> recordOneLine(bridgeLine, NOT_CROSSED));
    }

    public String getRecord(BridgeLineType bridgeLineType) {
        return RECORD_START_BRACKET + String.join(BRIDGE_PIECE_SEPARATOR, record.get(bridgeLineType)) + RECORD_END_BRACKET;
    }

    public String getRecord() {
        List<String> multipleRecord = new ArrayList<>();
        Arrays.stream(BridgeLineType.values()).forEach(bridgeLine -> {
            multipleRecord.add(getRecord(bridgeLine));
        });
        return String.join(RECORD_SEPARATOR, multipleRecord);
    }

    public void resetRecord() {
        record.clear();
        Arrays.stream(BridgeLineType.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }
}