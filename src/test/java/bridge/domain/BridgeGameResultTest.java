package bridge.domain;

import static bridge.domain.Direction.DOWN;
import static bridge.domain.Direction.UP;
import static bridge.domain.MoveResult.FAIL;
import static bridge.domain.MoveResult.NOT_MOVE;
import static bridge.domain.MoveResult.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameResultTest {

    @Test
    void addResult_메서드는_해당_라운드의_게임_결과를_입력한다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), new PlayerMove(SUCCESS, UP));

        assertThat(bridgeGameResult.getResult()).containsExactly(List.of(SUCCESS), List.of(NOT_MOVE));
    }

    @Test
    void getResult_메서드는_1라운드_부터의_게임_결과를_반환한다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), new PlayerMove(SUCCESS, UP));
        bridgeGameResult.addResult(Round.valueOf(2), new PlayerMove(FAIL, DOWN));
        bridgeGameResult.addResult(Round.valueOf(3), new PlayerMove(SUCCESS, UP));

        assertThat(bridgeGameResult.getResult()).containsExactly(
                List.of(SUCCESS, NOT_MOVE, SUCCESS),
                List.of(NOT_MOVE, FAIL, NOT_MOVE)
        );
    }

    @Test
    void reset_메서드는_게임_결과를_초기화_시킨다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), new PlayerMove(SUCCESS, UP));

        bridgeGameResult.reset();

        assertThat(bridgeGameResult.getResult()).isEmpty();
    }

    @Test
    void checkPassed_메서드는_결과중_FAIL이_존재하지_않는경우_Victory_VICTORY를_반환한다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), new PlayerMove(SUCCESS, UP));
        bridgeGameResult.addResult(Round.valueOf(2), new PlayerMove(SUCCESS, UP));

        assertThat(bridgeGameResult.checkPassed()).isEqualTo(Victory.VICTORY);
    }

    @Test
    void checkPassed_메서드는_결과중_FAIL이_존재하는_경우_Victory_DEFEAT를_반환한다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), new PlayerMove(SUCCESS, UP));
        bridgeGameResult.addResult(Round.valueOf(2), new PlayerMove(SUCCESS, UP));
        bridgeGameResult.addResult(Round.valueOf(3), new PlayerMove(FAIL, UP));

        assertThat(bridgeGameResult.checkPassed()).isEqualTo(Victory.DEFEAT);
    }
}
