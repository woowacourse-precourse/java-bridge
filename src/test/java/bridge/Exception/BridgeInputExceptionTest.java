package bridge.Exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeInputExceptionTest {

    BridgeInputException bridgeInputException = new BridgeInputException();

    @ParameterizedTest
    @ValueSource(strings = {"A", "1", "끝", "", " "})
    @DisplayName("재시작/종료 여부가 R 또는 Q가 아닌 다른 문자일 때 예외 처리")
    void validInputFormRetry(String retry) {
        assertThatThrownBy(() -> bridgeInputException.validBridgeRetry(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

