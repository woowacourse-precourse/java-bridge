package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class BridgeGameTest extends NsTest {
    @Test
    void 끝까지_건넜을때_게임종료문구_이동한결과_출력_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        }, 1, 0, 1);
    }

    @Test
    void 재시작할때_다리를_재사용하는지_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",

                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]"
            );
        }, 1, 0, 1);
    }

    @Test
    void Q라면_최종_게임_결과와_이동한_결과를_출력하고_종료하는지_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D", "R", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",

                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | X ]",

                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | X ]",

                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 1);
    }

    @Test
    void 재시작하여_끝까지_건넜을_때_출력_형식에_맞게_결과를_출력하는지_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]",
                    "[ O | X ]",
                    "[   |   ]",

                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   |   ]",
                    "[   | O | X ]",

                    "[ O ]",
                    "[   ]",
                    "[ O |   ]",
                    "[   | O ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",

                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
