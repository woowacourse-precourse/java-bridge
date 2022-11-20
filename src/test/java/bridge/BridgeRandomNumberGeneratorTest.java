package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {

    @DisplayName("1 또는 0 둘중의 랜덤값을 리턴한다.")
    @RepeatedTest(20)
    void generate() {
        //given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();

        //when
        int generate = generator.generate();

        //then
        Assertions.assertThat(generate == 1 || generate == 0).isEqualTo(true);
    }
}