package bridge.controller;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameMachineTest extends NsTest {

    @Nested
    @DisplayName("Bridge 게임 성공")
    class Test1 {

        @DisplayName("3라운드에 게임 실패 후 재시작 하고 성공 테스트")
        @Test
        void 한_번에_다리_건너기_성공_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "D", "U", "U");
                assertThat(output()).contains(
                        "최종 게임 결과",
                        "[   | O | O ]",
                        "[ O |   |   ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[   | O | O ]");
                int downSideIndex = output().indexOf("[ O |   |   ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 0, 1, 1);
        }

        @DisplayName("2라운드에 게임 실패 후 재시작 후 게임 성공 테스트")
        @Test
        void 두번쨰_라운드에_게임_실패_후_재시작_후_게임_성공_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "U", "D", "R", "U", "U", "U");
                assertThat(output()).contains(
                        "[ O |   ]",
                        "[   | X ]",
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[ O | O | O ]",
                        "[   |   |   ]",
                        "게임 성공 여부: 성공",
                        "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O |   ]");
                int downSideIndex = output().indexOf("[   | X ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 1);
        }
    }

    @Nested
    @DisplayName("Bridge 게임 실패")
    class Test2 {

        @DisplayName("1라운드에 게임 실패 후 게임 종료 테스트")
        @Test
        void 첫번쨰_라운드에_게임_실패_후_게임_종료_테스트() {
            assertRandomNumberInRangeTest(() -> {
                run("3", "D", "Q");
                assertThat(output()).contains(
                        "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                        "최종 게임 결과",
                        "[   ]",
                        "[ X ]",
                        "게임 성공 여부: 실패",
                        "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[   ]");
                int downSideIndex = output().indexOf("[ X ]");
                assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 1, 1);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
