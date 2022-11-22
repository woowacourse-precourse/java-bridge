package bridge.domain;

import bridge.domain.constants.BlockSymbol;
import bridge.view.text.OutputText;

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

    public List<String> asString(){
        return List.of(String.join(BlockSymbol.BORDER.getSymbol(), upperBlock),
                String.join(BlockSymbol.BORDER.getSymbol(), lowerBlock));
    }

}
