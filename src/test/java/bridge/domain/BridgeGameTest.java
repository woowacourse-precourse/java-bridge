package bridge.domain;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.constants.GameCommands;
import bridge.domain.move_result.MoveResults;
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
    private final Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private final MoveResults moveResults = new MoveResults();
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new NumberOfChallenges(INIT_VALUE_OF_CHALLENGES));
        moveResults.addResults(MOVE_UP_COMMAND, MOVE_SUCCESS);
        bridgeGame = new BridgeGame(bridge, player, moveResults);
    }

    @DisplayName("Bridge와 같은 값을 입력 받으면 O를 반환한다. (Bridge의 값: U)")
    @Test
    void moveTestTrue() {
        String moveResult = bridgeGame.moveResult(MOVE_UP_COMMAND);
        assertThat(moveResult).isEqualTo("O");
    }

    @DisplayName("Bridge와 다른 값을 입력 받으면 X를 반환한다. (Bridge의 값: U)")
    @Test
    void moveTestFalse() {
        String moveResult = bridgeGame.moveResult(MOVE_DOWN_COMMAND);
        assertThat(moveResult).isEqualTo("X");
    }

    @DisplayName("Bridge와 같은 값을 입력받으면 Player의 position이 1 증가한다. (Bridge의 값: U)")
    @Test
    void increasePosition() {
        bridgeGame.move("O");
        int position = player.position();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("Bridge와 다른 값을 입력받으면 Player의 position에 변화가 없다. (Bridge의 값: U)")
    @Test
    void nothingHappenedInPosition() {
        bridgeGame.move("X");
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
}