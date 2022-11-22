package bridge;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;

public class BridgeTest extends NsTest{

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_길이_범위_예외_테스트_3_보다_작은거_입력() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void 다리_길이_범위_예외_테스트_20_보다_큰거_입력() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }


    @Test
    void 다리_생성후_이동입력_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void R_또는_Q_인데_다른거_입력시_예외_테스트() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "D", "U", "A");
            assertThat(output()).contains(ERROR_MESSAGE);
        }, 1, 0, 0);
    }
    @Test
    void R_U_R_U_R_U_Q_했을때_최종트라이_횟수_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "R", "U", "R", "U", "Q");
            assertThat(output()).contains(
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 4"
            );
        }, 1, 0, 0);
    }
    @Test
    void R_U_R_U_R_U_R_D_했을때_최종결과_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "R", "U", "R", "U", "R", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 5"
            );
        }, 1, 0, 0);
    }
    @Test
    void 틀렸을때_잘표시하는지_예외_처리() {
        assertRandomNumberInRangeTest(() -> {
            runException("3", "U", "U");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]"
            );
        }, 1, 0);
    }

    @Test
    void 포기했을때_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            int upSideIndex = output().indexOf("[ O |   | X ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
