package bridge.model;

public class LengthBridge {
    private final int length;

    public LengthBridge(String userInput) {
        validate(userInput);
        this.length = Integer.parseInt(userInput);
    }

    public void validate(String s) {
        checkNumbers(s);
        checkrange(s);
    }

    private void checkNumbers(String s) {
        if (!s.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력 값입니다.");
        }
    }

    private void checkrange(String s) {
        int userinput = Integer.parseInt(s);
        if (userinput < 3 || userinput > 20) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자가 아닙니다.");
        }
    }

    public int getLength() {
        return length;
    }
}
