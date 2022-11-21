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

    @Test
    void 게임_결과_출력_여러개() throws Exception {
        //given
        BridgeGameResults bridgeGameResults = new BridgeGameResults();
        BridgeGameResult bridgeGameResult = new BridgeGameResult(BridgeMoveValue.UP, true);

        //when
        bridgeGameResults.add(bridgeGameResult);
        bridgeGameResults.add(bridgeGameResult);
        String result = bridgeGameResults.toString();

        //then
        Assertions.assertThat(result)
                .contains("[ O | O ]")
                .contains("[   |   ]");
    }

    @Test
    void 게임_결과_출력_여러개_실패_포함() throws Exception {
        //given
        BridgeGameResults bridgeGameResults = new BridgeGameResults();
        BridgeGameResult bridgeGameResultTrue = new BridgeGameResult(BridgeMoveValue.UP, true);
        BridgeGameResult bridgeGameResultFalse = new BridgeGameResult(BridgeMoveValue.UP, false);

        //when
        bridgeGameResults.add(bridgeGameResultTrue);
        bridgeGameResults.add(bridgeGameResultFalse);
        String result = bridgeGameResults.toString();

        //then
        Assertions.assertThat(result)
                .contains("[ O | X ]")
                .contains("[   |   ]");
    }

}