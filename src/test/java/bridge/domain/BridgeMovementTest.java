package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMovementTest {
    @DisplayName("이동은 U 또는 D 상태만 가질 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"D", "U"})
    void 사용자_이동값_검증(String move) {

        assertThat(BridgeMovement.findByMovement(move) instanceof BridgeMovement).isEqualTo(true);
    }

    @DisplayName("이동은 U 또는 D 상태가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "1"})
    void 사용자_이동값_예외처리(String move) {
        assertThatThrownBy(() -> BridgeMovement.findByMovement(move))
                .isInstanceOf(IllegalArgumentException.class);
    }
}