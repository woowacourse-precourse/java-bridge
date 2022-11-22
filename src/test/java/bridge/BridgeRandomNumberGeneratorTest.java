package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {
    /**
     * 항상 0~1 사이의 값을 리턴하는지 확인
     */
    @Test
    void generate() {
        for (int i=0; i<100; i++) {
            BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
            assertThat(generator.generate()).isIn(List.of(0, 1));
        }
    }
}