package bridge;

import java.util.ArrayList;
import java.util.Arrays;

public class BridgeResult {

    private int count;
    private ArrayList<String>[] result;

    public BridgeResult() {
        count = 0;
        result = new ArrayList[BridgeCell.values().length];
    }

    public void init() {
        count++;
        Arrays.stream(result).forEach(
                list -> list = new ArrayList<>()
        );
    }
}
