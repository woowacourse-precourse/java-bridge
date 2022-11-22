package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.constant.Constants.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("범위에 벗어난 값 입력 - 다리 생성")
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
        });
    }

    @DisplayName("U와 D에 상관없는 값 입력 - 플레이어 이동")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("3", "K");
            assertThat(output()).contains(ERROR_MESSAGE, INVALID_INPUT_ERROR_MESSAGE, SELECT_U_OR_D_MESSAGE);
        });
    }

    @DisplayName("재시도 후 정답")
    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "R", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1, 0, 0); //"U", "D", "U", "D", "D"
    }

    @DisplayName("재시도 안함")
    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O |   | X ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1, 0, 0); //"U", "D", "U", "D", "D"
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
