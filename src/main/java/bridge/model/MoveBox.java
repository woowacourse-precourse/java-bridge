package bridge.model;

public class MoveBox {
    private final String movebox;

    public MoveBox(String userInput) {
        this.movebox = userInput;
        validate();
    }

    private void validate() {
        if (!movebox.equals("U") && !movebox.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }
    }

    public String getMovebox() {
        return movebox;
    }
}
