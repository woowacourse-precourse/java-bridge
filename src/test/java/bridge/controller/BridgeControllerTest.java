package bridge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.BridgeGame;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeControllerTest {
    private final BridgeController bridgeController = new BridgeController();

    @DisplayName("processGame 테스트 (true 경우)")
    @Test
    public void processTrueCaseTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));
        User user = new User();
        boolean isUserAnswerCorrect = true;

        // when
        bridgeController.processGame(bridgeGame, user, isUserAnswerCorrect);

        // then
        assertThat(bridgeGame.getNowIndex()).isEqualTo(1);
    }

    @DisplayName("doFailCase 테스트 (restart 경우)")
    @Test
    public void doFailCaseWithRestartTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));
        User user = new User();
        String gameStatus = "R";

        // when
        bridgeController.doFailCase(bridgeGame, user, gameStatus);

        // then
        assertThat(user.getGameTryCount()).isEqualTo(2);
    }

    @DisplayName("doFailCase 테스트 (Quit 경우)")
    @Test
    public void doFailCaseWithQuitTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "D"));
        User user = new User();
        String gameStatus = "Q";

        // when
        bridgeController.doFailCase(bridgeGame, user, gameStatus);

        // then
        assertThat(user.isGameWin()).isEqualTo(false);
        assertThat(user.isGameDoneStatus()).isEqualTo(true);
    }

    @DisplayName("doSuccessCase 테스트")
    @Test
    public void doSuccessCaseTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "U", "U"));
        User user = new User();

        // when
        bridgeController.doSuccessCase(bridgeGame, user);

        // then
        assertThat(bridgeGame.getNowIndex()).isEqualTo(1);
    }
}
