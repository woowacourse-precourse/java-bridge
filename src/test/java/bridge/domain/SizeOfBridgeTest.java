package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.utils.SizeInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SizeOfBridgeTest {

    @DisplayName("올바른 값이 입력된 경우 정상 생성된다.")
    @Test
    void create() {
        final int INPUT = 10;

        SizeOfBridge sizeOfBridge = SizeOfBridge.from(INPUT);

        assertThat(sizeOfBridge).isNotNull();
    }

    @DisplayName("입력값을 정상적으로 입력하지 않은 경우 IllegalArgumentException 이 발생한다.\"")
    @Test
    void null_input() {
        final String SIZE_INPUT = null;

        assertThatThrownBy(() -> SizeInputParser.parseSize(SIZE_INPUT))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");

    }

    @DisplayName("범위를 벗어나는 값이 입력된 경우 IllegalArgumentException 이 발생한다.")
    @Test
    void char_input() {
        final String SIZE_INPUT = "three";

        assertThatThrownBy(() -> SizeInputParser.parseSize(SIZE_INPUT))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

    @DisplayName("범위를 벗어나는 값이 입력된 경우 IllegalArgumentException 이 발생한다.")
    @Test
    void wrongRangeSize_input() {
        final int SIZE_INPUT = SizeOfBridge.START_INCLUSIVE - 1;

        assertThatThrownBy(() -> SizeOfBridge.from(SIZE_INPUT))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }

}