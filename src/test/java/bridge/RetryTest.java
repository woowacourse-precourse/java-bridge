package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.models.BridgeResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RetryTest {
    @Test
    void 한번호출() {
        BridgeResult result = new BridgeResult();
        result.init();
        assertThat(result.getCount()).isEqualTo(1);
    }

    @ValueSource(ints = {1, 5, 100})
    @ParameterizedTest
    void 여러번호출(int number) {
        BridgeResult result = new BridgeResult();
        for (int i = 0; i < number; i++) {
            result.init();
        }
        assertThat(result.getCount()).isEqualTo(number);
    }
}
