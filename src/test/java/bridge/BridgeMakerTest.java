package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이에 따른 생성 테스트")
    @Nested
    class BridgeSizeTest {
        @BeforeEach
        void initializeBridgeMaker() {
            bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        }

        @DisplayName("다리 생성시 다리 길이가 20개가 넘어가면 IllegalArgumentException이 발생한다.")
        @Test
        void makeBridgeByOverSize() {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(21))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @DisplayName("다리 생성시 다리 길이가 3개보다 적으면 IllegalArgumentException이 발생한다.")
        @ParameterizedTest
        @ValueSource(ints = {2, 0, -1})
        void makeBridgeByUnderSize(int size) {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @DisplayName("다리 생성시 다리 길이가 3개 ~ 20개 사이면 아무 문제 없다")
        @ParameterizedTest
        @ValueSource(ints = {3, 9, 14, 20})
        void makeBridgeByNegative(int size) {
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
        }
    }

    @DisplayName("다리 번호에 따른 생성 테스트")
    @Nested
    class BridgeNumberTest {
        @DisplayName("생성된 다리 번호 중 0과 1이 아닌 수가 있으면 IllegalStateException이 발생한다")
        @Test
        void makeBridgeByInvalidBridgeNumbers() {
            bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(2, 0, 0)));
            assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }

        @DisplayName("생성된 다리 번호가 0이나 1뿐이면 정상적으로 생성된다.")
        @Test
        void makeBridgeByValidBridgeNumbers() {
            bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge.size()).isEqualTo(3);
        }

    }
}
