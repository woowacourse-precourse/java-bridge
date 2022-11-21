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
    void 종합_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("  ", "*", "4567", "21","3",
                    "R", "U", "D", "D",
                    "R", "UD", "D",
                    "X", "Q");
            assertThat(output()).contains(
                    "[ERROR] 값을 입력해주세요.",
                    "[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.",
                    "[ERROR] 한 글자 또는 두 글자만 입력해주세요.",
                    "[ERROR] 3 이상 20 이하의 자연수를 입력해주세요.",
                    "[ERROR] U 또는 D를 입력해주세요.",
                    "[ERROR] 한 글자만 입력해주세요.",
                    "[ERROR] R 또는 Q를 입력해주세요.",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int indexOfFirstErrorMsg = output().indexOf("[ERROR] 값을 입력해주세요.");
            int indexOfSecondErrorMsg = output().indexOf("[ERROR] 숫자 외 다른 문자는 입력할 수 없습니다.");
            int indexOfThirdErrorMsg = output().indexOf("[ERROR] 한 글자 또는 두 글자만 입력해주세요.");
            int indexOfFourthErrorMsg = output().indexOf("[ERROR] 3 이상 20 이하의 자연수를 입력해주세요.");
            int indexOfFifthErrorMsg = output().indexOf("[ERROR] U 또는 D를 입력해주세요.");
            int indexOfSixthErrorMsg = output().indexOf("[ERROR] 한 글자만 입력해주세요.");
            int indexOfSeventhErrorMsg = output().indexOf("[ERROR] R 또는 Q를 입력해주세요.");

            assertThat(indexOfFirstErrorMsg)
                    .isLessThan(indexOfSecondErrorMsg)
                    .isLessThan(indexOfThirdErrorMsg)
                    .isLessThan(indexOfFourthErrorMsg)
                    .isLessThan(indexOfFifthErrorMsg)
                    .isLessThan(indexOfSixthErrorMsg)
                    .isLessThan(indexOfSeventhErrorMsg);

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
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
