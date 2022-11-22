package bridge.domain;

import bridge.domain.type.MoveResultType;
import bridge.domain.type.MoveType;

import java.util.*;

public class MoveRecord {
    final static String NOT_CROSSED = " ";
    final static String BRIDGE_PIECE_SEPARATOR = " | ";
    final static String RECORD_START_BRACKET = "[ ";
    final static String RECORD_END_BRACKET = " ]";
    final static String RECORD_SEPARATOR = "\n";
    private final Map<MoveType, List<String>> record;

    public MoveRecord() {
        record = new HashMap<>();
        Arrays.stream(MoveType.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }

    private void recordOneLine(MoveType moveType, String bridgePieceState) {
        record.get(moveType).add(bridgePieceState);
    }

    public void recordMovement(MoveResultType moveResultType, String moveCommand) {
        MoveType moveTypeToMove = MoveType.findByCommand(moveCommand);
        recordOneLine(moveTypeToMove, moveResultType.getSymbol());
        record.keySet().stream()
                .filter(bridgeLine -> !bridgeLine.equals(moveTypeToMove))
                .forEach(bridgeLine -> recordOneLine(bridgeLine, NOT_CROSSED));
    }

    public String getRecord(MoveType moveType) {
        return RECORD_START_BRACKET + String.join(BRIDGE_PIECE_SEPARATOR, record.get(moveType)) + RECORD_END_BRACKET;
    }

    public String getRecord() {
        List<String> multipleRecord = new ArrayList<>();
        Arrays.stream(MoveType.values()).forEach(bridgeLine -> {
            multipleRecord.add(getRecord(bridgeLine));
        });
        return String.join(RECORD_SEPARATOR, multipleRecord);
    }

    public void resetRecord() {
        record.clear();
        Arrays.stream(MoveType.values()).forEach(bridgeLine -> {
            record.put(bridgeLine, new ArrayList<>());
        });
    }
}