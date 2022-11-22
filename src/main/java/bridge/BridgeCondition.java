package bridge;

import java.util.ArrayList;
import java.util.List;

public enum BridgeCondition {
    UP("U",1),
    DOWN("D", 0);

    private final String dataValue;
    private static final String SAME = "O";
    private static final String DIFF = "X";
    private final int inputValue;

    BridgeCondition(String dataValue,  int inputValue){
        this.dataValue = dataValue;
        this.inputValue = inputValue;
    }

    public String getDataValue(){
        return new String(dataValue);
    }

    public int getInputValue(){
        return inputValue;
    }

    public static BridgeCondition findByInput(int inputValue) throws IllegalArgumentException{
        for(BridgeCondition bridgeCondition : values()){
            if(bridgeCondition.getInputValue() == inputValue) {
                return bridgeCondition;
            }
        }

        throw new IllegalArgumentException("[ERROR] 입력된 다리의 상태가 올바르지 않습니다.");
    }

    public static BridgeCondition findByDataValue(String dataValue) throws IllegalArgumentException{
        for(BridgeCondition bridgeCondition : values()){
            if(bridgeCondition.getDataValue().equals(dataValue)){
                return bridgeCondition;
            }
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸의 값이 잘못되었습니다.");
    }

    public static List<String> getCompareResult(Bridge target, Bridge input){
        List<String> result = new ArrayList<>();

        for(int i = 0; i < input.size(); i++){
            if(target.get(i).equals(input.get(i)))
                result.add(SAME);
            else if(!target.get(i).equals(input.get(i)))
                result.add(DIFF);
        }

        return result;
    }
}
