package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest extends NsTest {

    BridgeGameController bridgeGameController = new BridgeGameController();

    @DisplayName("다리의 길이가 최소일 때 테스트")
    @Test
    void minBridgeLength() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "D", "D", "U");
            assertThat(output()).contains(
                    "[ O |   |   |   | O ]",
                    "[   | O | O | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   |   | O ]");
            int downSideIndex = output().indexOf("[   | O | O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 0, 0, 1);
    }

    @DisplayName("다리의 길이가 최대일 때 테스트")
    @Test
    void maxBridgeLength() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "D", "D", "D", "D", "D", "D", "D", "D", "D",
                    "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D");
            assertThat(output()).contains(
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]",
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf(
                    "[   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   ]");
            int downSideIndex = output().indexOf(
                    "[ O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    @DisplayName("2번 틀리고 다리 건너기 성공했을 때 테스트")
    @Test
    void wrongTwiceAndSucceed() {
        assertRandomNumberInRangeTest(() -> {
            run("7", "U", "D", "R", "U", "U", "U", "R", "U", "U", "D", "U", "D", "U", "D");
            assertThat(output()).contains(
                    "[ O | O |   | O |   | O |   ]",
                    "[   |   | O |   | O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O | O |   | O |   | O |   ]");
            int downSideIndex = output().indexOf("[   |   | O |   | O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0, 1, 0, 1, 0);
    }

    @Override
    protected void runMain() {
        bridgeGameController.start();
    }
}