package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeStateServiceTest extends NsTest {

    @Nested
    @DisplayName("BridgeStateService Class")
    class BridgeStateServiceKoTest {

        @Test
        void rightInput() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "U", "D", "U");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O |   | O ]");
                int downSideIndex = output().indexOf("[   | O |   ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongFirstInputAndQuit() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "D", "Q");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[   ]");
                int downSideIndex = output().indexOf("[ X ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongFirstInputAndRetry() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "D", "R", "U", "D", "U");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[   ]",
                    "[ X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O |   | O ]");
                int downSideIndex = output().indexOf("[   | O |   ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongSecondInputAndQuit() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "U", "U", "Q");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O | X ]");
                int downSideIndex = output().indexOf("[   |   ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongSecondInputAndRetry() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "U", "U", "R", "U", "D", "U");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O |   | O ]");
                int downSideIndex = output().indexOf("[   | O |   ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongThirdInputAndQuit() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "U", "D", "D", "Q");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
                );

                int upSideIndex = output().indexOf("[ O |   |   ]");
                int downSideIndex = output().indexOf("[   | O | X ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }

        @Test
        void wrongThirdInputAndRetry() {

            assertRandomNumberInRangeTest(() -> {
                // given
                run("3", "U", "D", "D", "R", "U", "D", "U");
                // when

                // then
                Assertions.assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",

                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
                );

                int upSideIndex = output().indexOf("[ O |   | O ]");
                int downSideIndex = output().indexOf("[   | O |   ]");
                Assertions.assertThat(upSideIndex).isLessThan(downSideIndex);
            }, 1, 0, 1);
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
