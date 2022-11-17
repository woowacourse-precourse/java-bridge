package bridge.view;

import bridge.view.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {


    @DisplayName("문자를 입력했을 때")
    @ValueSource(strings = {"k", "3k", "12k"})
    @ParameterizedTest
    void testForGetUserInputToInt1(String input) {
        assertThatThrownBy(() -> getUserInputToInt(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("숫자를 입력했을 때")
    @ValueSource(strings = {"10", "13", "12"})
    @ParameterizedTest
    void testForGetUserInputToInt2(String input) {
        assertThat(getUserInputToInt(input))
                .isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력 값이 범위 안에 있을 때")
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void testForReadBridgeSize1(String input) {
        assertThat(readBridgeSize(input))
                .isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력 값이 범위 밖에 있을 때")
    @ValueSource(strings = {"-1", "21", "25"})
    @ParameterizedTest
    void testForReadBridgeSize2(String input) {
        Throwable t = catchThrowable(() -> readBridgeSize(input));
        assertThat(t)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
    }

    private int readBridgeSize(String input) {
        try {
            int inputToInt = getUserInputToInt(input);
            Validator.validateForRangeException(inputToInt);
            return inputToInt;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private int getUserInputToInt(String input) {
        try {
            OutputView.printGameMessage(REQUEST_FOR_BRIDGE_SIZE_MESSAGE);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            throw new NumberFormatException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);

        }
    }
}