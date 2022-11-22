package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeValidatorTest {

    @DisplayName("빈 문자열을 넣었을 때 Exception 을 던지는지 확인(공백을 제거 함으로 빈 문자열이 발생 가능)")
    @ParameterizedTest
    @EmptySource
    void userInputWithEmpty(final String userInput) {
        assertThatThrownBy(() -> BridgeValidator.checkBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자열을 입력 했을 때 Exception 을 던지는 지 확인")
    @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
    @ValueSource(strings = {"1a", "jj", "&1", "$", "q", "we", "t", "j1"})
    void userInputWithNotNumber(final String userInput) {
        assertThatThrownBy(() -> BridgeValidator.checkBridgeSize(userInput))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("유효한 크기를 입력 했을 때 크기를 그대로 반환 하는지 확인")
    @ParameterizedTest(name = "[{index}번째 테스트 : {0}]")
    @ValueSource(strings =
            {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"})
    void userInputWithValidNumber(final String userInput) {
        assertThat(BridgeValidator.checkBridgeSize(userInput)).isEqualTo(Integer.parseInt(userInput));
    }

    @DisplayName("유효하지 않은 크기를 입력 했을 때 Exception 을 던지는 지 확인")
    @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
    @ValueSource(strings = {"-10", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2", "-1", "0", "1", "2", "21"})
    void bridgeSizeWithInvalidSize(final String userInput) {
        assertThatThrownBy(() -> BridgeValidator.checkBridgeSize(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스 범위 밖을 접근 하려고 할 때 Exception 을 던지는 지 확인")
    @ParameterizedTest(name = "[{index}]번째 테스트 : {0}")
    @ValueSource(ints = {-14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 4, 5, 6})
    void bridgeIndexWithInvalidIndex(final int index) {
        final int size = 3;
        assertThatThrownBy(() -> BridgeValidator.checkBridgeIndexValid(size, index))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}