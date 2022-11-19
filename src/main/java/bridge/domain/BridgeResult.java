package bridge.domain;

import java.util.List;

public class BridgeResult {

    private List<String> upSpace;
    private List<String> downSpace;

    public BridgeResult(List<String> upSpace, List<String> downSpace){
        this.upSpace = upSpace;
        this.downSpace =downSpace;
    }

    public void recordResult(String movingResult, String moving) {
        if(moving.equals("U")){
            upSpace.add(movingResult);
            downSpace.add(" ");
            return;
        }
        downSpace.add(movingResult);
        upSpace.add(" ");

    }

    public List<String> getUpSpace() {
        return upSpace;
    }

    public List<String> getDownSpace() {
        return downSpace;
    }

}
