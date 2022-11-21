package bridge.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RandomBridgeTest {

    @DisplayName("임의의 다리 생성 후 이동할 칸을 올바르게 입력한다.")
    @Test
    void isRight() {
        assertRandomNumberInRangeTest(() -> {
            RandomBridge randomBridge = new RandomBridge(3);
            assertThat(randomBridge.isRight("U", 0)).isTrue();
            assertThat(randomBridge.isRight("U", 1)).isTrue();
            assertThat(randomBridge.isRight("D", 2)).isTrue();
        }, 1, 1, 0);
    }

    @DisplayName("임의의 다리 생성 후 끝까지 건넜는지 확인한다.")
    @Test
    void isEndIndex() {
        RandomBridge randomBridge = new RandomBridge(3);

        assertThat(randomBridge.isEndIndex(2)).isTrue();
    }
}