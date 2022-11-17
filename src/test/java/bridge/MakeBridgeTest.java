package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class MakeBridgeTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리가 잘 만들어졌는지 테스트")
    void makeBridgeTest() {
        BridgeNumberGenerator numberGenerator = new MakeBridgeTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    @DisplayName("입력에 따른 다리 크기 테스트")
    void makeBridgeSizeTest() {
        BridgeMaker newBridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = newBridge.makeBridge(15);
        assertThat(bridge.size()).isEqualTo(15);
    }

    @DisplayName("다리 크기 입력에 대한 예외 처리 테스트")
    @Nested
    class makeBridgeExceptionTest {
        @Test
        @DisplayName("입력이 숫자가 아닌 경우에 대한 예외 처리")
        void checkNotNumberTest() {
            assertSimpleTest(() -> {
                runException("a");
                assertThat(output()).contains(ERROR_MESSAGE, "다리 길이는 숫자를 입력해야 합니다.");
            });
        }

        @Test
        @DisplayName("입력이 다리 크기 범위를 벗어났을 때 예외 처리")
        void checkOutOfRangeTest() {
            assertSimpleTest(() -> {
                runException("2");
                assertThat(output()).contains(ERROR_MESSAGE, "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            });
            assertSimpleTest(() -> {
                runException("21");
                assertThat(output()).contains(ERROR_MESSAGE, "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            });
        }
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
