package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final int EMPTY = 0;
    private final List<String> upStairs;
    private final List<String> downsStairs;

    public Result() {
        this.upStairs = new ArrayList<>();
        this.downsStairs = new ArrayList<>();
    }

    public void addUpstairs() {
        upStairs.add(" O ");
        downsStairs.add("   ");
    }
}
