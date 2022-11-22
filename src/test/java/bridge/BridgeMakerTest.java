package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("다리 생성 테스트 1")
    @Test
    void 다리_생성_테스트1() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(7);
        assertThat(bridge).containsExactly("U", "U", "D", "D", "U", "D", "U");
    }

    @DisplayName("다리 생성 테스트 2")
    @Test
    void 다리_생성_테스트2() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0, 0, 1, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(7);
        assertThat(bridge).containsExactly("D", "U", "D", "D", "U", "D", "U");
    }

    @DisplayName("다리 생성 테스트 3")
    @Test
    void 다리_생성_테스트3() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("D", "U", "D", "D", "U");
    }

    @DisplayName("다리 생성 테스트 4")
    @Test
    void 다리_생성_테스트4() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 0, 0, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("D", "D", "D", "D", "D");
    }

    @DisplayName("다리 생성 테스트 5")
    @Test
    void 다리_생성_테스트5() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U", "U", "U", "U", "U", "U");
    }

}