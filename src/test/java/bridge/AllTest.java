package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class AllTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("기능 테스트 1")
    @Test
    void 기능_테스트1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @DisplayName("기능 테스트 2")
    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
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

    @DisplayName("기능 테스트 3 : 다리 수 10개, 시도 4회")
    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "R",
                    "U", "U", "R",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   | O |   ]",
                    "[   | O |   | O |   | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   | O |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 테스트 4 : 다리 수 10개, 시도 3회")
    @Test
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "R",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   | O |   ]",
                    "[   | O |   | O |   | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   | O |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 실패 테스트 5 : 다리 수 10개, 시도 1회")
    @Test
    void 기능_테스트5() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf(
                    "[   ]");
            int downSideIndex = output().indexOf(
                    "[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 실패 테스트 6 : 다리 수 10개, 시도 2회")
    @Test
    void 기능_테스트6() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf(
                    "[ O | X ]");
            int downSideIndex = output().indexOf(
                    "[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 실패 테스트 7 : 다리 수 10개, 시도 5회")
    @Test
    void 기능_테스트7() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "Q",
                    "U", "U", "Q",
                    "U", "U", "Q",
                    "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf(
                    "[ O | X ]");
            int downSideIndex = output().indexOf(
                    "[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 실패 테스트 8 : 다리 수 10개, 시도 3회")
    @Test
    void 기능_테스트8() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "R",
                    "U", "U", "R",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   |   ]",
                    "[   | O |   | O |   | O |   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 테스트 9 : 다리 수 20개, 시도 1회")
    @Test
    void 기능_테스트9() {
        assertRandomNumberInRangeTest(() -> {
            run("20",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "U", "D",
                    "D", "U", "D", "U", "D",
                    "D", "U", "D", "U", "D"
                    );
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   | O |   |   | O |   | O |   |   | O |   | O |   ]",
                    "[   | O |   | O |   | O |   | O |   | O | O |   | O |   | O | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   | O |   |   | O |   | O |   |   | O |   | O |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O |   | O | O |   | O |   | O | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0);
    }

    @DisplayName("기능 테스트 10 : 다리 수 20개, 시도 3회")
    @Test
    void 기능_테스트10() {
        assertRandomNumberInRangeTest(() -> {
            run("20",
                    "U","U","R",
                    "U","D","D","R",
                    "U", "D", "U", "D", "U",
                    "D", "U", "D", "U", "D",
                    "D", "U", "D", "U", "D",
                    "D", "U", "D", "U", "D"
            );
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O |   | O |   | O |   |   | O |   | O |   |   | O |   | O |   ]",
                    "[   | O |   | O |   | O |   | O |   | O | O |   | O |   | O | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf(
                    "[ O |   | O |   | O |   | O |   | O |   |   | O |   | O |   |   | O |   | O |   ]");
            int downSideIndex = output().indexOf(
                    "[   | O |   | O |   | O |   | O |   | O | O |   | O |   | O | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0);
    }

    @DisplayName("문자가 포함되어 입력되었을 경우 예외")
    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("100abc");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이가 20을 넘었을 때의 예외")
    @Test
    void 다리_길이_예외_테스트() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("다리 길이가 3보다 작을 때 예외")
    @Test
    void 다리_길이_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("2");
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
