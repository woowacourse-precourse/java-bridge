package bridge.validator;

public class ValidateCommand implements Validate {
    public final String GAME_RETRY_KEY = "R";
    public final String GAME_QUIT_KEY = "Q";

    @Override
    public void validate(String readGameCommand) {
        if (!validateCommandRange(readGameCommand)) {
            throw new IllegalArgumentException("R, Q 외의 값을 입력했습니다.");
        }
    }

    private boolean validateCommandRange(String readGameCommand) {
        return readGameCommand.equals(GAME_RETRY_KEY) || readGameCommand.equals(GAME_QUIT_KEY);
    }
}
