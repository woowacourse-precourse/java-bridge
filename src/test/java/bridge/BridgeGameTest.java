package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    @Test
    @DisplayName("길이가 3인 다리를 건너는데 성공한다.")
    public void playGame_CrossBridge_Success() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        boolean result = game.move(PropertyMove.UP);
        result &= game.move(PropertyMove.DOWN);
        result &= game.move(PropertyMove.UP);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("길이가 3인 다리에서 두번째 다리를 건널 때 실패한다.")
    public void playGame_CrossingBridgeAreaTwo_Fail() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        boolean result = game.move(PropertyMove.UP);
        result &= game.move(PropertyMove.UP);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("존재하지 않는 다리 영역을 건너려고 시도하여 예외를 발생한다.")
    public void playGame_MoveOverBridge_ThrowException() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        game.move(PropertyMove.UP);
        game.move(PropertyMove.DOWN);
        game.move(PropertyMove.UP);
        assertThatThrownBy(() -> game.move(PropertyMove.UP))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("게임을 실패하여 1회 재시작하여 2회차 게임을 수행중이다.")
    public void retryGame_FailCrossBridge_RestartGame2() {
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame game = new BridgeGame(bridge);
        game.move(PropertyMove.UP);
        game.move(PropertyMove.UP);
        game.retry();
        assertThat(game.getCountPlayGame())
            .isEqualTo(2);
    }

    @Test
    @DisplayName("다리를 건너는데 성공하였으나 재시작을 시도하여 예외가 발생한다.")
    public void playGame_SuccessCrossBridge_ThrowException() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        game.move(PropertyMove.UP);
        game.move(PropertyMove.DOWN);
        game.move(PropertyMove.UP);
        assertThatThrownBy(game::retry)
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("다리를 건너는 시도도 없이 재시작을 시도하여 예외를 발생한다.")
    public void retryGame_NotMoveOnce_ThrowException() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        assertThatThrownBy(game::retry)
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("게임 진행중에 재시작을 시도하여 예외를 발생한다.")
    public void retryGame_ProcessGame_ThrowException() {
        List<String> bridge = List.of("U", "D", "U");
        BridgeGame game = new BridgeGame(bridge);
        game.move(PropertyMove.UP);
        assertThatThrownBy(game::retry)
            .isInstanceOf(IllegalStateException.class);
    }

}
