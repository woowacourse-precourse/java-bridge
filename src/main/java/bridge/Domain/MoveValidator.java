package bridge.Domain;

public class MoveValidator {
    private final String move;

    public MoveValidator(String move) {
        validate(move);
        this.move = move;
    }

    private void validate(String movingValue) {
        if (!movingValue.equals("U") && !movingValue.equals("D")) {
            throw new IllegalArgumentException("[ERROR] \"U\" 또는 \"D\"를 입력해야 합니다.");
        }
    }

    public String getMove() {
        return move;
    }
}
