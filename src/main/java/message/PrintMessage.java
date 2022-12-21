package message;

public enum PrintMessage {
    START_BRACKET("["),
    END_BRACKET("]"),

    MOVE_U_COMMAND("U"),
    MOVE_D_COMMAND("D"),
    RETRY_R_COMMAND("R"),
    RETRY_Q_COMMAND("Q"),

    CORRECT_ANSWER("O"),
    WRONG_ANSWER("X"),

    BLACK(" "),

    DIVIDING_LINE(" | ");

    private String status;

    PrintMessage(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
