package bridge.game.bridgeGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameStatusTest {

    @Test
    void 다리_게임_계속여부_실패_판단() throws Exception {
        //given
        BridgeGameStatus status = BridgeGameStatus.FALL;

        //when

        //then
        Assertions.assertThat(status.isContinue())
                .isTrue();
    }
    @Test
    void 다리_게임_계속여부_모두성공_판단() throws Exception {
        //given
        BridgeGameStatus status = BridgeGameStatus.CORRECT;

        //when

        //then
        Assertions.assertThat(status.isContinue())
                .isTrue();
    }

    @Test
    void 다리_게임_계속여부_예외() throws Exception {
        //given
        BridgeGameStatus status = BridgeGameStatus.BEFORE_START;

        //when

        //then
        Assertions.assertThat(status.isContinue())
                .isFalse();
    }
}