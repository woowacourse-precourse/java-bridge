package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.ui.input.InputErrorText;
import org.junit.jupiter.api.Test;

public class CustomApplicationTest extends ApplicationTest {

    @Test
    void 중도_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }

    @Test
    void 여러번_시도_후_중도_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "D", "R", "D", "Q");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 1);
    }
    @Test
    void 여러번_시도_후_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "D", "R", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 4"
            );
        }, 1, 0, 1);
    }


    @Test
    void 방향_입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3","K");
            assertThat(output()).contains(InputErrorText.ERROR_MOVE_COMMAND.errorText());
        });
    }

    @Test
    void 재시작_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "D", "Restart");
            assertThat(output()).contains(InputErrorText.ERROR_RESTART_COMMAND.errorText());
        }, 1, 0, 1);
    }
}
