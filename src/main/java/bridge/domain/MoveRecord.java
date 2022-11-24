package bridge.domain;

import bridge.domain.type.MoveResultType;
import bridge.domain.type.MoveType;

import java.util.*;

public class MoveRecord {
    static final String NOT_CROSSED = " ";
    static final String BRIDGE_PIECE_SEPARATOR = " | ";
    static final String RECORD_START_BRACKET = "[ ";
    static final String RECORD_END_BRACKET = " ]";
    static final String RECORD_SEPARATOR = "\n";
    private final Map<MoveType, List<String>> record;

    public MoveRecord() {
        record = Arrays.stream(MoveType.values()).collect(HashMap::new, (map, moveType) ->
                map.put(moveType, new ArrayList<>()), HashMap::putAll);
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