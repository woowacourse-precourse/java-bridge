package bridge.domain;

import bridge.ErrorMessage;
import bridge.domain.BridgeGame;
import bridge.domain.UserResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    @DisplayName("건널 칸에 대한 입력은 U또는 D만 입력해야 합니다.")
    @Test
    void createRightInputBridge() {
        UserResult userResult = new UserResult();

        assertThatThrownBy(() -> new BridgeGame().move(userResult, "A", "U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MOVE_BRIDGE_SPACE_IS_U_OR_D.getErrorMessage());
    }

    @Test
    void createTrueMoveByBridgeGame() {
        String inputBridge = "U";
        String rightBridge = "U";
        boolean expect = true;

        UserResult userResult = new UserResult();
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.move(userResult, inputBridge, rightBridge)).isEqualTo(expect);
    }

    @Test
    void createFalseMoveByBridgeGame() {
        String inputBridge = "U";
        String rightBridge = "D";
        boolean expect = false;

        UserResult userResult = new UserResult();
        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.move(userResult, inputBridge, rightBridge)).isEqualTo(expect);
    }

    @Test
    void createTrueRetryByBridgeGame() {
        String inputRetry = "R";
        boolean expect = true;

        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.retry(inputRetry)).isEqualTo(expect);
    }

    @Test
    void createFalseRetryByBridgeGame() {
        String inputRetry = "Q";
        boolean expect = false;

        BridgeGame bridgeGame = new BridgeGame();

        assertThat(bridgeGame.retry(inputRetry)).isEqualTo(expect);
    }
}