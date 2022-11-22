package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest extends NsTest {

    private static final String MOVE_COMMAND_ERROR_MESSAGE = "[ERROR] U,D를 입력해 주세요.";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R,Q를 입력해 주세요.";
    private static final String BRIDGE_SIZE_RANGE_ERROR_MESSAGE = "ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    @Test
    void 총_시도한_횟수_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "D", "R", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );
        }, 1, 0, 1);
    }

    @Test
    void 게임을_종료했을때_출력_결과_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    void 다리_길이_범위_예외_테스트() {
        assertSimpleTest(() -> {
            runException("25");
            assertThat(output()).contains(BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
        });
    }

    @Test
    void MoveCommand_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "Q");
            assertThat(output()).contains(MOVE_COMMAND_ERROR_MESSAGE);
        });
    }

    @Test
    void GameCommand_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "A", "Q");
            assertThat(output()).contains(GAME_COMMAND_ERROR_MESSAGE);
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
