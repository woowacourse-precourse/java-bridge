import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = createBridgeMaker();
    private final int size = 30;

    @DisplayName("makeBridge 호출")
    @Test
    void makeBridge() {
        // given

        // when
        List<String> collect = bridgeMaker.makeBridge(size).stream()
                .distinct()
                .collect(Collectors.toList());

        // then
        Assertions.assertThat(collect.size()).isEqualTo(size);
    }


    BridgeMaker createBridgeMaker() {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(generator);
    }
}
