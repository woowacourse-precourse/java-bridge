package bridge.structure;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 다리_만들기_크기_작음() throws Exception {

        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        //when
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeMaker.makeBridge(2));
    }

    @Test
    void 다리_만들기_크기_큼() throws Exception {

        //given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

        //when
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeMaker.makeBridge(21));
    }
}