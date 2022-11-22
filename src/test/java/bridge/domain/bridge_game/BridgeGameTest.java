package bridge.domain.bridge_game;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.constants.GameCommands;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private Player player;
    private BridgeGame bridgeGame;
    private MoveResults moveResults;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new NumberOfChallenges(INIT_VALUE_OF_CHALLENGES));

        bridgeGame = new BridgeGame(bridge, player);
        moveResults = bridgeGame.moveResults(MOVE_UP_COMMAND, MOVE_SUCCESS);
    }

    @DisplayName("Bridge와 같은 값을 입력 받으면 O를 반환한다. (Bridge의 값: U)")
    @Test
    void moveResultSuccess() {
        String moveResult = bridgeGame.moveResult(MOVE_UP_COMMAND);
        assertThat(moveResult).isEqualTo(MOVE_SUCCESS);
    }

    @DisplayName("Bridge와 다른 값을 입력 받으면 X를 반환한다. (Bridge의 값: U)")
    @Test
    void moveResultFail() {
        String moveResult = bridgeGame.moveResult(MOVE_DOWN_COMMAND);
        assertThat(moveResult).isEqualTo(MOVE_FAIL);
    }

    @DisplayName("Bridge와 같은 값을 입력받으면 Player의 position이 1 증가한다. (Bridge의 값: U)")
    @Test
    void moveSuccessIncreasePosition() {
        bridgeGame.move(MOVE_SUCCESS);
        int position = player.position();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("Bridge와 다른 값을 입력받으면 Player의 position에 변화가 없다. (Bridge의 값: U)")
    @Test
    void moveFailNothingHappenedInPosition() {
        bridgeGame.move(MOVE_FAIL);
        int position = player.position();

        assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0}회 retry하면 Player의 총 시도 횟수가 {1}회가 된다.")
    @CsvSource({"1,2", "5,6", "10,11"})
    void increaseNumberOfChallenges(int tryNum, int result) {
        for (int i = 0; i < tryNum; i++) {
            bridgeGame.retryOrQuit(GameCommands.RETRY);
        }
        assertThat(bridgeGame.totalNumberOfChallenges()).isEqualTo(result);
    }

    @DisplayName("GameCommands.RETRY가 입력되면 초기화가 된다.")
    @Test
    void retryGameInit() {
        player.move();
        bridgeGame.retryOrQuit(GameCommands.RETRY);

        assertThat(player.position()).isEqualTo(INIT_VALUE_OF_POSITION);
        assertThat(moveResults.upLineResults()).hasSize(0);
        assertThat(moveResults.downLineResults()).hasSize(0);
    }

    @DisplayName("GameCommands.QUIT이 입력되면 초기화가 되지 않는다.")
    @Test
    void doNotInit() {
        player.move();
        bridgeGame.retryOrQuit(GameCommands.QUIT);

        assertThat(player.position()).isEqualTo(1);
        assertThat(moveResults.upLineResults()).hasSize(1);
        assertThat(moveResults.downLineResults()).hasSize(1);
    }

    @DisplayName("RETRY가 입력되면 gameResult가 변경되지 않는다.")
    @Test
    void gameResultNoChange() {
        bridgeGame.retryOrQuit(GameCommands.RETRY);
        assertThat(bridgeGame).extracting("gameResult").isEqualTo("성공");
    }

    @DisplayName("QUIT이 입력되면 gameResult가 '실패'로 변경된다.")
    @Test
    void gameResultToFail() {
        bridgeGame.retryOrQuit(GameCommands.QUIT);
        assertThat(bridgeGame).extracting("gameResult").isEqualTo("실패");
    }
}