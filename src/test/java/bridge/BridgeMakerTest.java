package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMakerTest {
    BridgeMaker make = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("랜덤으로 값을 생성하고 주어진 크기만큼 bridge 리스트 값을 생성한다")
    @Test
    void createBridgeList() {
        assertThat(make.makeBridge(5).size()).isEqualTo(5);
    }
}
