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
    private static final String RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_최대길이() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(20);
        assertThat(bridge).containsExactly("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U");
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
    void 기능_테스트_최대길이() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]",
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]");
            int downSideIndex = output().indexOf("[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void 기능_테스트_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 기능_테스트_숫자_재입력() {
        assertRandomNumberInRangeTest(() -> {
            run("21", "20", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]",
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]");
            int downSideIndex = output().indexOf("[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void 기능_테스트_이동_재입력() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "A", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "최종 게임 결과",
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]",
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]");
            int downSideIndex = output().indexOf("[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void 기능_테스트_게임명령에_이동명령() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "A", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "D", "R",
                    "U", "A", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O |   ]",
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   | X ]",
                    RESTART_MESSAGE
            );
            int upSideIndex = output().indexOf("[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | X ]");
            int downSideIndex = output().indexOf("[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_명령() {
        assertSimpleTest(() -> {
            runException(" ", "3", "a");
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
