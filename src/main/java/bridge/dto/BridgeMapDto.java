package bridge.dto;

import bridge.model.entity.BridgeMap;

import java.util.ArrayList;
import java.util.List;

public class BridgeMapDto {
    private List<String> upMap = new ArrayList<>();
    private List<String> downMap = new ArrayList<>();

    public List<String> getUpMap() {
        return upMap;
    }
    public List<String> getDownMap() {
        return downMap;
    }

    private BridgeMapDto(BridgeMap map) {
        this.upMap = map.getUpMap();
        this.downMap = map.getDownMap();
    }

    public static BridgeMapDto of(BridgeMap map){
        return new BridgeMapDto(map);
    }

}
