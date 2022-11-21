package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest extends NsTest {
    final String error = "[ERROR]";

    @Nested
    @DisplayName("올바른 다리를 생성하는 기능을 테스트")
    class MakeBridgeTest {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        @Test
        @DisplayName("다리의 길이가 3일 때")
        void case1() {
            int size = 3;
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
            assertThat(bridge).containsAnyOf("U", "D");
        }

        @Test
        @DisplayName("다리의 길이가 20일 때")
        void case2() {
            int size = 20;
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
            assertThat(bridge).containsAnyOf("U", "D");
        }
    }

    @Nested
    @DisplayName("올바른 입력이 들어오는지 테스트")
    class BridgeSizeTest {
        @Test
        @DisplayName("다리 길이로 0으로 시작하는 숫자가 입력될 때")
        void case1() {
            assertSimpleTest(() -> {
                runException("012");
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("다리 길이로 숫자가 아닌 문자가 입력될 때")
        void case2() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("다리 길이로 3보다 작은 숫자가 입력될 때")
        void case3() {
            assertSimpleTest(() -> {
                runException("1");
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("다리 길이로 20보다 큰 숫자가 입력될 때")
        void case4() {
            assertSimpleTest(() -> {
                runException("100");
                assertThat(output()).contains(error);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}