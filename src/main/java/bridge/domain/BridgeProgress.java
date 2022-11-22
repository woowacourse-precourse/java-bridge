package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgress {
    private List<String> upperBlock;
    private List<String> lowerBlock;

    public BridgeProgress(){
        upperBlock = new ArrayList<>();
        lowerBlock = new ArrayList<>();
    }

    public Integer size(){
        return upperBlock.size();
    }

    public void put(String upperSymbol, String lowerSymbol){
        upperBlock.add(upperSymbol);
        lowerBlock.add(lowerSymbol);
    }

    public void clear(){
        upperBlock.clear();
        lowerBlock.clear();
    }

}
