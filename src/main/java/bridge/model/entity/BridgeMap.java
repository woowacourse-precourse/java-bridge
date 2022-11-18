package bridge.model.entity;

import bridge.model.value.BridgeIngredient;

import static bridge.model.value.BridgeIngredient.*;

public class BridgeMap {
    private String upMap;
    private String downMap;
    private int index;

    private BridgeMap() {
        upMap = START.getIngredient();
        downMap =  START.getIngredient();
    }

    public int getIndex(){
        return this.index;
    }


    public static BridgeMap of() {
        return new BridgeMap();
    }


}
