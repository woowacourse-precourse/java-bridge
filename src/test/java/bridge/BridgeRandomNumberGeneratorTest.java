package bridge;

import bridge.domain.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeRandomNumberGeneratorTest {
    private static BridgeRandomNumberGenerator randomNumberGenerator;

    @BeforeAll
    static void setRandomNumberGenerator() {
        randomNumberGenerator = new BridgeRandomNumberGenerator();
    }

    @DisplayName("기능 테스트")
    @Test
    void generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(randomNumberGenerator.generate());
        }
        assertThatCode(() -> validate(numbers)).doesNotThrowAnyException();
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number != 0 && number != 1) {
                throw new RuntimeException();
            }
        }
    }
}