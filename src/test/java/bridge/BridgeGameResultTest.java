package bridge;

import static bridge.constant.InformationMessage.GAME_RESULT_HEADER;
import static bridge.constant.InformationMessage.GAME_RESULT_IS_SUCCESS_GAME;
import static bridge.constant.InformationMessage.GAME_RESULT_PLAY_COUNT;
import static bridge.constant.InformationMessage.INPUT_BRIDGE_MOVE_RETRY;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeColumn;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameResultTest extends NsTest {

    @BeforeEach
    void 결과맵_초기화() {
        BridgeColumn.clearAllResultMap();
    }

    @Test
    void 기능_테스트_한번에_성공() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "D");
            assertThat(output()).contains(
                    GAME_RESULT_HEADER,
                    "[ O |   | O |   |   ]",
                    "[   | O |   | O | O ]",
                    String.format(GAME_RESULT_IS_SUCCESS_GAME, "성공"),
                    String.format(GAME_RESULT_PLAY_COUNT, 1)
            );
        }, 1, 0, 1, 0, 0);
    }

    @Test
    void 기능_테스트_다리_게임_실패_후_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "R", "U", "U", "D");
            assertThat(output()).contains(
                    GAME_RESULT_HEADER,
                    "[ O | O |   ]",
                    "[   |   | O ]",
                    String.format(GAME_RESULT_IS_SUCCESS_GAME, "성공"),
                    String.format(GAME_RESULT_PLAY_COUNT, 2)
            );
            int upSideIndex = output().indexOf(INPUT_BRIDGE_MOVE_RETRY);
            int downSideIndex = output().indexOf(String.format(GAME_RESULT_PLAY_COUNT, 2));
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
    }

    @Test
    void 기능_테스트_다리_게임_실패_후_종료() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "Q");
            assertThat(output()).contains(
                    GAME_RESULT_HEADER,
                    "[ O |   ]",
                    "[   | X ]",
                    String.format(GAME_RESULT_IS_SUCCESS_GAME, "실패"),
                    String.format(GAME_RESULT_PLAY_COUNT, 1)
            );
            int upSideIndex = output().indexOf(INPUT_BRIDGE_MOVE_RETRY);
            int downSideIndex = output().indexOf(String.format(GAME_RESULT_PLAY_COUNT, 1));
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 1, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}