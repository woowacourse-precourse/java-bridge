package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "[{index}] {4}{5}{3}")
    @CsvSource(value =
            {
                    "3, U, U, R, U, D, D, R, U, D, U : [ O |   | O ] : [   | O |   ] : 성공 : 3 : 번시도_",

                    "3, U, U, R, U, D, D, R, U, D, D, Q : [ O |   |   ] : [   | O | X ] : 실패 : 3 : 번시도_마지막자리_",
                    "3, U, U, R, U, D, D, R, U, U, Q : [ O | X ] : [   |   ] : 실패 : 3 : 번시도_중간자리_",
                    "3, U, U, R, U, D, D, R, D, Q : [   ] : [ X ] : 실패 : 3 : 번시도_처음자리_",

                    "3, U, U, R, U, D, U : [ O |   | O ] : [   | O |   ] : 성공 : 2 : 번시도_",

                    "3, U, U, R, U, D, D, Q : [ O |   |   ] : [   | O | X ] : 실패 : 2 : 번시도_마지막자리_",
                    "3, U, U, R, U, U, Q : [ O | X ] : [   |   ] : 실패 : 2 : 번시도_중간자리_",
                    "3, U, U, R, D, Q  : [   ] : [ X ] : 실패 : 2 : 번시도_잘못입력_처음자리",
                    "3, U, U, R, R, D, Q  : [   ] : [ X ] : 실패 : 2 : 번시도_잘못입력_처음자리",
                    "3, U, U, R, U, U, R, U, U, R, U, U, R, U, U, R, U, U, R, D, Q  : [   ] : [ X ] : 실패 : 7 : 번시도_잘못입력_처음자리"
            }, delimiter = ':'
    )
    public void bridgeGame_test(String input, String upLine, String downLine, String isSuccess,
            int count,
            String name) {
        String[] args = input.split(", ");

        assertRandomNumberInRangeTest(() -> {
            run(args);
            assertThat(output()).contains(
                    "최종 게임 결과",
                    upLine,
                    downLine,
                    "게임 성공 여부: " + isSuccess,
                    "총 시도한 횟수: " + count
            );

            int upSideIndex = output().lastIndexOf(upLine);
            int downSideIndex = output().lastIndexOf(downLine);
            final int printResult = output().indexOf("최종 게임 결과");
            final int printSuccess = output().indexOf("게임 성공 여부: " + isSuccess);
            assertThat(upSideIndex).isGreaterThan(printResult).isLessThan(downSideIndex)
                    .isLessThan(printSuccess);
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
