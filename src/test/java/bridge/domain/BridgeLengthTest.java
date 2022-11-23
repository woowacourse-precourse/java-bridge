package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeLengthTest {

    @DisplayName("3에서 20사이에 다리 길이 이외의 입력을 받은 경우 예외")
    @ParameterizedTest
    @CsvSource({
            "2", "1", "0", "21", "22", "100", "-1"
    })
    void throwExceptionWhenInputNotIncludeFromThreeToTwenty(int input) {
        assertThatThrownBy(() -> new BridgeLength(input)).isInstanceOf(IllegalArgumentException.class);
    }
}