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

    public String getResult(int resultIndex) {
        return String.join("",
                List.of(upperResult.get(resultIndex), lowerResult.get(resultIndex))
        );
    }
}
