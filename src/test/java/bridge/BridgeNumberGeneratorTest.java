package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeNumberGeneratorTest {
    @DisplayName("generate 메소드를 호출하였을 때 0 혹은 1을 반환하는지 확인")
    @RepeatedTest(value = 10, name = "0 혹은 1 반환, {currentRepetition}/{totalRepetitions}")
    void generate_test() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> expectedValues = List.of(0, 1);

        int actual = bridgeNumberGenerator.generate();

        assertThat(expectedValues.contains(actual)).isTrue();
    }
}