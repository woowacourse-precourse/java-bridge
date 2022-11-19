package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("다리의 길이가 3 ~ 20이 아니라면 예외")
    @ParameterizedTest(name = "{0}이면 예외")
    @CsvSource({"1", "0", "-1", "59", "1000000"})
    void outOfRange(int size) {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeMaker.makeBridge(size);
        });
    }
    
}