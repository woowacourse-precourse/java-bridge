package bridge.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeControllerTest extends NsTest {
    @Test
    @DisplayName("한번 실패 후 종료")
    void CloseAfterFail() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   ]",
                    "[   | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   ]");
            int downSideIndex = output().indexOf("[   | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1);
    }

    @Test
    @DisplayName("한번 실패 후 성공")
    void SuccessAfterFail() {
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

            int upSideIndex = output().indexOf("[ O | O | O ]");
            int downSideIndex = output().indexOf("[   |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 1);
    }

    @Override
    protected void runMain() {
        BridgeController bridgeController = new BridgeController();
        bridgeController.run();
    }
}