package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {
    private BridgeMaker bridgeMaker;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    @BeforeEach
    public void setUP(){
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @Test
    void 다리길이_테스트1(){
        List<String> test = bridgeMaker.makeBridge(2);
        assertThatThrownBy(()-> new Bridge(test)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 다리길이_테스트2(){
        List<String> test = bridgeMaker.makeBridge(21);
        assertThatThrownBy(()-> new Bridge(test)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리구별_숫자_테스트(){
        assertThatThrownBy(()-> new Bridge(new ArrayList<>(List.of("U","D","A")))).isInstanceOf(IllegalArgumentException.class);
    }
}