package bridge.bridgeRouter.bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.bridgeRouter.BridgeRouter;
import bridge.bridgeRouter.exception.NotFoundBridgeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeRouterTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 0})
    void getMatchBridgeRunTest(int value) {
        int expect = BridgeRouter.getMatchBridge(value).getValue();
        int result = value;
        assertThat(expect).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 10, -1, Integer.MAX_VALUE})
    void getMatchBridgeErrorTest(int value) {
        assertThatThrownBy(() -> BridgeRouter.getMatchBridge(value)).isInstanceOf(NotFoundBridgeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void getMatchBridgeDirectionRunTest(String direction) {
        String expect = BridgeRouter.getMatchBridge(direction).getDirection();
        String result = direction;
        assertThat(expect).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "R", "u", "d", "a"})
    void getMatchBridgeDirectionErrorTest(String direction) {
        assertThatThrownBy(() -> BridgeRouter.getMatchBridge(direction)).isInstanceOf(NotFoundBridgeException.class);
    }


}