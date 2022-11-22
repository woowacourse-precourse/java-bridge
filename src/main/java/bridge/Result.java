package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final int PATH_COUNT = 2;

    private List<String> answer;
    private List<String>[] results;

    public Result(List<String> answer) {
        this.answer = answer;
        results = new ArrayList[PATH_COUNT];

        for (int index = 0; index < PATH_COUNT; index++) {
            results[index] = new ArrayList<>();
        }
    }
}
