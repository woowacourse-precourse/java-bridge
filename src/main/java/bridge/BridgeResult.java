package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final List<String> upSideIndies;
    private final List<String> downSideIndies;
    private int tryTime;

    public BridgeResult() {
        upSideIndies = new ArrayList<>();
        downSideIndies = new ArrayList<>();
        tryTime = 1;
    }

    public void addUpSideIndies(String sideIndex){
        upSideIndies.add(sideIndex);
    }

    public void addDownSideIndies(String sideIndex){
        downSideIndies.add(sideIndex);
    }

    public void removeUpSideIndies(){
        int lastIndex = upSideIndies.size() - 1;
        if (lastIndex > 0){
            upSideIndies.remove(lastIndex);
        }
    }

    public void removeDownSideIndies(){
        int lastIndex = downSideIndies.size() - 1;
        if (lastIndex > 0){
            downSideIndies.remove(lastIndex);
        }
    }

    public void plusTryTime(){
        tryTime += 1;
    }
}
