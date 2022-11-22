package bridge.domain;

import static bridge.domain.MoveResult.FAIL;
import static bridge.domain.MoveResult.NOT_MOVE;
import static bridge.domain.MoveResult.SUCCESS;
import static bridge.domain.PlayerMove.DOWN_FAIL;
import static bridge.domain.PlayerMove.UP_FAIL;
import static bridge.domain.PlayerMove.UP_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameResultTest {

    BridgeGameResult generateGameResult(int roundSize, List<PlayerMove> playerMove) {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();

        for (int i = 1; i <= roundSize; i++) {
            bridgeGameResult.addResult(Round.valueOf(i), playerMove.get(i - 1));
        }

        return bridgeGameResult;
    }

    @Test
    void addResult_메서드는_해당_라운드의_게임_결과를_입력한다() {
        BridgeGameResult bridgeGameResult = generateGameResult(1, List.of(UP_SUCCESS));

        assertThat(bridgeGameResult.getResult()).containsExactly(List.of(SUCCESS), List.of(NOT_MOVE));
    }

    @Test
    void getResult_메서드는_1라운드_부터의_게임_결과를_반환한다() {
        BridgeGameResult bridgeGameResult = generateGameResult(
                3,
                List.of(UP_SUCCESS, DOWN_FAIL, UP_SUCCESS)
        );

        assertThat(bridgeGameResult.getResult()).containsExactly(
                List.of(SUCCESS, NOT_MOVE, SUCCESS),
                List.of(NOT_MOVE, FAIL, NOT_MOVE)
        );
    }

    @Test
    void reset_메서드는_게임_결과를_초기화_시킨다() {
        BridgeGameResult bridgeGameResult = generateGameResult(1, List.of(UP_SUCCESS));

        bridgeGameResult.reset();

        assertThat(bridgeGameResult.getResult()).isEmpty();
    }

    @Test
    void checkPassed_메서드는_결과중_FAIL이_존재하지_않는경우_Victory_VICTORY를_반환한다() {
        BridgeGameResult bridgeGameResult = generateGameResult(
                3,
                List.of(UP_SUCCESS, UP_SUCCESS, UP_SUCCESS)
        );

        assertThat(bridgeGameResult.checkPassed()).isEqualTo(Victory.VICTORY);
    }

    @Test
    void checkPassed_메서드는_결과중_FAIL이_존재하는_경우_Victory_DEFEAT를_반환한다() {
        BridgeGameResult bridgeGameResult = generateGameResult(
                3,
                List.of(UP_SUCCESS, UP_SUCCESS, UP_FAIL)
        );

        assertThat(bridgeGameResult.checkPassed()).isEqualTo(Victory.DEFEAT);
    }
}
