package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    @Test
    void 다리길이_검증(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = bridgeMaker.makeBridge(3);
            Bridge bridge = new Bridge(availableList);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    @Test
    void 다리길이_검증2(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = bridgeMaker.makeBridge(2);
            Bridge bridge = new Bridge(availableList);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    @Test
    void 다리길이_검증3(){
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> availableList = bridgeMaker.makeBridge(21);
            Bridge bridge = new Bridge(availableList);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

}