package bridge;

import bridge.utils.constants.Commons;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @Test
    void 랜덤_번호_생성기_통과() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(bridgeRandomNumberGenerator.generate());
        }
        Assertions.assertThat(numbers.stream()
                        .allMatch((num) -> num == Commons.INDEX_ZERO.getNumber() || num == Commons.INDEX_ONE.getNumber()))
                .isTrue();
    }

}