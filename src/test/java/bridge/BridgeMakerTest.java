package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("임의의 숫자 길이 만큼의 다리 생성 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "4,4", "5,5", "6,6", "7,7"})
    void makeBridge_success(int size, int expectedSize) {
        // given
        // when
        List<String> symbolBlocks = bridgeMaker.makeBridge(size);
        // then
        assertThat(symbolBlocks.size()).isEqualTo(expectedSize);
    }
}