package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MovementResult {
    private static int processIndex = 0;
    protected List<String> results;

    public MovementResult() {
        results = new ArrayList<>();
    }

    public void setResults(boolean canMove) {
        results.add(processIndex, convertToString(canMove));
    }

    public void addBlank() {
        results.add(processIndex++, " ");
    }

    public void reset() {
        processIndex = 0;
        this.results.clear();
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        sentence.append("[ ");
        for (int index = 0; index < processIndex; index++) {
            if (index > 0) {
                sentence.append(" | ");
            }
            sentence.append(results.get(index));
        }
        sentence.append(" ]");
        return sentence.toString();
    }

    private String convertToString(boolean canGo) {
        if (canGo) {
            return "O";
        }
        return "X";
    }
}
