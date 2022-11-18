package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeRoadMapTest {
    @DisplayName("지정된 다리 크기 범위 안에 있지 않을 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void testNotValidBridgeSize(int size) {
        List<String> directions = List.of("U".repeat(size).split(""));
        assertThatThrownBy(() -> new BridgeRoadMap(directions)).hasMessage(
                GameErrorMessage.NO_RANGE_OF_BRIDGE_SIZE.getMessage()).isInstanceOf(IllegalStateException.class);
    }
}
