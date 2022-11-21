package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public enum MapGenerator {

    SUCCESS("O"),
    FAIL("X"),
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    DELIMITER(" | "),
    BLANK(" "),
    NEWLINE("\n"),
    ;

    private final String sign;

    MapGenerator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static String generateMap(List<Record> history) {
        String upperRow = generateRow(BridgeCell.UP, history);
        String lowerRow = generateRow(BridgeCell.DOWN, history);
        return concatRow(upperRow, lowerRow);
    }

    private static String generateRow(BridgeCell direction, List<Record> history) {
        return history.stream()
                .map(record -> recordToSignature(record, direction))
                .map(MapGenerator::getSign)
                .collect(Collectors.joining(DELIMITER.sign, BRIDGE_START.sign, BRIDGE_END.sign));
    }

    private static String concatRow(String upperRow, String lowerRow) {
        return upperRow + NEWLINE.sign + lowerRow;
    }

    private static MapGenerator recordToSignature(Record record, BridgeCell direction) {
        if (!record.sameDirection(direction)) {
            return BLANK;
        }

        if (record.isSuccess()) {
            return SUCCESS;
        }

        return FAIL;
    }

}
