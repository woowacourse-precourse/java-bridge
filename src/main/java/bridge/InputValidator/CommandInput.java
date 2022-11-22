package bridge.InputValidator;

import java.util.Objects;

public class CommandInput {
    private String commandInput;

    public CommandInput(String commandInput) {
        this.commandInput = commandInput;
        validateCommandInput();
    }

    public String getCommandInput() {
        return commandInput;
    }

    public Boolean isCommandRestart() {
        return Objects.equals(this.commandInput, "R");
    }

    public Boolean isCommandQuit() {
        return Objects.equals(this.commandInput, "Q");
    }

    private void validateCommandInput() {
        if (!(Objects.equals(commandInput, "R")) && !(Objects.equals(commandInput, "Q"))) {
            throw new IllegalArgumentException("[ERROR] : 게임 커맨드 입력은 'R' 또는 'Q' 가 입력되어야 합니다.");
        }
    }
}
