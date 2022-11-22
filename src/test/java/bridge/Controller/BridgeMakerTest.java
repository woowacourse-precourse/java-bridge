package bridge.Controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("다리가 잘 생성되는지에 대한 검사")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        System.out.println(bridge);
    }
    @DisplayName("입력한 다리 길이 만큼 생성되는지에 대한 검사")
    @Test
    void sizeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(10);
        assertThat(bridge.size()).isEqualTo(10);
    }

    @DisplayName("정답 다리 안에 U, D 만 생성되었는지에 대한 검사")
    @Test
    void sourceTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(20);
        List<String> verifyAnswer = new ArrayList<>(List.of("U", "D"));
        for (String answer : bridge) {
            assertThat(verifyAnswer).contains(answer);
        }
    }
}