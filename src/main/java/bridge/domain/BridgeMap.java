package bridge.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BridgeMap {
    private final Map<String, StringBuilder> bridgeMap = new HashMap<>();
    private String message;

    public BridgeMap() {
        bridgeMap.put("U", new StringBuilder("[ "));
        bridgeMap.put("D", new StringBuilder("[ "));
    }

    public void updateBridgeMap(String answer, String userAnswer) {
        if(Objects.equals(answer, userAnswer)) {
            addCorrect(userAnswer);
            addDelimiter();
            return;
        }
        addWrong(userAnswer);
        addDelimiter();
    }

    public void createMessage() {
        undoStatus(3);
        bridgeMap.get("U").append(" ]");
        bridgeMap.get("D").append(" ]");
        message = bridgeMap.get("U") + "\n" + bridgeMap.get("D") + "\n";
        undoStatus(2);
        addDelimiter();
    }

    public String getMessage() {
        return message;
    }

    public void undoStatus(int deleteSize) {
        bridgeMap.get("U").setLength(bridgeMap.get("U").length() - deleteSize);
        bridgeMap.get("D").setLength(bridgeMap.get("D").length() - deleteSize);
    }

    private void addCorrect(String idx) {
        bridgeMap.get(idx).append("O");
        addBlank(idx);
    }

    private void addWrong(String idx) {
        bridgeMap.get(idx).append("X");
        addBlank(idx);
    }

    private void addBlank(String idx) {
        if(Objects.equals(idx, "D")){
            bridgeMap.get("U").append(" ");
            return;
        }
        bridgeMap.get("D").append(" ");
    }

    private void addDelimiter() {
        bridgeMap.get("U").append(" | ");
        bridgeMap.get("D").append(" | ");
    }
}
