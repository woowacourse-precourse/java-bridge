package bridge;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MoveResult {

    private final Map<String, String> moveResult;

    public MoveResult(Map<String, String> moveResult) {
        this.moveResult = moveResult;
    }

    public void printMap() {
        OutputView.printMap(createMap());
    }

    private Map<String, String> createMap() {
        Map<String, String> printForm = new HashMap<>();
        printForm.put("U", upperPrintForm());
        printForm.put("D", lowerPrintForm());
        return printForm;
    }

    private String upperPrintForm() {
        StringJoiner separator = new StringJoiner(" | ", "[ ", " ]");
        String upperResult = moveResult.get("U");
        for (int space = 0; space < upperResult.length(); space++) {
            String eachResult = "" + upperResult.charAt(space);
            separator.add(eachResult);
        }
        return separator.toString();
    }

    private String lowerPrintForm() {
        StringJoiner separator = new StringJoiner(" | ", "[ ", " ]");
        String lowerResult = moveResult.get("D");
        for (int space = 0; space < lowerResult.length(); space++) {
            String eachResult = "" + lowerResult.charAt(space);
            separator.add(eachResult);
        }
        return separator.toString();
    }
}
