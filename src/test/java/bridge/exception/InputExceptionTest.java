package bridge.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {
    InputException inputException;

    @BeforeEach
    void 테스트_준비() {
        inputException = new InputException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "K", "U", "DDD", "김", "", "  ", "12J"})
    void 다리길이_입력_예외(String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> { inputException.validateBridgeSize(bridgeSize); });
    }
}
