package bridge;

import java.util.ArrayList;

public class BridgeResult {

    private int count;
    private ArrayList<String>[] result;

    public BridgeResult() {
        count = 0;
        result = null;
    }

    public void init() {
        count++;
        for (ArrayList<String> list : result) {
            list = new ArrayList<>();
        }
    }
}
