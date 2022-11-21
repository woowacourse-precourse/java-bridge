package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @DisplayName("다리가 특정 길이로 생성되는 지 테스트 한다.")
    @Test
    void bridgeSizeTest() {
        Bridge bridge = new Bridge(10);
        assertThat(bridge.size()).isEqualTo(10);
    }

    @DisplayName("특정 위치로 이동 가능할때 참을 반환하는지 테스트한다.")
    @Test
    void bridgeMovableTest() {
        assertRandomNumberInRangeTest(() -> {
            Bridge bridge = new Bridge(3);
            assertThat(bridge.isMovable("U",0)).isTrue();
            assertThat(bridge.isMovable("D",1)).isTrue();
            assertThat(bridge.isMovable("U",2)).isTrue();
        }, 1, 0, 1);
    }

    @DisplayName("특정 위치로 이동 불가능할때 거짓을 반환하는지 테스트한다.")
    @Test
    void bridgeNotMovableTest() {
        assertRandomNumberInRangeTest(() -> {
            Bridge bridge = new Bridge(3);
            assertThat(bridge.isMovable("D",0)).isFalse();
            assertThat(bridge.isMovable("U",1)).isFalse();
            assertThat(bridge.isMovable("D",2)).isFalse();
        }, 1, 0, 1);
    }
}
