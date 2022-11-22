package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    public void initialize() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("이동 가능한 칸일 경우 이동하는지 테스트")
    @Test
    public void addOWhenEqualTest() {
        String movingCommand = "U";
        String currBox = "U";
        bridgeGame.addOWhenEqual(movingCommand, currBox);

        List<String> bridgeCurrStatus = bridgeGame.getBridgeCurrStatus();
        assertThat(bridgeCurrStatus).isEqualTo(List.of("O"));
    }

    @DisplayName("이동 불가능한 칸일 경우 이동하지 않는지 테스트")
    @Test
    public void addXWhenUnequalTest() {
        String movingCommand = "U";
        String currBox = "D";
        bridgeGame.addXWhenUnequal(movingCommand, currBox);

        List<String> bridgeCurrStatus = bridgeGame.getBridgeCurrStatus();
        assertThat(bridgeCurrStatus).isEqualTo(List.of("X"));
    }

    @DisplayName("게임 성공 여부 잘 판단하는지 테스트")
    @Test
    public void isSuccessTest() {
        List<String> bridge = List.of("U", "D", "U");
        bridgeGame = new BridgeGame(List.of("O", "O", "O"));

        assertThat(bridgeGame.isSuccess(bridge)).isEqualTo(true);
    }

    @DisplayName("게임 실패 여부 잘 판단하는지 테스트")
    @Test
    public void isFailureTest() {
        bridgeGame = new BridgeGame(List.of("O", "X"));

        assertThat(bridgeGame.isFailure()).isEqualTo(true);
    }
}
