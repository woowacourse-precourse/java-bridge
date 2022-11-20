package bridge.utilTest;
import bridge.util.BridgeViewConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeViewConstructorTest {

    BridgeViewConstructor bridgeViewConstructor;

    @BeforeEach
    void initializeClass(){
        bridgeViewConstructor = new BridgeViewConstructor();
    }

    @DisplayName("입력한 리스트 둘을 비교해 결과를 출력해준다. ")
    @Test
    void constructBridgeTest(){
        assertThat(bridgeViewConstructor
                .constructBridge(List.of("U", "D", "U"), List.of("U", "D", "U")))
                .isEqualTo("[ O |   | O ]\n[   | O |   ]");
    }
}
