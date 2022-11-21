package bridge.domain;

public class Choice {
    private String input;
    private String isRight;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getIsRight() {
        return isRight;
    }

    public Choice(String input, String isRight) {
        this.input = input;
        this.isRight = isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
}
