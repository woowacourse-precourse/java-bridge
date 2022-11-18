package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.NumberConstant;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeConverterTest {

    @DisplayName("정상 시나리오 | 숫자 0이 들어오면 D를 반환함.")
    @Test
    void covertToBridgeNumberZero() {
        assertThat(BridgeConverter.covertToBridgeNumber(0)).isEqualTo("D");
    }

    @DisplayName("정상 시나리오 | 숫자 1이 들어오면 U를 반환함.")
    @Test
    void covertToBridgeNumber() {
        assertThat(BridgeConverter.covertToBridgeNumber(1)).isEqualTo("U");
    }

    @DisplayName("예외 시나리오 | 숫자 0과 1이 아닌 수가 입력될 시 예외 처리")
    @Test
    void convertToIllegalBridgeNumberByClassNotFoundException() {
        assertThatThrownBy(() -> BridgeConverter.covertToBridgeNumber(2))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("[ERROR]");
    }

}