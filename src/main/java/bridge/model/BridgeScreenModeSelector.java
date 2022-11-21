package bridge.model;

import bridge.model.ScreenGenerator.CorrectCaseGenerator;
import bridge.model.ScreenGenerator.ScreenGenerator;
import bridge.model.ScreenGenerator.WrongCaseGenerator;
import java.util.List;

public class BridgeScreenModeSelector {

    private final List<String> answer;
    private final int current;
    private final int printCase;
    private static final int REACHED_END = 1;
    private static final int COMPARE_SAME = 2;
    private static final int COMPARE_DIFFERENT = 3;

    BridgeScreenModeSelector(List<String> answer, int current, int printCase) {
        this.answer = answer;
        this.current = current;
        this.printCase = printCase;
    }

    public ScreenGenerator generateOutputScreen() {
        ScreenGenerator screenGenerator = correctGeneratorCase();
        if (screenGenerator != null) {
            return screenGenerator;
        }
        ScreenGenerator screenGenerator1 = wrongGeneratorCase();
        if (screenGenerator1 != null) {
            return screenGenerator1;
        }
        throw new IllegalArgumentException("screen mode is invalid");
    }

    private ScreenGenerator wrongGeneratorCase() {
        if (printCase == COMPARE_DIFFERENT) {
            ScreenGenerator screenGenerator = new WrongCaseGenerator();
            screenGenerator.generatedTable(answer, current);
            return screenGenerator;
        }
        return null;
    }

    private ScreenGenerator correctGeneratorCase() {
        if (printCase == COMPARE_SAME || printCase == REACHED_END) {
            ScreenGenerator screenGenerator = new CorrectCaseGenerator();
            screenGenerator.generatedTable(answer, current);
            return screenGenerator;
        }
        return null;
    }
}
