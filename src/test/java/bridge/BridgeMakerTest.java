package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 예외_테스트_다리_길이가_숫자가_아닐때() {
        assertSimpleTest(() -> {
            runException("안녕");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_다리_길이가_범위를_벗어날때() {
        assertSimpleTest(() -> {
            runException("400");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 기능_테스트_다리_길이만큼_U와_D를_랜덤으로_결정() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 1, 1, 0, 0)));
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertEquals(bridge, List.of("U", "U", "U", "D", "D"));
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