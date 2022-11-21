package bridge;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class MoveResult {

    private final Map<String, String> moveResult;

    public MoveResult(Map<String, String> moveResult) {
        this.moveResult = moveResult;
    }

    public Map<String, String> createPrintForm() {
        Map<String, String> printForm = new HashMap<>();
        StringJoiner separator = new StringJoiner(" | ", "[ ", " ]");
        printForm.put("U", upperPrintForm(separator));
        printForm.put("D", lowerPrintForm(separator));
        return printForm;
    }

    private String upperPrintForm(StringJoiner separator) {
        String upperResult = moveResult.get("U");
        for (int space = 0; space < upperResult.length(); space++) {
            String eachResult = "" + upperResult.charAt(space);
            separator.add(eachResult);
        }
        return separator.toString();
    }

    private String lowerPrintForm(StringJoiner separator) {
        String lowerResult = moveResult.get("D");
        for (int space = 0; space < lowerResult.length(); space++) {
            String eachResult = "" + lowerResult.charAt(space);
            separator.add(eachResult);
        }
        return separator.toString();
    }
}
