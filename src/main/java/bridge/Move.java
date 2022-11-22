package bridge;

public class Move {

    private boolean success;
    private String moveChoice;

    public Move(boolean success, String moveChoice) {
        this.success = success;
        this.moveChoice = moveChoice;
    }

    public String isSuccess() {
        if (this.success) {
            return "O";
        }
        return "X";
    }

    public String getMoveChoice() {
        return moveChoice;
    }
}
