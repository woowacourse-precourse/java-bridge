package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    void 안전경로_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 안전경로_생성_중_랜덤_오류_테스트() {
        assertThatThrownBy(() -> {
            BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 2));
            BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
            bridgeMaker.makeBridge(3);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 안전경로_생성_중_다리_길이가_가능범위보다_작아서_예외처리된다() {
        assertThatThrownBy(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 안전경로_생성_중_다리_길이가_가능범위보다_커서_예외처리된다() {
        assertThatThrownBy(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(21);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}