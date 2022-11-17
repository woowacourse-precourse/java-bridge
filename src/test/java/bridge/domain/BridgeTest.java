package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @DisplayName("다리의 인덱스를 넘으면 예외가 발생한다.")
    @ValueSource(ints = {4, -1})
    void bridgeIndexOverThrowException(int input) {
        // given
        Bridge bridge = Bridge.of(List.of("U", "D", "D"));
        // expect
        assertThatThrownBy(() -> bridge.getIndexOf(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리의 인덱스가 정상적이면 UpDown을 반환한다.")
    void bridgeGetOfIndex() {
        // given
        Bridge bridge = Bridge.of(List.of("D", "D", "D", "U"));
        // expect
        assertThat(bridge.getIndexOf(3))
                .isEqualTo(UpDownFlag.UP);
    }

    @Test
    @DisplayName("사용자가 건넌 다리의 길이가 다리의 길이보다 같거나 크면 참을 반환한다")
    void bridgeCrossOverTrue() {
        // given
        Bridge bridge = Bridge.of(List.of("D", "D", "D"));
        User user = new User();
        user.move("D");
        user.move("D");
        user.move("D");
        // expect
        assertThat(bridge.isCrossOver(user))
                .isTrue();
    }

    @Test
    @DisplayName("사용자가 건넌 다리의 길이가 다리의 길이보다 작으면 거짓을 반환한다")
    void bridgeCrossOverFalse() {
        // given
        Bridge bridge = Bridge.of(List.of("D", "D", "D"));
        User user = new User();
        user.move("D");
        user.move("D");
        // expect
        assertThat(bridge.isCrossOver(user))
                .isFalse();
    }
}