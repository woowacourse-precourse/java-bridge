package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest extends NsTest {
    @Test
    @DisplayName("한번 실패, 재시작 후 완주")
    void SuccessWithoutFailTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
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

    @Test
    @DisplayName("한번 실패, 종료 선택")
    void quitWithOneFail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("U 혹은 D가 아닌 입력이 들어오면 에러 메시지를 출력한다.")
    void invalidMovingInputTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "a", "U", "D", "U");
            assertThat(output()).contains(
                    "[ERROR] U 혹은 D를 입력해 주세요."
            );
        }, 1, 0, 1);
    }

    @Test
    @DisplayName("R 혹은 Q가 아닌 입력이 입력되면 에러 메시지를 출력한다.")
    void invalidGameCommandInputTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "A", "Q");
            assertThat(output()).contains(
                    "[ERROR] R 혹은 Q를 입력해 주세요."
            );
        }, 1, 0, 1);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
