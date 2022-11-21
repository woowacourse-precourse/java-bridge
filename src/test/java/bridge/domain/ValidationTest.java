package bridge.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    private static Validation validation;

    @BeforeAll
    static void init() {
        validation = new Validation();
    }

    @DisplayName("다리 길이 입력은 숫자로 해야한다.")
    @ParameterizedTest
    @CsvSource(value = {"a", "1000a", "5a"})
    void isInteger(String size) {
        assertThatThrownBy(() -> validation.isInteger(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3부터 20 사이여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"2", "21", "-1", "10000"})
    void validateInputBridgeSize(int size) {
        assertThatThrownBy(() -> validation.validateInputBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("위로 가려면 U를, 아래로 가려면 D를 입력해야한다.")
    @ParameterizedTest
    @CsvSource(value = {"u", "d", "A", "UU", "DU", "3"})
    void validateInputMoving(String moveTo) {
        assertThatThrownBy(() -> validation.validateInputMoving(moveTo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 하려면 R을, 종료하려면 Q를 입력해야한다.")
    @ParameterizedTest
    @CsvSource(value = {"r", "q", "U", "D", "RQ", "RR", "3"})
    void validateInputRetry(String retryCommand) {
        assertThatThrownBy(() -> validation.validateInputRetry(retryCommand))
                .isInstanceOf(IllegalArgumentException.class);
    }
}