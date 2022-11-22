package bridge.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    Validator validator = new Validator();
    @DisplayName("3 ~ 20 사이의 숫자가 아닌 경우 예외 처리")
    @ValueSource(strings = {"999", "-123"})
    @ParameterizedTest
    void underLottoPrice(Integer input) {
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력하지 않는 경우 예외 처리")
    @Test
    void inputNullLottoPrice() {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateBridgeSize(Integer.parseInt("")))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("방향을 입력받을 때, U, D가 아닌 경우 예외 처리")
    @ValueSource(strings = {"a", ""})
    @ParameterizedTest
    void inValidatedDirection(String input) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateDirection(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부를 입력받을 때, R, Q가 아닌 경우 예외 처리")
    @ValueSource(strings = {"a", ""})
    @ParameterizedTest
    void inValidatedRetryOrQuit(String input) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateDirection(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}