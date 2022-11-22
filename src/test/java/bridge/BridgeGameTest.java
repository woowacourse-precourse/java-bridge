package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    BridgeGame game;

    @BeforeEach
    void beforeEach() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        game = BridgeGame.create(bridge);
    }

    @Test
    @DisplayName("BridgeGame 생성: 생성될 때 시도횟수가 1로 고정")
    void given_whenCreateBridgeGame_thenTryCountIs1() {
        assertThat(game.getTryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("BridgeGame 생성: 생성될 때 게임 진행상태가 PLAYING으로 고정")
    void given_whenCreateBridgeGame_thenGameStateIsPlaying() {
        assertThat(game.getState()).isEqualTo(BridgeGameState.PLAYING);
    }

    @Test
    @DisplayName("통합 테스트: 성공한 게임 결과 확인")
    void given_whenSuccessAllMoves_thenResultHasOOnly() {
        game.move(BridgeGameMovingInput.UP);
        game.move(BridgeGameMovingInput.DOWN);
        game.move(BridgeGameMovingInput.DOWN);
        assertThat(game.getResult()).isEqualTo(
                "[ O |   |   ]\n"
                        + "[   | O | O ]"
        );
    }

    @Test
    @DisplayName("통합 테스트: 실패한 게임 결과 확인")
    void given_whenFailToMove_thenResultHasX() {
        game.move(BridgeGameMovingInput.UP);
        game.move(BridgeGameMovingInput.DOWN);
        game.move(BridgeGameMovingInput.UP);
        assertThat(game.getResult()).isEqualTo(
                "[ O |   |   ]\n"
                        + "[   | O | X ]"
        );
    }
}
