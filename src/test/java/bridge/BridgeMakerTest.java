package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("매개 변수의 값 만큼 birdgeNumber을 만드는 메서드")
    @Test
    void makeBridgeNumber() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        assertThat(bridgeMaker.makeBridgeNumber(3)).containsExactly(1, 0, 0);
    }

    @DisplayName("1이면 U 아니면 D를 반환하는 메서드")
    @Test
    void makeBridgeWord() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertEquals("U", bridgeMaker.makeBridgeWord(1));
    }

}