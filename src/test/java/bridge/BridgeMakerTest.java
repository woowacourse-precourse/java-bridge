package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력 받은 크기의 다리를 생성하는지 체크")
    @ParameterizedTest
    @ValueSource( ints = {3, 5, 15, 20, 1})
    void makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertEquals(bridge.size(), size);
    }
}