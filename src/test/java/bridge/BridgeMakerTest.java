package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeMaker 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeMakerTest {
    private BridgeNumberGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new BridgeNumberGenerator() {
            private final List<Integer> expected = List.of(1, 0, 1, 0, 0, 1, 1, 0, 0, 1);
            private int position = 0;

            @Override
            public int generate() {
                return expected.get(position++);
            }
        };
    }

    @Test
    void makeBridge_메서드는_주어진_숫자에_따라_다리를_만들어낸다() {
        final List<String> result = new BridgeMaker(generator).makeBridge(10);
        assertThat(result).isEqualTo(List.of("U", "D", "U", "D", "D", "U", "U", "D", "D", "U"))
                .hasSize(10);
    }
}
