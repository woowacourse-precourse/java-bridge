package bridge.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest extends NsTest {
    @Test
    void 길이_5인_다리_1번_시도만에_완주_성공하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 길이_20인_다리_1번_시도만에_완주_성공하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("20", "U", "D", "U", "D", "D", "D", "U", "U", "D", "U", "D", "U", "U", "U", "D", "U", "U", "D", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   |   | O | O |   | O |   | O | O | O |   | O | O |   |   |   ]",
                    "[   | O |   | O | O | O |   |   | O |   | O |   |   |   | O |   |   | O | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   |   | O | O |   | O |   | O | O | O |   | O | O |   |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O | O |   |   | O |   | O |   |   |   | O |   |   | O | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0);
    }

    @Test
    void 길이_5인_다리_1번_실패하고_재시작_후_완주_성공하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "U", "R", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 길이_5인_다리_2번_실패하고_재시작_후_완주_성공하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "U", "R", "D", "U", "U", "R", "D", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[ O |   | O |   |   ]");
            int downSideIndex = output().indexOf("[   | O |   | O | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 길이_5인_다리_1번_실패하고_그대로_종료하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | X ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf( "[ O |   | O | X ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 길이_10인_다리_2번_재시도_후_3번째_실패_시_그대로_종료하는_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("10", "D", "U", "D", "R", "U", "U", "D", "D", "R", "U", "U", "D", "D", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O | O | O |   | O | O |   |   | X ]",
                    "[ O |   |   |   | O |   |   | O | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );

            int upSideIndex = output().indexOf("[   | O | O | O |   | O | O |   |   | X ]");
            int downSideIndex = output().indexOf("[ O |   |   |   | O |   |   | O | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}