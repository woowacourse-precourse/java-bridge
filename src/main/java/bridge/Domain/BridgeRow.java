package bridge.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeRow {
    BRIDGE_ROW1(1, "U", "위"),
    BRIDGE_ROW2(0, "D", "아래");

    private int rowNumber;
    private String rowName;
    private String rowNameExplain;

    private BridgeRow(int rowNumber, String rowName, String rowNameExplain){
        this.rowNumber = rowNumber;
        this.rowName = rowName;
        this.rowNameExplain = rowNameExplain;
    }

    public int getRowNumber(){
        return this.rowNumber;
    }

    public String getRowName(){
        return this.rowName;
    }

    public String getRowNameExplain(){
        return this.rowNameExplain;
    }

    private static final List<String> rowNames =
            Stream.of(BridgeRow.values()).map(BridgeRow::getRowName).collect(Collectors.toList());

    public static final List<String> getRowNames(){
        return rowNames;
    }

    private static final Map<Integer, String> mapRowNumberAndRowName =
            Stream.of(values()).collect(Collectors.toMap(BridgeRow::getRowNumber, BridgeRow::getRowName));

    public static final String getRowNameUsingRowNumber(int rowNumber){
        return mapRowNumberAndRowName.get(rowNumber);
    }

    private static final Map<Integer, String> mapRowNumberAndRowNameExplain =
            Stream.of(values()).collect(Collectors.toMap(BridgeRow::getRowNumber, BridgeRow::getRowNameExplain));

    public static final String getRowNameExplainUsingRowNumber(int rowNumber){
        return mapRowNumberAndRowNameExplain.get(rowNumber);
    }

    public static final int getBridgeRowSize(){
        return (int)Arrays.stream(BridgeRow.values()).count();
    }

}
