package bridge.ui;

import static bridge.ui.UiErrorMessage.*;

public class ValidateInputBridgeGame implements ValidateInput {

    private static final String UPPER = "U";
    private static final String LOWER = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    /**
     * 검증 로직 : 숫자가 맞는지 검증한다.
     */
    public void validateNumber(String inputValue) {
        for (int i = 0; i < inputValue.length(); ++i) {
            if (Character.isDigit(inputValue.charAt(i))) {
                continue;
            }
            throw new IllegalArgumentException(BRIDGE_LENGTH_NUMBER_ERROR.getMessage());
        }
    }

    /**
     * 검증 로직 : 다리 길이가 일의 자리와 십의 자리 사이인지 검증한다.
     */
    public void validateBridgeSizeLength(String bridgeSizeInput) {
        if (bridgeSizeInput.length() != 1 && bridgeSizeInput.length() != 2) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_RANGE_ERROR.getMessage());
        }
    }

    /**
     * 검증 로직 : 다리 길이 범위를 검증한다.
     */
    public void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_RANGE_ERROR.getMessage());
        }
    }

    /**
     * 검증 로직 : 문자 길이를 검증한다.
     */
    public void validateWordLength(String word) {
        if (word.length() != 1) {
            throw new IllegalArgumentException(WORD_LENGTH_ERROR.getMessage());
        }
    }

    /**
     * 검증 로직 : 이동할 칸 문자를 'U' 또는 'D' 중에 하나를 선택했는지 검증한다.
     */
    public void validateMovingSpaceWord(String movingSpace) {
        if (movingSpace.equals(UPPER) || movingSpace.equals(LOWER)) {
            return;
        }
        throw new IllegalArgumentException(CHOICE_U_OR_D_ERROR.getMessage());
    }

    /**
     * 검증 로직 : 게임 다시 시도 여부 문자가 'R' 또는 'Q' 중에 하나를 선택했는지 검증한다.
     */
    public void validateGameCommandWord(String gameCommand) {
        if (gameCommand.equals(RETRY) || gameCommand.equals(QUIT)) {
            return;
        }
        throw new IllegalArgumentException(CHOICE_R_OR_Q_ERROR.getMessage());
    }
}
