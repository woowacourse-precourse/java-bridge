package bridge.generatorTest;

import bridge.BridgeRandomNumberGenerator;
import bridge.generator.BridgeMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMakerTest {
    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(generator);

    @Test
    @DisplayName("0과 1중 랜덤값으로 구성된 리스트 생성")
    void randomNumberTest() {
        int size = 5;

        List<Integer> numbers = bridgeMaker.generateNumbers(size);

        for (Integer number : numbers) {
            Assertions.assertThat(number).isBetween(0,1);
        }
    }

    @Test
    @DisplayName("0과 1로 구성된 리스트를 U,D으로 변경")
    void convertNumberToUpAndDown() {
        List<Integer> numbers = List.of(0,1,0,1,1,0);
        List<String> result = bridgeMaker.convertNumbersToUpAndDown(numbers);

        Assertions.assertThat(result).containsExactly("D","U","D","U","U","D");
    }
}
