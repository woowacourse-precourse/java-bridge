package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("입력된 사이즈에 맞는 다리 생성")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 20, 20, 20})
    void makeBridge(int a) {
        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> b = bridgeMaker.makeBridge(a);
        System.out.println(b.toString());
        assertEquals(a, b.size());
    }
}