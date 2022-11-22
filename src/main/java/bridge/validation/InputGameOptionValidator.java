package bridge.validation;

import static bridge.constant.GameOption.isGameOptionExist;

public class InputGameOptionValidator {

    private static final String INVALID_GAME_OPTION = "재시도는 'R', 종료는 'Q'로 입력해야 합니다.";

    public static void validateInputGameOption(String gameOption) {
        if (!isGameOptionExist(gameOption)) {
            throw new IllegalArgumentException(INVALID_GAME_OPTION);
        }
    }
}