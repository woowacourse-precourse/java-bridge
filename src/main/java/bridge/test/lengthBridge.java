package bridge.test;

public class lengthBridge {

    private final int length;

    public lengthBridge(String userInput) {
        validate(userInput);
        this.length = Integer.parseInt(userInput);
    }

    public void validate(String s) {
        if (!s.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 입력 값입니다.");
        }
    }

    public int getLength() {
        return length;
    }

}
