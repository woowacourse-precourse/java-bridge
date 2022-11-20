package bridge.domain;

import bridge.constant.BridgeDirection;
import bridge.constant.CrossingState;

import java.util.*;

public class GameAgent{

    private List<String> bridge;

    public GameAgent(){
        this.bridge=new ArrayList<>();
    }

    public void initialize(List<String> bridge){
        this.bridge=bridge;
    }
    


}
