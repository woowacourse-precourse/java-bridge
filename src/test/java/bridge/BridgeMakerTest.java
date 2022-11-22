package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @DisplayName("랜덤으로 다리 생성")
    @Test
    void makeBridge() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 3;
        //when
        List<String> randomBridge = bridgeMaker.makeBridge(size);
        //then
        assertThat(randomBridge.contains("U") || randomBridge.contains("D")).isTrue();
    }
    @DisplayName("숫자에 따른 UD생성")
    @Test
    void makeUD() {
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int number = 1;
        //when
        String isUD = bridgeMaker.makeUD(number);
        //then
        assertThat(isUD).isSameAs("U");
    }
}
