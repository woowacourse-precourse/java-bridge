package bridge.domain.resources.bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BridgeMap {

    private final List<String> bridgeMap;
    private final AtomicInteger inputCount;
    private boolean flag;

    public BridgeMap() {
        this.bridgeMap = new ArrayList<>();
        this.inputCount = new AtomicInteger(0);
        flag = true;
    }

    public void clearBridgeMap() {
        bridgeMap.clear();
        inputCount.set(0);
        flagUp();
    }

    public void add(String upOrDown) {
        bridgeMap.add(upOrDown);
    }

    public void countUp() {
        inputCount.getAndIncrement();
    }

    public void flagUp() {
        flag = true;
    }

    public void flagDown() {
        flag = false;
    }

    public List<String> getBridgeMap() {
        return bridgeMap;
    }

    public AtomicInteger getInputCount() {
        return inputCount;
    }

    public boolean getFlag() {
        return flag;
    }
//
//    @Override
//    public String toString(){
//
//        //답을담아
//        return ;
//
//    }
}
