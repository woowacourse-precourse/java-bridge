package bridge.game.bridgeGame;

import bridge.structure.BridgeMoveValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeGameResultsTest {

    @Test
    void 게임_결과_출력() throws Exception {
        //given
        BridgeGameResults bridgeGameResults = new BridgeGameResults();
        BridgeGameResult bridgeGameResult = new BridgeGameResult(BridgeMoveValue.UP, true);

        //when
        bridgeGameResults.add(bridgeGameResult);
        String result = bridgeGameResults.toString();

        //then
        Assertions.assertThat(result)
                .contains("[ O ]")
                .contains("[   ]");
    }

}