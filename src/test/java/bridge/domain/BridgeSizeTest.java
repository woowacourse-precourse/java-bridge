package bridge.domain;

import bridge.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @DisplayName("정상입력 - 다리 길이는 3이상 20이하의 숫자를 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "20"})
    void bridgeSizeCheck(String input) {
        new BridgeSize(input);
    }

    @DisplayName("다리의 길이가 3이상, 20이하를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "2", "21", "100", "30000000000", "10000000000000000000000"})
    void bridgeSizeNotInRange(String input) {
        Assertions.assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BRIDGE_SIZE_RANGE.getMessage());

    }

    @DisplayName("다리의 길이에 숫자 이외의 문자가 포함되어 있다면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "/", "+", "3*", "5.5"})
    void bridgeSizeNotNumber(String input) {
        Assertions.assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER.getMessage());

    }

    @DisplayName("다리의 길이 값이 들어오지 않으면 예외가 발생한다.")
    @Test
    void bridgeSizeNotNumber() {
        Assertions.assertThatThrownBy(() -> new BridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NO_INPUT_VALUE.getMessage());

    }
}