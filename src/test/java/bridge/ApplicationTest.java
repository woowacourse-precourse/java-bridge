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
    void 재시작_후_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "R", "D", "D", "U");
            assertThat(output()).contains(
                    "[ X ]",
                    "[   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   ]",
                    "[ O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   |   ]",
                    "[ O | O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   |   | O ]",
                    "[ O | O |   ]",
                    "최종 게임 결과",
                    "[   |   | O ]",
                    "[ O | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[   |   | O ]");
            int downSideIndex = output().indexOf("[ O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Test
    void 잘못된_입력_재입력_후_재시작_후_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("a", "3", "k", "한글", "U", "잘못된입력", "R", "D", "D", "U");
            assertThat(output()).contains(
                    "[ X ]",
                    "[   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   ]",
                    "[ O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   |   ]",
                    "[ O | O ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[   |   | O ]",
                    "[ O | O |   ]",
                    "최종 게임 결과",
                    "[   |   | O ]",
                    "[ O | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[   |   | O ]");
            int downSideIndex = output().indexOf("[ O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 1);
    }

    @Test
    void 실패_후_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O |   ]");
            int downSideIndex = output().indexOf("[   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
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
