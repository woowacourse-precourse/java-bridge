package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    private BridgeNumberGenerator bridgeNumberGenerator;

    @BeforeEach
    void setUp() {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @Test
    @DisplayName("랜덤 번호는 0 또는 1 이어야 합니다")
    void generate() {
        List<Integer> bridgeNumbers = List.of(0, 1);
        int randomNumber = bridgeNumberGenerator.generate();

        assertThat(bridgeNumbers)
                .contains(randomNumber);
    }
}