package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("0과 1 중 랜덤한 숫자를 생성한다.")
    @Test
    void should_ReturnZeroOrOne_When_Generate() {
        // given
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        // when
        int randomNumber = bridgeRandomNumberGenerator.generate();
        // then
        assertThat(randomNumber).isIn(List.of(0, 1));
    }
}