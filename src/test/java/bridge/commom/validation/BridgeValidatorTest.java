package bridge.commom.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeValidatorTest {

    private static final String exceptionMessage = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    @DisplayName("다리의 사이즈가 3 미만이라면 예외를 발생한다.")
    @ParameterizedTest(name = "다리 사이즈 유효성 검사 테스트[{index}] => {0}은 3 미만이기 때문에 예외를 발생한다.")
    @ValueSource(ints = {1, 2, -1, 0, -2, -3})
    void ifBridgeSizeLessThenThreeReturingException(int actual) {
        assertThatThrownBy(() -> BridgeValidator.isProperlyBridgeSize(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("다리의 사이즈가 21 이상이라면 예외를 발생한다.")
    @ParameterizedTest(name = "다리 사이즈 유효성 검사 테스트[{index}] => {0}은 21 이상이기 때문에 예외를 발생한다.")
    @ValueSource(ints = {21, 22, 23, 24, 25, 999})
    void ifBridgeSizeGreaterThenTwentyOneReturingException(int actual) {
        assertThatThrownBy(() -> BridgeValidator.isProperlyBridgeSize(actual))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}