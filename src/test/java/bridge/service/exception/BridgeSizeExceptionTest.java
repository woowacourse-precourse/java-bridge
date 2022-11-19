package bridge.service.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[예외처리] 다리 크기")
class BridgeSizeExceptionTest {

    @Test
    @DisplayName("다리의 크기가 숫자가 아니면 예외가 발생한다.")
    void checkConvertToNumberTest() {
        String bridgeSize = "이십줄";
        assertThatThrownBy(() -> BridgeSizeException.checkConvertToNumber(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 크기가 3에서 20사이의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"0", "1", "2", "21", "100"})
    @ParameterizedTest
    void checkBridgeSizeIsCorrectRangeTest(String size) {
        assertThatThrownBy(() -> BridgeSizeException.checkBridgeSizeIsCorrectRange(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}