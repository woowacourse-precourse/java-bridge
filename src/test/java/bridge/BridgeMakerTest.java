package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class MakeBridgeTest {

    @Test
    void 다리_생성_테스트() {
        BridgeMaker maker = new BridgeMaker(new BridgeNumberGenerator() {
            List<Integer> number = List.of(1, 0, 1, 1, 0);
            int idx = 0;

            @Override
            public int generate() {
                return number.get(idx++);
            }
        });

        List<String> result = List.of("U", "D", "U", "U", "D");
        assertThat(maker.makeBridge(5)).containsExactlyElementsOf(result);
    }
}
