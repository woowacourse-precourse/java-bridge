package bridge.model;

import bridge.model.ScreenGenerator.CorrectCaseGenerator;
import bridge.model.ScreenGenerator.ScreenGenerator;
import bridge.model.ScreenGenerator.WrongCaseGenerator;
import java.util.List;

public class BridgeScreenModeSelector {


    private static final int REACHED_END = 1;
    private static final int COMPARE_SAME = 2;
    private static final int COMPARE_DIFFERENT = 3;

    private final List<String> answer;
    private final int current;
    private final int printCase;

    BridgeScreenModeSelector(final List<String> answer,final  int current, final int printCase) {
        this.answer = answer;
        this.current = current;
        this.printCase = printCase;
    }

    public ScreenGenerator generateOutputScreen() {
        if (correctGeneratorCase() != null) {
            return correctGeneratorCase();
        }
        if (wrongGeneratorCase() != null) {
            return wrongGeneratorCase();
        }
        return null;
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
