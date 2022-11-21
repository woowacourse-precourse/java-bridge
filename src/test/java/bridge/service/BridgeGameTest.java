package bridge.service;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
    private BridgeGame bridgeGame = new BridgeGame();

    @DisplayName("move 테스트 (유저가 이동을 했지만, 아직까지 완료되지 않은 상태)")
    @Test
    public void moveTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();

        // when
        bridgeGame.move(bridge, user);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("move 테스트 (유저가 이동을 하고, 게임을 성공적으로 마무리 한 경우)")
    @Test
    public void moveTest2() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();

        // when
        bridgeGame.move(bridge, user);

        // then
        assertThat(user.isGameWin()).isEqualTo(true);
        assertThat(user.isGameWin()).isEqualTo(true);
    }

    @DisplayName("유저가 모든 턴을 성공적으로 돌았는지 확인해주는 isUserPassedAllTurnTest 테스트")
    @Test
    public void isUserPassedAllTurnTest() {
        // given
        Bridge bridgeWithNormal = new Bridge(List.of("U", "U", "D"));
        Bridge bridgeWithEndOfIndex = new Bridge(List.of("U", "U", "D"));
        bridgeWithEndOfIndex.nowIndexUpdate();
        bridgeWithEndOfIndex.nowIndexUpdate();

        // when
        boolean resultWithNormal = bridgeGame.isUserPassedAllTurn(bridgeWithNormal);
        boolean resultWithEndOfIndex = bridgeGame.isUserPassedAllTurn(bridgeWithEndOfIndex);

        // then
        assertThat(resultWithNormal).isEqualTo(false);
        assertThat(resultWithEndOfIndex).isEqualTo(true);
    }

    @DisplayName("유저가 입력한 방향이 정답인지 확인해주는 isUserAnswerCorrect 테스트")
    @Test
    public void isUserAnswerCorrectTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        String moveDirectionUp = "U";
        String moveDirectionDown = "D";

        // when
        boolean isFalseCase = bridgeGame.isUserAnswerCorrect(moveDirectionDown, bridge);
        boolean isSuccessCase = bridgeGame.isUserAnswerCorrect(moveDirectionUp, bridge);

        // then
        assertThat(isSuccessCase).isEqualTo(true);
        assertThat(isFalseCase).isEqualTo(false);
    }

    @DisplayName("유저가 맞히지 못한 경우 doFailCaseWithQuitTest 테스트 (Restart의 경우)")
    @Test
    public void handleFailCaseCommandWithRestartTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();
        bridge.nowIndexUpdate(); // 1
        user.gameRetry(); // 2
        String command = "R";

        // when
        bridgeGame.handleFailCaseCommand(bridge, user, command); // 3

        // then
        assertThat(user.getGameTryCount()).isEqualTo(3);
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }

    @DisplayName("유저가 맞히지 못한 경우 doFailCaseWithQuitTest 테스트 (Quit의 경우)")
    @Test
    public void handleFailCaseCommandWithQuitTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        User user = new User();
        String command = "Q";

        // when
        bridgeGame.handleFailCaseCommand(bridge, user, command);

        // then
        assertThat(user.isGameWin()).isEqualTo(false);
        assertThat(user.isGameDoneStatus()).isEqualTo(true);
    }


    @DisplayName("retry 테스트")
    @Test
    public void retryTest() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "D", "D", "U"));
        User user = new User();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();
        bridge.nowIndexUpdate();

        // when
        bridgeGame.retry(bridge, user);

        // then
        assertThat(bridge.getNowIndex()).isEqualTo(0);
    }
}
