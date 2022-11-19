package bridge;

import bridge.gameComponent.Bridge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;

public class BrideMakerTest {
    @Test
    void 다리_생성_0_또는_1_이외의_값이_생성될_경우_테스트() {
        //given
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(2, 3, 3));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        int bridgeSize = 3;
        //when
        Throwable throwable = catchThrowable(() -> {
            Bridge bridge = bridgeMaker.generateBridge(bridgeSize);
        });
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 다리_생성_테스트() {
        //given
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        int bridgeSize = 3;
        //when
        Bridge bridge = bridgeMaker.generateBridge(bridgeSize);
        //then
        assertThat(bridge.getBridge()).containsExactly("U", "D", "D");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
