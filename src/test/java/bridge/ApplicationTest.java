package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.game.BridgeMaker;
import bridge.game.BridgeNumberGenerator;
import bridge.validator.ErrorType;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("재시도 할 경우 기능 테스트")
    void retryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "D", "U", "D");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   | O |   ]",
                "[ O |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[   | O |   ]");
            int downSideIndex = output().indexOf("[ O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0);
    }

    @Test
    @DisplayName("게임을 포기할 경우 기능 테스트")
    void gameGiveUpTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "Q");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ X ]",
                "[   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ X ]");
            int downSideIndex = output().indexOf("[   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0);
    }

    @Test
    @DisplayName("게임을 여러 번 시도하다가 포기할 경우 기능 테스트")
    void gameGiveUpWithMultipleAttemptTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "U", "R", "D", "D", "Q");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[   |   ]",
                "[ O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[   |   ]");
            int downSideIndex = output().indexOf("[ O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리 길이 입력으로 숫자가 아닌 입력이 들어올 경우 에러가 나야 한다.")
    void bridgeSizeInvalidFormatTest() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ErrorType.INVALID_FORMAT.getMessage());
        });
    }

    @Test
    @DisplayName("다리 길이 입력의 범위가 3 ~ 20이 아닐 경우 에러가 나야 한다.")
    void bridgeSizeInvalidValueTest() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(ErrorType.INVALID_RANGE.getMessage());
        });
    }

    @Test
    @DisplayName("움직이는 입력으로 'U'나 'D'가 아닌 입력이 들어올 경우 에러가 나야 한다.")
    void moveInvalidValueTest() {
        assertSimpleTest(() -> {
            runException("3", "S");
            assertThat(output()).contains(ErrorType.INVALID_MOVE_INPUT.getMessage());
        });
    }

    @Test
    @DisplayName("움직이는 입력으로 'R'나 'Q'가 아닌 입력이 들어올 경우 에러가 나야 한다.")
    void retryInvalidValueTest() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "r");

            assertThat(output()).contains(ErrorType.INVALID_RETRY_INPUT.getMessage());

        }, 0, 1, 0);
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
