package bridge.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {
    private final String ERROR_MESSAGE = "[ERROR]";
    InputException inputException;

    @BeforeEach
    void 테스트_준비() {
        inputException = new InputException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "K", "U", "DDD", "김", "", "  ", "12J"})
    void 다리길이_입력_예외(String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    inputException.validateBridgeSize(bridgeSize);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "K", "", "김", "1", "2"})
    void 이동_입력_예외(String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    inputException.validateMoving(moving);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "K", "", "김", "1", "2"})
    void 게임종료_재시작_입력_예외(String gameCommand) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    inputException.validateGameCommand(gameCommand);
                })
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}
