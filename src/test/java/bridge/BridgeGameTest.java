package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import bridge.Model.BridgeNumberGenerator;

class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 실패_후_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1");
        }, 1, 0, 1);
    }

    @Test
    void 실패_후_재시도_성공_테스트(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U","R", "U", "D","U");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ O | X ]",
                    "[   |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2");
        }, 1, 0, 1);
    }



    @Test
    void commad_예외_테스트(){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U", "X");
            assertThat(output()).contains(
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
            ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Test
    void move_예외_테스트(){
        assertRandomNumberInRangeTest(() -> {
            runException("3", "K");
            assertThat(output()).contains(
            ERROR_MESSAGE);
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
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
