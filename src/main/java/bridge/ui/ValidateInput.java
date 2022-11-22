package bridge.ui;

import static bridge.ui.UiErrorMessage.*;

public interface ValidateInput {

    /**
     * 검증 로직 : 숫자가 맞는지 검증한다.
     */
    public void validateNumber(String inputValue);

    /**
     * 검증 로직 : 다리 길이가 일의 자리와 십의 자리 사이인지 검증한다.
     */
    public void validateBridgeSizeLength(String bridgeSizeInput);

    /**
     * 검증 로직 : 다리 길이 범위를 검증한다.
     */
    public void validateBridgeSizeRange(int size);

    /**
     * 검증 로직 : 문자 길이를 검증한다.
     */
    public void validateWordLength(String word);

    /**
     * 검증 로직 : 이동할 칸 문자를 하나 선택했는지 검증한다.
     */
    public void validateMovingSpaceWord(String movingSpace);

    /**
     * 검증 로직 : 게임 다시 시도 여부 문자를 하나 선택했는지 검증한다.
     */
    public void validateGameCommandWord(String gameCommand);
}
