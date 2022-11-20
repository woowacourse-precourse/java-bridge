package bridge.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.vo.BridgeSize.createBridgeSize;
import static org.assertj.core.api.Assertions.*;

class BridgeSizeTest {

    @DisplayName("다리의 길이를 3 이상 20 이하의 숫자로 입력 시 예외가 발생하지 않는다.")
    @Test
    void SuccessCase() {
        assertThatCode(() -> createBridgeSize("15"))
                .doesNotThrowAnyException();
    }

    @DisplayName("다리의 길이를 3 이상 20 이하의 숫자로 입력 시 성공적으로 BridgeSize를 생성한다.")
    @Test
    void createBridgeSizeTest() {
        assertThat(createBridgeSize("15"))
                .isInstanceOf(BridgeSize.class);
    }

    @DisplayName("다리의 길이를 숫자가 아닌 문자로 입력 시 예외가 발생한다.")
    @Test
    void case1() {
        assertThatThrownBy(() -> createBridgeSize("hi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이를 20 이상의 숫자로 입력 시 예외가 발생한다.")
    @Test
    void case2() {
        assertThatThrownBy(() -> createBridgeSize("40"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이를 3 이하의 숫자로 입력 시 예외가 발생한다.")
    @Test
    void case3() {
        assertThatThrownBy(() -> createBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}