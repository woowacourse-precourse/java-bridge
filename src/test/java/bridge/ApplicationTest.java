package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 기능_테스트_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("2", "21", "4", "u", "U", "U", "r", "R", "U", "D", "U", "D", "R", "U", "D", "U", "U");
            assertThat(output()).contains(
                    "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
                    "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
                    "[ERROR] U나 D를 입력해주시기 바랍니다.",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR] R이나 Q를 입력해주시기 바랍니다.",
                    "[ O |   | O |   ]",
                    "[   | O |   | X ]",
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 1);
    }

    @Test
    void 기능_테스트_포기() {
        assertRandomNumberInRangeTest(() -> {
            run("ㄱ", "+3", "4", "UD", "U", "RR", "R", "D", "U", "U", "D", "Q ", "Q");
            assertThat(output()).contains(
                    "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
                    "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
                    "[ERROR] U나 D를 입력해주시기 바랍니다.",
                    "[ X ]",
                    "[   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR] R이나 Q를 입력해주시기 바랍니다.",
                    "최종 게임 결과",
                    "[   | O | O |   ]",
                    "[ O |   |   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[   | O | O |   ]");
            int downSideIndex = output().indexOf("[ O |   |   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 1, 1, 1);
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
