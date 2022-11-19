package bridge.domain;

import static bridge.domain.MoveResult.FAIL;
import static bridge.domain.MoveResult.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

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
        bridgeGameResult.addResult(Round.valueOf(1), SUCCESS);

        assertThat(bridgeGameResult.getResult()).containsExactly(SUCCESS);
    }

    @Test
    void getResult_메서드는_1라운드_부터의_게임_결과를_반환한다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), SUCCESS);
        bridgeGameResult.addResult(Round.valueOf(2), FAIL);
        bridgeGameResult.addResult(Round.valueOf(3), SUCCESS);

        assertThat(bridgeGameResult.getResult()).containsExactly(SUCCESS, FAIL, SUCCESS);
    }

    @Test
    void reset_메서드는_게임_결과를_초기화_시킨다() {
        BridgeGameResult bridgeGameResult = new BridgeGameResult();
        bridgeGameResult.addResult(Round.valueOf(1), SUCCESS);

        bridgeGameResult.reset();

        assertThat(bridgeGameResult.getResult()).isEmpty();
    }
}
