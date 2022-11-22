package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;
import static bridge.constant.MoveCommand.MOVE_DOWN_VALUE;
import static bridge.constant.MoveCommand.MOVE_UP_VALUE;
import static bridge.constant.MoveSign.MOVE_FAIL;
import static bridge.constant.MoveSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private Player player;
    private BridgeGame bridgeGame;
    private BridgeGameResults bridgeGameResults;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));

        player = new Player(
                Position.of(INIT_VALUE_OF_POSITION),
                new ChallengeNumbers(INIT_VALUE_OF_CHALLENGES));

        bridgeGame = new BridgeGame(bridge, player);
        bridgeGameResults = bridgeGame.bridgeGameResults(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage());
    }

    @DisplayName("Bridge와 다른 값을 입력 받으면 X를 반환. (Bridge의 값: U)")
    @Test
    void bridgeGameResultFail() {
        String moveResult = bridgeGame.bridgeGameResult(MOVE_DOWN_VALUE);
        assertThat(moveResult).isEqualTo(MOVE_FAIL.getMessage());
    }

    @DisplayName("Bridge와 같은 값을 입력 받으면 O를 반환. (Bridge의 값: U)")
    @Test
    void bridgeGameResultSuccess() {
        String moveResult = bridgeGame.bridgeGameResult(MOVE_UP_VALUE);
        assertThat(moveResult).isEqualTo(MOVE_SUCCESS.getMessage());
    }

    @DisplayName("Bridge와 같은 값을 입력받으면 Player의 position이 1 증가. (Bridge의 값: U)")
    @Test
    void moveSuccessIncreasePosition() {
        bridgeGame.move(MOVE_SUCCESS.getMessage());
        int position = player.position();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("Bridge와 다른 값을 입력받으면 Player의 position에 변화가 없다. (Bridge의 값: U)")
    @Test
    void moveFailNothingHappenedInPosition() {
        bridgeGame.move(MOVE_FAIL.getMessage());
        int position = player.position();

        assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0}회 retry하면 Player의 총 시도 횟수가 {1}회가 된다.")
    @CsvSource({"1,2", "5,6", "7,8"})
    void increaseNumberOfChallenges(int tryNum, int result) {
        for (int i = 0; i < tryNum; i++) {
            bridgeGame.retryOrQuit(RETRY);
        }
        assertThat(bridgeGame.totalNumberOfChallenges()).isEqualTo(result);
    }

    @DisplayName("RETRY 입력시 초기화.")
    @Test
    void retryGameInit() {
        player.move();
        bridgeGame.retryOrQuit(RETRY);

        assertThat(player.position()).isEqualTo(INIT_VALUE_OF_POSITION);
        assertThat(bridgeGameResults.upLineResults()).hasSize(0);
        assertThat(bridgeGameResults.downLineResults()).hasSize(0);
    }

    @DisplayName("RETRY 입력시 초기화 되지 않음")
    @Test
    void doNotInit() {
        player.move();
        bridgeGame.retryOrQuit(QUIT);

        assertThat(player.position()).isEqualTo(1);
        assertThat(bridgeGameResults.upLineResults()).hasSize(1);
        assertThat(bridgeGameResults.downLineResults()).hasSize(1);
    }

    @DisplayName("RETRY가 입력시 gameResult가 변경되지 않음")
    @Test
    void gameResultNoChange() {
        bridgeGame.retryOrQuit(RETRY);
        assertThat(bridgeGame).extracting("gameResult").isEqualTo("성공");
    }

    @DisplayName("QUIT이 입력시 gameResult '실패'로 변경됨.")
    @Test
    void gameResultToFail() {
        bridgeGame.retryOrQuit(QUIT);
        assertThat(bridgeGame).extracting("gameResult").isEqualTo("실패");
    }
}