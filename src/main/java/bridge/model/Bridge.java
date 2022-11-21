package bridge.model;

import java.util.List;

public class Bridge {
    private final int size;
    private List<String> answer;
    public Bridge(String size) {
        this.size = checkBridgeSize(size);
    }
    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public int getSize() {
        return size;
    }

    public List<String> getAnswer() {
        return this.answer;
    }
    private int checkBridgeSize(String size) {
        int num;
        if (!isNumeric(size)) {
            generateError("[ERROR] 다리길이는 숫자여야 합니다.");
        }
        num = Integer.parseInt(size);
        if (num < 3 || num > 20) {
            generateError("[ERROR] 다리길이는 3부터 20 사이의 숫자여여 합니다.");
        }
        return num;
    }
    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void generateError(String message) {
        throw new IllegalArgumentException(message);
    }
}
