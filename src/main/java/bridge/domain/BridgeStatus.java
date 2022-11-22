package bridge.domain;

import java.util.HashMap;
import java.util.Map;


public class BridgeStatus {
    private final Map<String, StringBuilder> bridgeStatus = new HashMap<>();
    private String message;
    private boolean success;

    public BridgeStatus() {
        bridgeStatus.put("U", new StringBuilder("[ "));
        bridgeStatus.put("D", new StringBuilder("[ "));
        success = true;
    }

    public boolean getSuccess() {return success;}

    public String getMessage() {
        return message;
    }

    public void updateBridgeMap(
            final String answer,
            final String userAnswer
    ) {
        if(answer.equals(userAnswer)) {
            addCorrect(userAnswer);
            return;
        }
        addWrong(userAnswer);
    }

    public void createMessage() {
        undoStatus(3);
        bridgeStatus.get("U").append(" ]");
        bridgeStatus.get("D").append(" ]");
        message = bridgeStatus.get("U") + "\n" + bridgeStatus.get("D") + "\n";
        undoStatus(2);
        addDelimiter();
    }

    public void undoStatus(final int deleteSize) {
        bridgeStatus.get("U").setLength(bridgeStatus.get("U").length() - deleteSize);
        bridgeStatus.get("D").setLength(bridgeStatus.get("D").length() - deleteSize);
    }

    private void addCorrect(final String idx) {
        bridgeStatus.get(idx).append("O");
        addBlank(idx);
        addDelimiter();
    }

    private void addWrong(final String idx) {
        bridgeStatus.get(idx).append("X");
        addBlank(idx);
        addDelimiter();
        success = false;
    }

    private void addBlank(final String idx) {
        if("D".equals(idx)){
            bridgeStatus.get("U").append(" ");
            return;
        }
        bridgeStatus.get("D").append(" ");
    }

    private void addDelimiter() {
        bridgeStatus.get("U").append(" | ");
        bridgeStatus.get("D").append(" | ");
    }

    public void reset() {
        bridgeStatus.get("U").setLength(2);
        bridgeStatus.get("D").setLength(2);
        success = true;
    }
}
