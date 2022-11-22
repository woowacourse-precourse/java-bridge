package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {

    @DisplayName("bridge 생성이 제대로 되는지 확인")
    @Test
    void checkRandomNumbers() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 10;
        bridgeMaker.makeBridge(size);

        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(bridgeMaker.makeBridge(size)).isEqualTo((List.of("U", "U", "U", "D", "D", "D", "D", "D", "U", "U")));
                }, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1);
    }

    @DisplayName("다리 건너기 성공 확인 테스트")
    @Test
    void 다리_건너기_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "D");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O |   ]",
                    "[ O |   | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[   | O |   ]");
            int downSideIndex = output().indexOf("[ O |   | O ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1, 0);
    }

    @DisplayName("다리 건너기 실패 확인 테스트")
    @Test
    void 다리_건너기_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   |   ]",
                    "[ O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[   |   ]");
            int downSideIndex = output().indexOf("[ O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0, 1);
    }

    @DisplayName("다리 건너기 실패 - 재시작 후, 성공 테스트")
    @Test
    void 다리_건너기_실패_후_재시작_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "R", "D", "U", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[   | O | O ]",
                    "[ O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int upSideIndex = output().indexOf("[   | O | O ]");
            int downSideIndex = output().indexOf("[ O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);

        }, 0, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
