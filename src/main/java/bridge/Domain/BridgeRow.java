package bridge.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeRow {
    WIDTH1(1, "U", "위"),
    WIDTH2(0, "D", "아래");

    private int number;
    private String rowPosition;
    private String rowExplain;

    private BridgeRow(int number, String rowPosition, String rowExplain){
        this.number = number;
        this.rowPosition = rowPosition;
        this.rowExplain = rowExplain;
    }

    public int getNumber(){
        return this.number;
    }

    public String getRowPosition(){
        return this.rowPosition;
    }

    public String getRowExplain(){
        return this.rowExplain;
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

    private static final Map<Integer, String> map2 =
            Stream.of(values()).collect(Collectors.toMap(BridgeRow::getNumber, BridgeRow::getRowExplain));

    public static final String getExplainUsingNumber(int number){
        return map2.get(number);
    }

    public static final int getBridgeRowNumber(){
        return (int)Arrays.stream(BridgeRow.values()).count();
    }


}
