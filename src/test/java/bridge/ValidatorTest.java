package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    @DisplayName("다리 값 입력이 정수인지에 대한 테스트")
    @ValueSource(strings = {"a", "b", "3.2"})
    @ParameterizedTest
    void bridgeSizeFormatCheck(String input) {
        assertThatThrownBy(() ->
                Validator.validateBridgeSize(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 값 입력이 정수인지에 대한 테스트")
    @ValueSource(strings = {"1", "2", "21"})
    @ParameterizedTest
    void bridgeSizeRangeCheck(String input) {
        assertThatThrownBy(() ->
                Validator.validateBridgeSize(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 값 입력에 대한 테스트")
    @ValueSource(strings = {"Q", "Y", "21"})
    @ParameterizedTest
    void movingCheck(String input) {
        assertThatThrownBy(() ->
                Validator.validateMoving(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시작 입력에 대한 테스트")
    @ValueSource(strings = {"U", "Y", "31"})
    @ParameterizedTest
    void gameCommandCheck(String input) {
        assertThatThrownBy(() ->
                Validator.validateGameCommand(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
