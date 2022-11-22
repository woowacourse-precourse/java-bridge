package bridge.domain.factory;

import bridge.domain.bridge.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeFactoryTest {

    private BridgeFactory bridgeFactory;

    @BeforeEach
    void setUp() {
        bridgeFactory = new BridgeFactory();
    }

    @DisplayName("createBridge 메소드에 숫자를 입력하였을 때 Bridge 객체를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 19, 20})
    void createBridge_test(int size) {
        Bridge bridge = bridgeFactory.createBridge(size);

        assertThat(bridge).isInstanceOf(Bridge.class);
    }
}