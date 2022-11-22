package bridge.bridgeDomain.data;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {

    private List<String> bridge = new ArrayList<>();
    private int tryNumber = 1;
    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public void checkTryNumber() {
        tryNumber++;
    }

    public int getTryNumber() {
        return tryNumber;
    }




}
