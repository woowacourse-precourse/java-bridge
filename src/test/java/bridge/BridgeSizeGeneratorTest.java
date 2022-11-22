package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeGeneratorTest {

    BridgeSizeGenerator bridgeSizeGenerator = new BridgeSizeGenerator();

    @BeforeEach
    public void init() {
        bridgeSizeGenerator = new BridgeSizeGenerator();
    }

    @DisplayName("3-20사이 수를 입력하면 생성된다")
    @Test
    public void createSizeInRange() {
        for (int input = 3; input <= 20; input++) {
            assertThat(bridgeSizeGenerator.generate(input))
                    .isEqualTo(input);
        }
    }

    @DisplayName("3-20사이 밖의 수를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {34, 99, 2809})
    public void createSizeOutRange(int input) {
        assertThatThrownBy(() -> bridgeSizeGenerator.generate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}