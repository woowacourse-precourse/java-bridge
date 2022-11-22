package exceptionHandler;

import enumCollections.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BridgeSizeExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    @DisplayName("다리 사이즈가 다리 길이의 최소값보다 작은 경우 예외처리 한다.")
    void 최소값보다_작은_다리_길이_입력_예외_테스트(String size) {
        assertThatThrownBy(() -> BridgeSizeException.validate(size))
                .hasMessage(ExceptionMessage.SMALLER_THAN_MINIMUM_BRIDGE_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"21", "22", "1000000"})
    @DisplayName("다리 사이즈가 다리 길이의 최대값보다 큰 경우 예외처리 한다.")
    void 최대값보다_큰_다리_길이_입력_예외_테스트(String size) {
        assertThatThrownBy(() -> BridgeSizeException.validate(size))
                .hasMessage(ExceptionMessage.BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("빈 문자열을 입력했을 경우 예외처리 한다.")
    void 빈_문자열_입력_예외_테스트(String size) {
        assertThatThrownBy(() -> BridgeSizeException.validate(size))
                .hasMessage(ExceptionMessage.EMPTY_STRING.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "a", "q", "l"})
    @DisplayName("숫자가 아닌 값을 경우 예외처리 한다.")
    void 숫자가_아닌_값을_입력했을_경우(String size) {
        assertThatThrownBy(() -> BridgeSizeException.validate(size))
                .hasMessage(ExceptionMessage.NOT_NUMERIC.getMessage());
    }
}