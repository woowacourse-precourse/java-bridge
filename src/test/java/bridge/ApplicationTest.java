package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

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

    @DisplayName("첫 시도에 성공시 원하는 내용이 출력된다.")
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

    @DisplayName("두 번째 시도에 성공시 원하는 내용이 출력된다.")
    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
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

    @DisplayName("첫 시도에 실패 후 게임 종료시 원하는 내용이 출력된다.")
    @Test
    void 기능_테스트3() {
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

    @DisplayName("두 번째 시도에 실패 후 게임 종료시 원하는 내용이 출력된다.")
    @Test
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (다리 사이즈에 문자)")
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (다리 사이즈 범위 초과)")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (다리 사이즈 범위 미만)")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (다리 사이즈에 음수)")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (이동 위치에 U,D 이외 다른 문자)")
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() -> {
            runException("3", "u");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (이동 위치에 U,D 이외 다른 문자)")
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (이동 위치에 U,D 이외 다른 문자)")
    @Test
    void 예외_테스트7() {
        assertSimpleTest(() -> {
            runException("3", "U", "R");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (재시작 여부에 R,Q 이외 다른 문자)")
    @Test
    void 예외_테스트8() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "U", "Q");
            assertThat(output()).contains(
                    "[ERROR]"
            );

        }, 1, 0, 1);
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (재시작 여부에 R,Q 이외 다른 문자)")
    @Test
    void 예외_테스트9() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "1", "Q");
            assertThat(output()).contains(
                    "[ERROR]"
            );

        }, 1, 0, 1);
    }

    @DisplayName("옳바르지 않은 입력값을 넣으면 에러 메세지가 출력된다. (재시작 여부에 R,Q 이외 다른 문자)")
    @Test
    void 예외_테스트10() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", " ", "Q");
            assertThat(output()).contains(
                    "[ERROR]"
            );

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
