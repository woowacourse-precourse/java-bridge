package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private BridgeGame bridgeGame = new BridgeGame();

    @Test
    List<String> 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
        return bridge;
    }

    @ParameterizedTest
    @CsvSource({"U, true", "D, false"})
    void 다리_이동_테스트(String arg, boolean result) {
        List<String> bridge = 다리_생성_테스트();
        bridgeGame.setBridge(bridge);
        final byte[] buf2 = String.join("\n", arg).getBytes();
        System.setIn(new ByteArrayInputStream(buf2));
        assertThat(bridgeGame.move(0)).isEqualTo(result);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
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
