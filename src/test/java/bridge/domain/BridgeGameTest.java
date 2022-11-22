package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGame 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameTest {

    private final AnswerBridge bridge = new AnswerBridge(List.of("U", "D", "U"));

    @Test
    void move는_라운드와_방향을_입력받아_정답인_경우_MoveResult_SUCCESS를_반환한다() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MoveResult result = bridgeGame.move(Round.valueOf(1), Direction.UP);

        assertThat(result).isEqualTo(MoveResult.SUCCESS);
    }

    @Test
    void move는_라운드와_방향을_입력받아_오답인_경우_MoveResult_FAIL을_반환한다() {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MoveResult result = bridgeGame.move(Round.valueOf(1), Direction.DOWN);

        assertThat(result).isEqualTo(MoveResult.FAIL);
    }

    @Test
    void retry_메서드는_PLAY를_입력받는다면_게임을_계속_진행시킨다() {
        BridgeGame bridgeGame = new BridgeGame(bridge, BridgeGameStatus.STOP);

        bridgeGame.retry();

        assertThat(bridgeGame.isPlayable()).isTrue();
    }

    @Test
    void isPlayable_메서드는_게임진행이_가능하다면_true를_반환한다() {
        BridgeGame bridgeGame = new BridgeGame(bridge);

        assertThat(bridgeGame.isPlayable()).isTrue();
    }

    @Test
    void isPlayable_메서드는_게임진행이_불가능하다면_false를_반환한다() {
        BridgeGame bridgeGame = new BridgeGame(bridge, BridgeGameStatus.STOP);

        assertThat(bridgeGame.isPlayable()).isFalse();
    }
}
