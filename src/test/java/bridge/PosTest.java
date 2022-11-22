package bridge;

import bridge.domain.Pos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PosTest {

    @DisplayName("0이면 D, 1이면 U를 반환한다.")
    @Test
    void findPos() {
        assertThat(Pos.findPos(0)).isEqualTo("D");
        assertThat(Pos.findPos(1)).isEqualTo("U");
    }

    @DisplayName("BridgeNumberGenerator 를 사용하여 조회하지 않으면 예외가 발생한다.")
    @Test
    void findPosByInCorrectTime() {
        assertThatThrownBy(() -> Pos.findPos(5)).isInstanceOf(IllegalStateException.class);
    }
}
