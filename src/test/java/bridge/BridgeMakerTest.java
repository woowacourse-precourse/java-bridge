package bridge;

import bridge.generator.BridgeMaker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeMakerTest {
    BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(generator);

    @Test
    @DisplayName("0과 1중 무작위 값을 생성해준다")
    void randomNumberTest() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int number = generator.generate();
            numbers.add(number);
        }

        for (Integer number : numbers) {
            Assertions.assertThat(number).isBetween(0,1);
        }
    }

    @Test
    void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        int size = 3;



    }

    @Test
    @DisplayName("0이면 D를 반환, 1이면 U을 반환")
    void makeUpDown() {
        String up = bridgeMaker.makeUpDown(1);
        String down = bridgeMaker.makeUpDown(0);

        Assertions.assertThat(up).isEqualTo("U");
        Assertions.assertThat(down).isEqualTo("D");
    }

    @Test
    @DisplayName("asd")
    void makeBridge() {
        List<Integer> numbers = List.of(0,1,0,1);
    }
}
