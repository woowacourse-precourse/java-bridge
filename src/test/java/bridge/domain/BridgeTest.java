package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {
    @Test
    @DisplayName("다리를 생성할 때 U 또는 D 외의 문자열이 있으면 예외가 발생해야 한다.")
    void createBridgeBy_Q_Or_U_String() {
        // given
        List<String> bridge = List.of("U", "D", "Z");
        // expect
        assertThatThrownBy(() -> Bridge.of(bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리가 정상적으로 생성되어야 한다.")
    void createBridge() {
        // given
        List<String> strings = List.of("U", "D", "D");
        // when
        Bridge bridge = Bridge.of(strings);
        // then
        assertThat(bridge.getLength())
                .isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("인덱스의 범위를 초과하면 예외가 발생해야 한다.")
    @ValueSource(ints = {-1, 3})
    void getIndexOfByIllegalIndex(int index) {
        // given
        Bridge bridge = Bridge.of(List.of("U", "U", "U"));
        // expect
        assertThatThrownBy(() -> bridge.getIndexOf(index))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스가 들어오면 정상적으로 UpDownFlag를 반환해야 한다.")
    void getIndexOfUpDownFlag() {
        // given
        Bridge bridge = Bridge.of(List.of("U", "D", "U"));
        // expect
        assertThat(bridge.getIndexOf(1))
                .isEqualTo(UpDownFlag.DOWN);
    }
}