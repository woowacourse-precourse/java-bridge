package bridge.model;

import bridge.model.ScreenGenerator.CorrectCaseGenerator;
import bridge.model.ScreenGenerator.ScreenGenerator;
import bridge.model.ScreenGenerator.WrongCaseGenerator;
import java.util.List;

public class BridgeScreenModeSelector {

    private final List<String> answer;
    private final int current;
    private final int printCase;

    BridgeScreenModeSelector(List<String> answer, int current, int printCase) {
        this.answer = answer;
        this.current = current;
        this.printCase = printCase;
    }

    public String generateOutputScreen() {

        if (printCase == 2 || printCase == 1) {
            ScreenGenerator screenGenerator = new CorrectCaseGenerator();
            return (screenGenerator.generatedTable(answer, current));
        } else if (printCase == 3) {
            ScreenGenerator screenGenerator = new WrongCaseGenerator();
            return (screenGenerator.generatedTable(answer, current));
        }
        return null;
    }
}
