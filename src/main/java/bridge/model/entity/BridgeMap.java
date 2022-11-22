package bridge.model.entity;

import bridge.model.value.BridgeIngredient;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.value.BridgeIngredient.*;
import static bridge.model.value.ErrorMessage.BRIDGEMAP_ERROR;
import static bridge.model.value.ErrorMessage.getMessage;

public class BridgeMap {
    private final List<String> upMap = new ArrayList<>();
    private final List<String> downMap = new ArrayList<>();
    private int index = 0;

    public int getIndex(){  //TODO: Index 없앨수 있음 나중에 제거할 것
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void add(String upMap, String downMap){
        validate(upMap);
        validate(downMap);
        this.upMap.add(upMap);
        this.downMap.add(downMap);
    }
    public void validate(String map){
        if(BridgeIngredient.contains(map)){
            return;
        }
        throw new IllegalArgumentException(getMessage(BRIDGEMAP_ERROR));
    }

    public List<String> getUpMap() {
        return upMap;
    }

    public List<String> getDownMap() {
        return downMap;
    }

    public static BridgeMap of() {
        return new BridgeMap();
    }


}
