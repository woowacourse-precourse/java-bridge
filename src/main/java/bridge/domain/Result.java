package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private static final int PATH_COUNT = 2;
    private static final String CORRECT_PATH = "O";
    private static final String WRONG_PATH = "X";
    private static final String OTHER_PATH = " ";

    private List<String> answer;
    private List<List<String>> results;

    public Result(List<String> answer) {
        this.answer = answer;
        results = new ArrayList<>();

        for (int index = 0; index < PATH_COUNT; index++) {
            results.add(new ArrayList<>());
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
            results.get(0).add(WRONG_PATH);
            results.get(1).add(OTHER_PATH);
            return;
        }

        results.get(0).add(OTHER_PATH);
        results.get(1).add(WRONG_PATH);
    }

    private void addCorrect(String place) {
        if (Direction.isUp(place)) {
            results.get(0).add(CORRECT_PATH);
            results.get(1).add(OTHER_PATH);
            return;
        }

        results.get(0).add(OTHER_PATH);
        results.get(1).add(CORRECT_PATH);

    }

    private int getCurrent() {
        return results.get(0).size();
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
        return answer.size() == results.get(0).size();
    }

    public List<List<String>> getResults() {
        return results.stream().map(result -> Collections.unmodifiableList(result))
                .collect(Collectors.toUnmodifiableList());
    }
}
