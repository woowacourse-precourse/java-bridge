package bridge;

import bridge.validation.BridgeSizeInputException;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class BridgeSizeExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이 입력 문구에 숫자가 아닐 때, 예외 발생")
    @Test
    void parseException() {
        assertSimpleTest(() -> {
            runException("asdasd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이 입력 문구에 숫자가 아닐 때, assertThatThrownBy를 이용해 예외 발생 확인")
    @Test
    void parseException_2() {
        String inputSize = "ff";

        assertThatThrownBy(() -> {
            BridgeSizeInputException.validateBridgeSize(inputSize);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 숫자만 입력해주세요.");
    }

    @DisplayName("다리 길이 입력 문구에 제대로 입력했을 때, 작동 확인")
    @Test
    void validateBridgeSize() {
        String inputSize = "5";

        assertThatCode(() -> {
            BridgeSizeInputException.validateBridgeSize(inputSize);
        }).doesNotThrowAnyException();
    }

    @DisplayName("다리 길이 입력시 범위가 3~20이 아닐 때 예외 발생 확인")
    @Test
    void checkBridgeNumberOverRange() {
        String inputSize = "1";

        assertThatThrownBy(() -> {
            BridgeSizeInputException.validateBridgeSize(inputSize);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력시 범위 3~20가 맞을 때 작동 확인")
    @Test
    void checkBridgeNumberRange() {
        String inputSize = "5";

        assertThatCode(() -> {
            BridgeSizeInputException.validateBridgeSize(inputSize);
        }).doesNotThrowAnyException();
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
