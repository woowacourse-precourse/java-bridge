package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeRandomNumberGeneratorTest {

    private final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

    @DisplayName("랜덤 숫자가 1 또는 0만 추출되는지 확인")
    @RepeatedTest(20)
    void checkNumberGenerateOneOrZero() {
        assertThat(generator.generate()).isIn(0, 1);
    }
}
