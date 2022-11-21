package bridge.Domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BridgeWidth {
    WIDTH1(1, "U"),
    WIDTH2(0, "D");

    private int number;
    private String rowPosition;

    private BridgeWidth(int number, String rowPosition){
        this.number = number;
        this.rowPosition = rowPosition;
    }

    public int getNumber(){
        return this.number;
    }

    public String getRowPosition(){
        return this.rowPosition;
    }

    private static final Map<Integer, String> map =
            Stream.of(values()).collect(Collectors.toMap(BridgeWidth::getNumber, BridgeWidth::getRowPosition));

    private static final String getRowUsingNumber(int number){
        return map.get(number);
    }
}
