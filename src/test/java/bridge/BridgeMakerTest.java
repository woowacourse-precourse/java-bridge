package bridge;

import bridge.Enum.PlayerInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BridgeMakerTest {
    @ParameterizedTest(name="입력한 사이즈와 같은 크기의 U와 D만 포함하는 BRIDGE가 생성되는지 확인")
    @ValueSource(ints={3, 5, 11, 20})
    void bridgeMakerTest(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        assertEquals(bridge.size(), size);
        for (String s : bridge) {
            assertTrue(
                    s.equals(PlayerInput.UP.getValue()) ||
                            s.equals(PlayerInput.DOWN.getValue()));
        }
    }
}