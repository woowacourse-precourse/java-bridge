package bridge;

import bridge.ApplicationTest.TestNumberGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @Test
    public void 다리_생성자를_통한_다리_크기_테스트() {
        List<Integer> numbers = Lists.newArrayList(1, 0, 0, 1);
        int bridgeSize = numbers.size();
        BridgeNumberGenerator randomNumberGenerator = new TestNumberGenerator(numbers);
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        Assertions.assertThat(bridge)
                .containsExactly("U", "D", "D", "U");
    }

}