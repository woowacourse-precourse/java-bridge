package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeTest {
    @Test
    @DisplayName("다리를 생성할 때 U 또는 D 외의 문자열이 있으면 예외가 발생한다.")
    void createBridgeBy_Q_Or_U_String() {
        // given
        List<String> bridge = List.of("U", "D", "Z");
        // expect
        assertThatThrownBy(() -> Bridge.of(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리가 정상적으로 생성되야한다.")
    void createBridge() {
        // given
        List<String> strings = List.of("U", "D", "D");
        // when
        Bridge bridge = Bridge.of(strings);
        // then
        assertThat(bridge.getLength())
                .isEqualTo(3);
    }
}