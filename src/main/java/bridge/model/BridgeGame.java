package bridge.model;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private int tryNumber;
    private int nowLocation;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
        this.tryNumber = 1;
        this.nowLocation = 0;
    }

    public boolean move(String input) {
        if(input.equals(bridge.get(nowLocation))){
            nowLocation++;
            return true;
        }
        return false;
    }

    public boolean checkSuccess(){
        return nowLocation == bridge.size();
    }

    public int getTryNumber(){
        return tryNumber;
    }

    public void retry() {
        tryNumber++;
        nowLocation =0 ;
    }
}
