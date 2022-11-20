package bridge.domain;

import java.util.List;

public class Bridge {

    private int size;
    private List<String> bridgeLoad;


    public void setBridgeSize(int size){
        this.size = size;
    }

    public int getBridgeSize(){
        return size;
    }

    public void setBridgeLoad(List<String> bridgeLoad){
        this.bridgeLoad = bridgeLoad;
    }


}
