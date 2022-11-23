package bridge.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.vo.BridgeSize.recordBridgeSize;
import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리의 길이를 3 이상 20 이하의 숫자로 입력 시 예외가 발생하지 않는다.")
    @Test
    void SuccessCase() {
        assertThatCode(() -> recordBridgeSize("15"))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리의 길이를 3 이상 20 이하의 숫자로 입력 시 성공적으로 BridgeSize를 생성한다.")
    @Test
    void createBridgeSizeTest() {
        assertThat(recordBridgeSize("15"))
                .isInstanceOf(BridgeSize.class);
    }

    @DisplayName("다리의 길이를 숫자가 아닌 문자로 입력 시 예외가 발생한다.")
    @Test
    void case1() {
        assertThatThrownBy(() -> recordBridgeSize("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이를 20 이상의 숫자로 입력 시 예외가 발생한다.")
    @Test
    void case2() {
        assertThatThrownBy(() -> recordBridgeSize("40"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리의 길이를 3 이하의 숫자로 입력 시 예외가 발생한다.")
    @Test
    void case3() {
        assertThatThrownBy(() -> recordBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}