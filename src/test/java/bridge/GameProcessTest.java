package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameProcessTest extends NsTest {
    ApplicationContext context = new ApplicationContext();
    GameProcess process;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void setUp() {
        process = context.process();
    }

    @Test
    void 게임_진행_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("x", "7", "U", "D", "D", "R",
                    "U", "D", "U", "U", "-", "R",
                    "a", "b", "U", "D", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   |   ]",
                    "[   | O |   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 0);
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