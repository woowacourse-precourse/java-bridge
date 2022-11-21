package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMovementTest {
    @DisplayName("U은 1을, D은 0의 코드 값을 가진다.")
    @ParameterizedTest
    @CsvSource({"1, U", "0, D"})
    void 사용자_이동_코드값_정상처리(int code, String expected) {
        assertThat(BridgeMovement.findByCode(code).getMove()).isEqualTo(expected);
    }

    @DisplayName("이동은 U 또는 D 상태만 가질 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"D", "U"})
    void 사용자_이동값_정상처리(String move) {
        assertDoesNotThrow(() -> BridgeMovement.findByMovement(move));
    }

    @DisplayName("이동은 U 또는 D 상태가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "1"})
    void 사용자_이동값_예외처리(String move) {
        assertThatThrownBy(() -> BridgeMovement.findByMovement(move))
                .isInstanceOf(IllegalArgumentException.class);
    }
}