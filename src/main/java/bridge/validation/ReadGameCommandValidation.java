package bridge.validation;

public class ReadGameCommandValidation {
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    public void validateInputFormat(String gameCommand) {
        if ((! gameCommand.equals(RESTART_COMMAND)) && (! gameCommand.equals(QUIT_COMMAND))) {
            throw new IllegalArgumentException("[ERROR] 재시작, 종료 여부를 R 또는 Q로 입력해주세요.");
        }
    }
}
