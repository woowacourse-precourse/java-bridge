package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String BRIDGE_LENGTH_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String DIRECTION_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U 또는 D여야 합니다.";
    private static final String COMMAND_ERROR_MESSAGE = "[ERROR] 재시도를 위해서는 R 그리고 종료를 위해서는 Q를 입력하여야 합니다.";

    @Test
    void 다리의_길이가_3보다_작은_경우_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("0");
            assertThat(output()).contains(
                    BRIDGE_LENGTH_ERROR_MESSAGE
            );
        }, 1, 0, 1);
    }

    @Test
    void 다리의_길이가_20보다_큰_경우_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("30");
            assertThat(output()).contains(
                    BRIDGE_LENGTH_ERROR_MESSAGE
            );
        }, 1, 0, 1);
    }

    @Test
    void 방향을_U와_D가_아닌_다른_문자를_입력한_경우_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "K");
            assertThat(output()).contains(
                    DIRECTION_ERROR_MESSAGE
            );
        }, 1, 0, 1);
    }

    @Test
    void 재시작과_종료를_위해서_R과_Q가_아닌_다른_문자를_입력한_경우_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "M");
            assertThat(output()).contains(
                    COMMAND_ERROR_MESSAGE
            );
        }, 1, 0, 1);
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
