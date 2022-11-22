package bridge;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeMakerTest {
    @Test
    void 랜덤_다리_생성(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String length = "5";
        assertThat(bridgeMaker.makeRandomBridgeProcess(length)).size().isEqualTo(Integer.valueOf(length));
    }

    @Test
    void 다리_길이가_작을때(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String length = "2";
        assertThatThrownBy(() -> bridgeMaker.makeRandomBridgeProcess(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리_길이가_클때(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String length = "21";
        assertThatThrownBy(() -> bridgeMaker.makeRandomBridgeProcess(length))
                .isInstanceOf(IllegalArgumentException.class);
    }
}