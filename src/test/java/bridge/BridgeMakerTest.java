package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @Test
    @DisplayName("사이즈에 입력 시 U와 D로만 구성된 다리 생성")
    void makeBridgeTest() {
        BridgeMaker bridgeMaker = new BridgeMaker(new ApplicationTest.TestNumberGenerator(newArrayList(1,0,1,0,1,0)));
        List<String> bridge = bridgeMaker.makeBridge(6);
        assertThat(bridge).containsExactly("U","D","U","D","U","D");
    }
}