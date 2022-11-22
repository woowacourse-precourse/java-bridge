package bridge.domain.bridge;

import static bridge.domain.bridge.BridgePasser.makeBridgePasser;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import bridge.value.BridgeCharacter;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgePasserTest {

    private BridgePasser bridgePasser;

    @BeforeEach
    void setUp() {
        List<String> bridgeChars = List.of("U", "D", "U", "D");
        Bridge bridge = Bridge.convert(bridgeChars);
        this.bridgePasser = makeBridgePasser(bridge);
    }

    @Test
    void 이동_가능_문자_판별_테스트() {
        boolean expected = bridgePasser.canMove(BridgeCharacter.UP);

        assertThat(expected).isTrue();
    }

    @Test
    void 이동_불가능_문자_판별_테스트() {
        boolean expected = bridgePasser.canMove(BridgeCharacter.DOWN);

        assertThat(expected).isFalse();
    }

    @Test
    void 이동_불가능_위치_판별_테스트() {
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();

        assertThatThrownBy(() -> {
            bridgePasser.canMove(BridgeCharacter.DOWN);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 이동_불가능_위치_이동_테스트() {
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();

        assertThatThrownBy(() -> {
            bridgePasser.move();
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 다리가_끝났는지_테스트() {
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();

        boolean actual = bridgePasser.isBridgeEnd();
        assertThat(actual).isTrue();
    }

    @Test
    void 다리가_끝나지않았는지_테스트() {
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();

        boolean actual = bridgePasser.isBridgeEnd();
        assertThat(actual).isFalse();
    }

    @Test
    void 다리_초기화_테스트() {
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();
        bridgePasser.move();

        boolean beforeStatus = bridgePasser.isBridgeEnd();
        bridgePasser.clear();
        boolean afterStatus = bridgePasser.isBridgeEnd();

        assertThat(beforeStatus).isNotEqualTo(afterStatus);

    }
}