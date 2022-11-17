package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MovementResult {
    private static int processIndex = 0;
    protected List<String> results;

    public MovementResult() {
        results = new ArrayList<>();
    }

    public void setResults(boolean canGo) {
        results.add(processIndex, convertToString(canGo));
    }

    public void addBlank() {
        results.add(processIndex++, " ");
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
