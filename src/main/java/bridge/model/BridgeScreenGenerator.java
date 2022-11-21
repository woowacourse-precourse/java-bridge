package bridge.model;

import bridge.model.ScreenGenerator.CorrectCaseGenerator;
import java.util.List;

public class BridgeScreenGenerator {

    private List<String> answer;
    private int current;
    private int printCase;

    BridgeScreenGenerator (List<String> answer, int current, int printCase) {
        this.answer = answer;
        this.current = current;
        this.printCase = printCase;
    }

    public String generateOutputScreen() {
        if (printCase == 2 || printCase == 1) {
            CorrectCaseGenerator correctCaseGenerator = new CorrectCaseGenerator(answer, current);
            return correctCaseGenerator.generatedTable();
        } else if (printCase == 3) {
            return generateOutputScreenError();
        }
        return null;
    }

    public String generateOutputScreenCorrect() {
        StringBuilder sb1 = new StringBuilder("[");
        StringBuilder sb2 = new StringBuilder("[");
        for (int i = 0; i <= current; i++) {
            if (answer.get(i).equals("U")) {
                sb1.append(" O ");
                sb2.append("   ");
            } else if (answer.get(i).equals("D")) {
                sb1.append("   ");
                sb2.append(" O ");
            }
            if (i != current) {
                sb1.append("|");
                sb2.append("|");
            }
        }
        sb1.append("]");
        sb2.append("]");
        sb1.append("\n");
        sb1.append(sb2);
        return sb1.toString();
    }

    public String generateOutputScreenError()
    {
        StringBuilder sb1 = new StringBuilder("[");
        StringBuilder sb2 = new StringBuilder("[");

        for (int i = 0; i < current; i++) {
            if (answer.get(i).equals("U")) {
                sb1.append(" O ");
                sb2.append("   ");
            } else if (answer.get(i).equals("D")) {
                sb1.append("   ");
                sb2.append(" O ");
            }
                sb1.append("|");
                sb2.append("|");
        }
        if (answer.get(current).equals("U")) {
            sb1.append("   ]");
            sb2.append(" X ]");
        } else if (answer.get(current).equals("D")) {
            sb1.append(" X ]");
            sb2.append("   ]");
        }
        sb1.append("\n");
        sb1.append(sb2);
        return sb1.toString();
    }
}
