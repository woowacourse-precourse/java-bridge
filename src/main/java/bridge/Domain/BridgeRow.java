package bridge.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeRow {
    WIDTH1(1, "U"),
    WIDTH2(0, "D");

    private int number;
    private String rowPosition;

    private BridgeRow(int number, String rowPosition){
        this.number = number;
        this.rowPosition = rowPosition;
    }

    public int getNumber(){
        return this.number;
    }

    public String getRowPosition(){
        return this.rowPosition;
    }

    private static final List<String> rowPositions =
            Stream.of(BridgeRow.values()).map(BridgeRow::getRowPosition).collect(Collectors.toList());

    public static final List<String> getRowPositions(){
        return rowPositions;
    }

    private static final Map<Integer, String> map =
            Stream.of(values()).collect(Collectors.toMap(BridgeRow::getNumber, BridgeRow::getRowPosition));

    public static final String getRowUsingNumber(int number){
        return map.get(number);
    }
}
