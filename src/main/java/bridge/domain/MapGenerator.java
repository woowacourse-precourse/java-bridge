package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class MapGenerator {

    private MapGenerator(){}

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String DELIMITER = " | ";
    private static final String NEWLINE = "\n";

    public static String generateMap(List<Record> history) {
        String upperRow = generateRow(BridgeCell.UP, history);
        String lowerRow = generateRow(BridgeCell.DOWN, history);
        return concatRow(upperRow, lowerRow);
    }

    private static String generateRow(BridgeCell direction, List<Record> history) {
        return history.stream()
                .map(record -> MapSignature.getSignatureFromRecord(record, direction))
                .collect(Collectors.joining(DELIMITER, BRIDGE_START, BRIDGE_END));
    }

    private static String concatRow(String upperRow, String lowerRow) {
        return upperRow + NEWLINE + lowerRow;
    }

}
