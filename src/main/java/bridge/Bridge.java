package bridge.model;

import java.util.*;

public class Bridge {
    private List<String> list;

    public Bridge(List<String> list){
        this.list = list;
    }

    public boolean isToCross(String moving, int count) {
        if(list.get(count).equals(moving)) {
            return true;
        }
        return false;
    }

    public void printBridge() {

    }
}
