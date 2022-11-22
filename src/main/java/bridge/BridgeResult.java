package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private List<String> upperResult = new ArrayList<>();
    private List<String> lowerResult = new ArrayList<>();

    public void saveCorrectStep(String step) {
        if (step.equals("U")) {
            upperResult.add("O");
            lowerResult.add(" ");
        }

        if (step.equals("D")) {
            lowerResult.add("O");
            upperResult.add(" ");
        }
    }

    public void saveWrongStep(String step) {
        if (step.equals("U")) {
            upperResult.add("X");
            lowerResult.add(" ");
        }

        if (step.equals("D")) {
            lowerResult.add("X");
            upperResult.add(" ");
        }
    }

    public List<String> getUpperResult() {
        return upperResult;
    }

    public List<String> getLowerResult() {
        return lowerResult;
    }

    public void deleteWrongStep() {
        int deleteIndex = upperResult.size() - 1;

        upperResult.remove(deleteIndex);
        lowerResult.remove(deleteIndex);
    }
}
