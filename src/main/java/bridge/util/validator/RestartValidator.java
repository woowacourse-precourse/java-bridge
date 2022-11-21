package bridge.util.validator;

import bridge.util.Validator;

import static bridge.util.validator.BlankValidator.isBlank;

public class RestartValidator implements Validator {
    private final String RESTART = "R";
    private final String QUIT = "Q";
    private final String BLANK_ERROR = "[ERROR] 값을 입력해주세요.";
    private final String R_Q_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력해주세요.";

    @Override
    public String validate(String input) {
        isBlank(input, BLANK_ERROR);
        isRorQ(input);
        return input;
    }

    private void isRorQ(String restart) {
        if (!restart.equals(RESTART) && !restart.equals(QUIT)) {
            throw new IllegalArgumentException(R_Q_ERROR);
        }
    }
}
