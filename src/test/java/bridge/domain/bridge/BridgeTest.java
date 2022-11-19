package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.value.BridgeCharacter;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    void 다리_길이_테스트() {
        List<String> shorts = List.of("U", "U");
        List<String> longs = List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                "U", "U", "U", "U", "U", "U");

        assertThatThrownBy(() -> Bridge.convert(shorts)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Bridge.convert(longs)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동_결과_테스트() {
        List<String> bridgeChars = List.of("U", "D", "U", "D");
        Bridge bridge = Bridge.convert(bridgeChars);

        boolean canMove1 = bridge.canMove(0, BridgeCharacter.UP);
        boolean canMove2 = bridge.canMove(1, BridgeCharacter.DOWN);

        boolean canNotMove1 = bridge.canMove(0, BridgeCharacter.DOWN);
        boolean canNotMove2 = bridge.canMove(5, BridgeCharacter.DOWN);


        assertThat(canMove1).isTrue();
        assertThat(canMove2).isTrue();

        assertThat(canNotMove1).isFalse();
        assertThat(canNotMove2).isFalse();
    }

    @Test
    void 게임_성공_테스트() {
        List<String> bridgeChars = List.of("U", "D", "U", "D");
        Bridge bridge = Bridge.convert(bridgeChars);

        boolean isSuccess1 = bridge.isRange(5);
        boolean isSuccess2 = bridge.isRange(10);

        boolean isNotSuccess1 = bridge.isRange(0);
        boolean isNotSuccess2 = bridge.isRange(-3);


        assertThat(isSuccess1).isTrue();
        assertThat(isSuccess2).isTrue();

        assertThat(isNotSuccess1).isFalse();
        assertThat(isNotSuccess2).isFalse();
    }
}