package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import generator.BridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   ]");
            int downSideIndex = output().indexOf("[   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1);

        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1);
    }

    @Test
    void 재시도_후_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "u", "D", "R", "U", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O | X ]",
                    "[   |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O | O | X ]");
            int downSideIndex = output().indexOf("[   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);

        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R",
                    "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "R", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 20"
            );

            int upSideIndex = output().indexOf("[   ]");
            int downSideIndex = output().indexOf("[ X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1);
    }

    @Test
    void 재시도_100번_후_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "U",
                    "R", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "U", "U", "D", "U", "U", "U", "U", "D",
                    "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | O |   | O | O |   | O | O |   | O | O | O | O |   | O | O | O | O |   | O ]",
                    "[   |   | O |   |   | O |   |   | O |   |   |   |   | O |   |   |   |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 100"
            );
            int upSideIndex = output()
                    .indexOf("[ O | O |   | O | O |   | O | O |   | O | O | O | O |   | O | O | O | O |   | O ]");
            int downSideIndex = output()
                    .indexOf("[   |   | O |   |   | O |   |   | O |   |   |   |   | O |   |   |   |   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1);
    }

    @Test
    void 예외_테스트_사용자_이동_U_D_가_아닐때() {
        assertSimpleTest(() -> {
            runException("3", "z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", "ㅂ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", "UU");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", "0.1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 예외_테스트_게임_명령어가_R_Q_가_아닐때() {
        assertSimpleTest(() -> {
            runException("3", "D", "z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("3", "D", "z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("3", "D", "z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("3", "U", "z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("3", "U", "z");
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
