package bridge.model.entity;

import bridge.model.value.BridgeIngredient;
import bridge.model.value.PlayerMessage;

import java.util.ArrayList;
import java.util.List;

import static bridge.model.value.BridgeIngredient.*;
import static bridge.model.value.PlayerMessage.*;
import static bridge.model.value.PlayerMessage.BLANK;

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
        if(!UP.equals(map) && !DOWN.equals(map) && !BLANK.equals(map)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 값이 들어왔습니다. 다시 입력해주세요 : "+ map);
        }
        return;
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
