package bridge.game.bridgeGame;

import bridge.structure.BridgeMoveValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameResultTest {

    @Test
    void 결과_만들기_성공_위() throws Exception {
        //given
        BridgeMoveValue up = BridgeMoveValue.UP;
        boolean pass = true;

        //when
        BridgeGameResult bridgeGameResult = new BridgeGameResult(up, pass);

        //then
        Assertions.assertThat(bridgeGameResult.getBridgeGameResult())
                .containsExactly("O", " ");
    }

    @Test
    void 결과_만들기_실패_아래() throws Exception {
        //given
        BridgeMoveValue down = BridgeMoveValue.DOWN;
        boolean pass = false;

        //when
        BridgeGameResult bridgeGameResult = new BridgeGameResult(down, pass);

        //then
        Assertions.assertThat(bridgeGameResult.getBridgeGameResult())
                .containsExactly(" ", "X");
    }

}