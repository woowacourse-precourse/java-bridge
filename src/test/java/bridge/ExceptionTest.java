package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ValueSource(strings = {"999", "0", "-123"})
    @ParameterizedTest
    void readBridgeSize_사용자가_범위에_벗어난_다리길이를_입력했을때(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ValueSource(strings = {"ASF", "1","K", "입력오류"})
    @ParameterizedTest
    void readMoving_이동할_칸의_입력_오류(String input) {
        assertSimpleTest(() -> {
            runException("3", input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void readGameCommand_게임종료여부_입력_오류() {
        assertSimpleTest(() -> {
            runException("3", "U", "U", "E");
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