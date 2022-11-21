package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import bridge.constant.GameState;
import bridge.util.Validate;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class BridgeCoreTest extends NsTest{



    @Test
    @DisplayName("재시도 후 게임을 성공했을 경우")
    void retryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D","R","U", "D", "U");
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
    @DisplayName("재시도 후 중도에 게임을 끝낼 경우")
    void wrongFinishAndQuitTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D","R","U", "U", "Q");
            assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O | X ]",
                "[   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }


    @Test
    @DisplayName("재시도 X 게임을 끝 직전에서 그만뒀을 때")
    void wrongFinishFinal() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U","D","D", "Q");
            assertThat(output()).contains(
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "최종 게임 결과",
                "[ O |   |   ]",
                "[   | O | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }








    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
