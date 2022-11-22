package bridge.model.entity;

import bridge.model.value.BridgeIngredient;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.value.BridgeIngredient.*;

public class BridgeMap {
    private final List<String> upMap = new ArrayList<>();
    private final List<String> downMap = new ArrayList<>();
    private int index = 0;

    public int getIndex(){  //TODO: Index 없앨수 있음 나중에 제거할 것
        return this.index;
    }
    public void setIndex(int index){
        validate(index);
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
        throw new IllegalArgumentException("[ERROR] 맵에 생성될 인자가 유효하지 않습니다:" + map);
    }

    public List<String> getUpMap() {
        return upMap;
    }

    public List<String> getDownMap() {
        return downMap;
    }

    public void validate(int index) {

    }
    public static BridgeMap of() {
        return new BridgeMap();
    }


}
