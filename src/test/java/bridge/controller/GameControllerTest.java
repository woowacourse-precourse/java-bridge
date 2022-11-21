package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameControllerTest extends NsTest {

    @Nested
    @DisplayName("GameController 테스트")
    class GameController {

        @Test
        void 하한_경계값_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "D");
                assertThat(output()).contains(
                        "[ O |   |   ]",
                        "[   | O | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );
            }, 1, 0, 0);
        }

        @Test
        void 상한_경계값_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("20", "U", "D", "D", "U", "D", "U", "U", "U", "U",
                        "D", "U", "D", "U", "U", "U", "D", "U", "D", "D", "D");
                assertThat(output()).contains(
                        "[ O |   |   | O |   | O | O | O | O |   | O |   | O | O | O |   | O |   |   |   ]",
                        "[   | O | O |   | O |   |   |   |   | O |   | O |   |   |   | O |   | O | O | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );
            }, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0);
        }

        @Test
        void 리셋_기능_제외_최종_통합_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("15", "U", "D", "U", "U", "U", "U", "D", "D", "U", "D", "U", "D", "U", "D", "U");
                assertThat(output()).contains(
                        "[ O |   | O | O | O | O |   |   | O |   | O |   | O |   | O ]",
                        "[   | O |   |   |   |   | O | O |   | O |   | O |   | O |   ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );
            }, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1);
        }


        @Test
        void 리셋_기능_포함_최종_통합_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("7", "U", "D", "U", "U", "U", "U", "U", "R", "U", "D", "U", "U", "U", "U", "D");
                assertThat(output()).contains(
                        "[ O |   | O | O | O | O |   ]",
                        "[   | O |   |   |   |   | O ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 2"
                );
            }, 1, 0, 1, 1, 1, 1, 0);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}