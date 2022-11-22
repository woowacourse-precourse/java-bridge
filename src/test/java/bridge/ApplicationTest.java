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
    void 반복_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
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
    void 다리_길이가_실수로_입력됐을_때() {
        assertSimpleTest(() -> {
            runException("4.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_범위보다_작은_수로_입력됐을_때() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이가_범위보다_큰_수로_입력됐을_때() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동할_칸이_실수로_입력됐을_때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "3.5", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Test
    void 이동할_칸으로_다른_문자열이_입력됐을_때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "Q", "D", "U");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Test
    void 게임_지속_여부로_실수가_입력됐을_때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "3.5");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Test
    void 게임_지속_여부로_다른_문자열이_입력됐을_때() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Y");
            assertThat(output()).contains(ERROR_MESSAGE);
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
