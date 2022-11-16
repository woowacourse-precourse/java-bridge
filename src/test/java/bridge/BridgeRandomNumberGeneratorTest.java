package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeRandomNumberGenerator 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeRandomNumberGeneratorTest {

    @Test
    void generate_메서드는_0과_1사이의_무작위_값을_생성하여_반환한다() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        int number = bridgeNumberGenerator.generate();

        assertThat(number).isBetween(0, 1);
    }
}
