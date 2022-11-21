package bridge;

import bridge.model.BridgeMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("makeBridge 함수는 정수를 인자로받아 해당 정수 길이만큼의 List를 반환한다.")
    @ParameterizedTest(name = "입력값: {0}")
    @CsvSource({"3", "5", "20"})
    void testMakeBridgeMethod(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(bridge.size(), size);
    }
}
