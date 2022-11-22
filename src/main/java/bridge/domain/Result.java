package bridge.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private static final int PATH_COUNT = 2;
    private static final String CORRECT_PATH = "O";
    private static final String WRONG_PATH = "X";
    private static final String OTHER_PATH = " ";

    private List<String> answer;
    private List<String>[] results;

    public Result(List<String> answer) {
        this.answer = answer;
        results = new ArrayList[PATH_COUNT];

        for (int index = 0; index < PATH_COUNT; index++) {
            results[index] = new ArrayList<>();
        }
    }

    public void add(String place) {
        if (isCorrect(place)) {
            addCorrect(place);
            return;
        }

        addIncorrect(place);
    }

    private boolean isCorrect(String place) {
        int current = getCurrent();
        return answer.get(current).equals(place);
    }

    private void addIncorrect(String place) {
        if (Direction.isUp(place)) {
            results[0].add(WRONG_PATH);
            results[1].add(OTHER_PATH);
            return;
        }

        results[0].add(OTHER_PATH);
        results[1].add(WRONG_PATH);
    }

    private void addCorrect(String place) {
        if (Direction.isUp(place)) {
            results[0].add(CORRECT_PATH);
            results[1].add(OTHER_PATH);
            return;
        }

        results[0].add(OTHER_PATH);
        results[1].add(CORRECT_PATH);
    }

    public int getCurrent() {
        return results[0].size();
    }

    public void clear() {
        for (List<String> result : results) {
            result.clear();
        }
    }

    public boolean hasFail() {
        for (List<String> r : results) {
            if (r.contains(WRONG_PATH)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSameLength() {
        return answer.size() == results[0].size();
    }

    public List<List<String>> getResults() {
        return Arrays.stream(results).collect(Collectors.toUnmodifiableList());
    }
}
