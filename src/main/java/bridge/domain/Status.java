package bridge.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Status {
    private Map<String, StringBuilder> status = new HashMap<>();
    private String message;


    Status() {
        status.put("U", new StringBuilder("[ "));
        status.put("D", new StringBuilder("[ "));
    }


    public void updateStatus(String answer, String userAnswer) {
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
        status.get("U").append(" ]");
        status.get("D").append(" ]");
        message = status.get("U") + "\n" + status.get("D");
        undoStatus(2);
        addDelimiter();
    }

    public String getMessage() {
        return message;
    }

    public void undoStatus(int deleteSize) {
        status.get("U").setLength(status.get("U").length() - deleteSize);
        status.get("D").setLength(status.get("D").length() - deleteSize);
    }

    private void addCorrect(String idx) {
        status.get(idx).append("O");
        addBlank(idx);
    }

    private void addWrong(String idx) {
        status.get(idx).append("X");
        addBlank(idx);
    }

    private void addBlank(String idx) {
        if(Objects.equals(idx, "D")){
            status.get("U").append(" ");
            return;
        }
        status.get("D").append(" ");
    }

    private void addDelimiter() {
        status.get("U").append(" | ");
        status.get("D").append(" | ");
    }
}
