package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BridgeGameControllerTest {

    private static final BridgeMaker bridgeMaker= new BridgeMaker(new BridgeRandomNumberGenerator());

    @ValueSource(ints = {3,10,18})
    @ParameterizedTest
    void 다리_길이_테스트(int size){
        //when
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        //then
        assertThat(bridgeGame.getBridgeSize()).isEqualTo(size);
    }
}
