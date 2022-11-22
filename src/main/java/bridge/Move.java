package bridge;

public class Move {
    private String move;

    public Move(String move) {
        this.move = checkMove(move);
    }

    public String getMove() {
        return move;
    }

    private String checkMove(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            generateError("[ERROR] 이동 명령어는 U나 D여야 합니다.");
        }
        return input;
    }

    private void generateError(String message) {
        throw new IllegalArgumentException(message);
    }
}
