package bridge.model;

import static bridge.constant.Config.RANGE_OF_BRIDGE_SIZE_START;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeRoadMapTest {
    private BridgeRoadMap bridgeRoadMap;

    @BeforeEach
    void setBridgeRoadMap(){
        bridgeRoadMap = new BridgeRoadMap(List.of("U".repeat(RANGE_OF_BRIDGE_SIZE_START).split("")));
    }

    @DisplayName("지정된 다리 크기 범위 안에 있지 않을 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void testNotValidBridgeSize(int size) {
        List<String> directions = List.of("U".repeat(size).split(""));
        assertThatThrownBy(() -> new BridgeRoadMap(directions)).hasMessage(
                GameErrorMessage.NO_RANGE_OF_BRIDGE_SIZE.getMessage()).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("사용자의 마지막 이동이 성공했을 때 true 값을 반환한다.")
    @Test
    void testSuccessMoving(){
        UserRoadMap userRoadMap = new UserRoadMap(List.of("U"));
        assertThat(bridgeRoadMap.isFail(userRoadMap))
                .isFalse();
    }

    @DisplayName("사용자의 마지막 이동이 실패했을 때 false 값을 반환한다.")
    @Test
    void testFailMoving(){
        UserRoadMap userRoadMap = new UserRoadMap(List.of("D"));
        assertThat(bridgeRoadMap.isFail(userRoadMap))
                .isTrue();
    }

    @DisplayName("사용자가 다리 끝에 도달했다면 true 값을 반환")
    @Test
    void testEnd(){
        UserRoadMap userRoadMap = new UserRoadMap(List.of("U".repeat(RANGE_OF_BRIDGE_SIZE_START).split("")));
        assertThat(bridgeRoadMap.isEnd(userRoadMap))
                .isTrue();
    }

    @DisplayName("사용자가 다리 끝에 도달하지 않았다면 false 값을 반환")
    @Test
    void testNotEnd(){
        UserRoadMap userRoadMap = new UserRoadMap(List.of());
        assertThat(bridgeRoadMap.isEnd(userRoadMap))
                .isFalse();
    }
}
