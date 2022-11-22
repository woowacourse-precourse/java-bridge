package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    int size = 10;

    @DisplayName("지정한 size 개수 만큼 문자열 U 혹은 D 를 원소로 가지는 리스트를 반환한다.")
    @Test
    void makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
        assertThat(bridge).containsAnyOf("U", "D");
    }
}
