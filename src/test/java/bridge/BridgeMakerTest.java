package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("입력한 수만큼 다리의 길이가 생성되는지 확인한다.")
    @CsvSource({"2", "3", "10", "20"})
    @ParameterizedTest
    void makeBridge(Integer input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> list = bridgeMaker.makeBridge(input);
        assertThat(list.size()).isEqualTo(input);
        assertThat(list).containsAnyOf("U", "D");
    }

}