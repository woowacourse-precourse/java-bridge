package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import generator.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;
import service.BridgeMaker;

public class BridgeSizeTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(
                newArrayList(1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge)
                .containsExactly("U", "D", "D", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U");
    }

    @Test
    void 다리_생성_테스트_2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(
                newArrayList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge)
                .containsExactly("U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U", "D", "U",
                        "D", "U", "D");
    }

    @Test
    void 다리_생성_테스트_3() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(
                newArrayList(1, 0, 1, 0, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(7);
        assertThat(bridge)
                .containsExactly("U", "D", "U", "D", "U", "U", "U");
    }

    @Test
    void 다리_길이가_범위보다_클때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("98909898898766787656787668878767");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_범위보다_작을때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_음수_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("-99999999999999999999999999999999999999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_0_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_소수_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0.1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("0.999999999999999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("999999999990.99999");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("1312.322");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("0000000000.12");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_영문자_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_한글_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("삼");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_공백_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_특수_문자_일때_예외_테스트() {
        assertSimpleTest(() -> {
            runException("]");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("~");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
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
