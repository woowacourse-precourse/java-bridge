package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeMakerTest {

    @Test
    void 사이즈_확인_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 20;

        List<String> test = bridgeMaker.makeBridge(size);

        assertThat(test.size()).isEqualTo(20);

    }

    @Test
    void 요소값_테스트() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 20;
        List<String> compareValue = List.of("U","D");

        List<String> test = bridgeMaker.makeBridge(size);

        for(String value : test){
            assertThat(value).isIn(compareValue);
        }
    }
}