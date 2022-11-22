package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeMakerTest {
    @ParameterizedTest(name="입력한 사이즈와 같은 크기의 U와 D만 포함한 List가 생성되는지 확인")
    @ValueSource(ints={3, 4, 9, 20})
    void bridgeMakerTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertEquals(bridge.size(), size);
        for (String s : bridge) {
            assertTrue(
                    s.equals(Game.BRIDGE_GENERATE_UP) ||
                            s.equals(Game.BRIDGE_GENERATE_DOWN));
        }
    }
}