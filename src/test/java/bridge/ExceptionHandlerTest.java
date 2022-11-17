package bridge;

import bridge.util.ExceptionHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExceptionHandlerTest {

    @DisplayName("다리의 길이 입력 테스트 - 예외")
    @ValueSource(strings = {"1", "2", "21", "a", "", " ", "3 "})
    @ParameterizedTest
    void checkBridgeSizeTest_Exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkBridgeSize(input));
    }

    @DisplayName("다리의 길이 입력 테스트 - 정상")
    @ValueSource(strings = {"3", "20"})
    @ParameterizedTest
    void checkBridgeSizeTest(String input) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkBridgeSize(input));

    }

}
