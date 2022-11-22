package bridge;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class DirectionInputTest {
    @DisplayName("Direction는  U 또는 D 이므로 길이가 1이어야 한다.")
    @Test
    void Direction_D_R_len() {
        String bridgeMoving = "UU";
        assertThatThrownBy(() -> Validator.validateMovingLen(bridgeMoving)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("Direction 은 U 또는 D 여야 한다.")
    @Test
    void Direction_D_R() {
        String bridgeMoving = "A";
        assertThatThrownBy(() -> Validator.validateMoving(bridgeMoving)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
