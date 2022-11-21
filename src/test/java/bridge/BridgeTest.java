package bridge;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeTest {
    Bridge bridge = new Bridge(3);
    @DisplayName("Bridge 생성 테스트")
    @Test
    public void generateTest(){
        bridge.inputBridgeSize(3);
        assertThat(bridge).isNotNull();
    }

    @DisplayName("Bridge 크기 예외 테스트")
    @Test
    public void sizeExceptionTest(){
        assertThrows(IllegalArgumentException.class,()->{
            bridge.inputBridgeSize(21);
        });
    }

}
