package bridge.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.service.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameControllerTest {
    @DisplayName("3 ~ 20 사이의 숫자가 아닌 경우 예외 처리")
    @ValueSource(strings = {"999", "-123"})
    @ParameterizedTest
    void underLottoPrice(Integer input) {
        Validator validator = new Validator();
        assertThatThrownBy(() -> validator.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}