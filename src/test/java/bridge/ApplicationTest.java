package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.message.ErrorMessage;
import bridge.message.OutputMessage;
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
    void 게임_오버_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 게임_오버_후_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 잘못된_이동방향_처리() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "Y", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1",
                    "[ERROR]",
                    ErrorMessage.NOT_A_MOVE_CHOICE.getValue()
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");

            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }


    @Test
    void 잘못된_다리길이_처리() {
        assertRandomNumberInRangeTest(() -> {
            run("21", "3", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1",
                    "[ERROR]",
                    ErrorMessage.OUT_OF_RANGE.getValue()
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(output().indexOf(OutputMessage.GET_BRIDGE_SIZE_COMMENT.getValue()))
                    .isNotSameAs(output().lastIndexOf(OutputMessage.GET_BRIDGE_SIZE_COMMENT.getValue()));
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 숫자가_아닌_다리길이_처리() {
        assertRandomNumberInRangeTest(() -> {
            run("A", "3", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1",
                    "[ERROR]",
                    ErrorMessage.NOT_A_NUMBER.getValue()
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(output().indexOf(OutputMessage.GET_BRIDGE_SIZE_COMMENT.getValue()))
                    .isNotSameAs(output().lastIndexOf(OutputMessage.GET_BRIDGE_SIZE_COMMENT.getValue()));
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Test
    void 잘못된_게임_재시작_명령어_처리() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "T", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "[ X ]",
                    "[   ]",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2",
                    "[ERROR]",
                    ErrorMessage.NOT_A_RETRY_INTENTION.getValue()
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(output().indexOf(OutputMessage.GET_RETRY_INTENTION_COMMENT.getValue()))
                    .isNotSameAs(output().lastIndexOf(OutputMessage.GET_RETRY_INTENTION_COMMENT.getValue()));
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
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
