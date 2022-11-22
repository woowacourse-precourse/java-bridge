package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final String SUCCESS = "O";
    private final String FAIL = "X";
    private final String EMPTY = " ";

    private final List<List<String>> map;

    public BridgeMap() {
        this.map = new ArrayList<>();
    }

    public void updateMap(int moving, boolean isAnswer) {
        List<String> partition = new ArrayList<>(List.of(EMPTY, EMPTY));
        String mark = createMark(isAnswer);
        partition.set(moving, mark);
        this.map.add(partition);
    }

    private String createMark(boolean isAnswer) {
        if (isAnswer)
            return SUCCESS;
        return FAIL;
    }

    public List<List<String>> getMap() {
        return this.map;
    }
}
