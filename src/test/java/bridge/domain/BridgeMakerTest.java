package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeMakerTest {

    @Test
    @DisplayName("다리 UP 생성확인")
    void makeBridge(){

        BridgeMaker bridgeMaker = new BridgeMaker(new TestGenerator());
        int size = 3;
        List<String> roads = bridgeMaker.makeBridge(size);

        Assertions.assertThat(roads).isEqualTo(List.of("U","U","U"));

    }

    @Test
    @DisplayName("다리 Down 생성 확인")
    void makeDownBridge(){

        BridgeMaker bridgeMaker = new BridgeMaker(new TestDownGenerator());
        int size = 3;
        List<String> roads = bridgeMaker.makeBridge(size);

        Assertions.assertThat(roads).isEqualTo(List.of("D","D","D"));

    }

    private class TestGenerator implements BridgeNumberGenerator {

        @Override
        public int generate() {
            return 0;
        }
    }
    private class TestDownGenerator implements BridgeNumberGenerator{

        @Override
        public int generate() {
            return 1;
        }
    }

}