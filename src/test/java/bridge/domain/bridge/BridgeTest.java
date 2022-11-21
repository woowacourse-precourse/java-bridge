package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.value.BridgeCharacter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        List<String> bridgeChars = List.of("U", "D", "U", "D");
        this.bridge = Bridge.convert(bridgeChars);

    }

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

        boolean canMove1 = bridge.canMove(new BridgeLocation(0), BridgeCharacter.UP);
        boolean canMove2 = bridge.canMove(new BridgeLocation(1), BridgeCharacter.DOWN);

        boolean canNotMove1 = bridge.canMove(new BridgeLocation(0), BridgeCharacter.DOWN);
        boolean canNotMove2 = bridge.canMove(new BridgeLocation(2), BridgeCharacter.DOWN);


        assertThat(canMove1).isTrue();
        assertThat(canMove2).isTrue();

        assertThat(canNotMove1).isFalse();
        assertThat(canNotMove2).isFalse();
    }


    @Test
    void 이동_결과_예외_테스트() {
        assertThatThrownBy(() -> {
            bridge.canMove(new BridgeLocation(5), BridgeCharacter.DOWN);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 범위체크_테스트() {

        boolean isSuccess1 = bridge.isRange(new BridgeLocation(0));
        boolean isSuccess2 = bridge.isRange(new BridgeLocation(3));

        boolean isNotSuccess1 = bridge.isRange(new BridgeLocation(6));
        boolean isNotSuccess2 = bridge.isRange(new BridgeLocation(8));


        assertThat(isSuccess1).isTrue();
        assertThat(isSuccess2).isTrue();

        assertThat(isNotSuccess1).isFalse();
        assertThat(isNotSuccess2).isFalse();
    }

    @Test
    void 불변_테스트() {
        List<BridgeCharacter> bridgeValue = bridge.characters();
        bridgeValue.set(0, null);

        BridgeCharacter actual = bridge.characters().get(0);

        assertThat(actual).isNotNull();
    }
}