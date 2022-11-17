package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import bridge.exception.ErrorMessage;
import bridge.exception.FailException;
import bridge.exception.InvalidInputException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    static final String UP = "U";
    static final String DOWN = "D";
    static final String FILED_LOCATION = "location";

    Bridge bridge;
    List<String> mockBridge;
    int bridgeSize = 5;

    @BeforeEach
    void setUp() {
        mockBridge = mock(List.class);
        given(mockBridge.size()).willReturn(bridgeSize);
        bridge = new Bridge(mockBridge);
    }

    @DisplayName("유효하지 않은 길이의 리스트로 Bridge 생성 시 예외 발생")
    @ValueSource(ints = { Bridge.MINIMUM_LENGTH - 1, Bridge.MAXIMUM_LENGTH + 1 })
    @ParameterizedTest
    void testCreateFail(int bridgeSize) {
        given(mockBridge.size()).willReturn(bridgeSize);
        assertThatThrownBy(() -> new Bridge(mockBridge))
            .isInstanceOf(InvalidInputException.class)
            .hasMessageContaining(ErrorMessage.BRIDGE_LENGTH_IS_BETWEEN_3_AND_20);
    }

    @DisplayName("입력값에 따른 다리 건너기")
    @Test
    void testMove() {
        given(mockBridge.get(anyInt())).willReturn(UP);

        Direction direction = Direction.UP;
        bridge.move(direction);

        then(mockBridge).should(times(1)).get(0);
        assertThat(mockBridge.get(0)).isEqualTo(direction.getPosition());
    }

    @DisplayName("입력값에 따른 다리 건너기 실패")
    @Test
    void testMoveFail() {
        given(mockBridge.get(anyInt())).willReturn(DOWN);

        Direction direction = Direction.UP;

        assertThatThrownBy(() -> bridge.move(direction)).isInstanceOf(FailException.class);
        then(mockBridge).should(times(1)).get(0);
        assertThat(mockBridge.get(0)).isNotEqualTo(direction.getPosition());
    }

    @DisplayName("게임 재시작 시 위치 초기화")
    @Test
    void testRestart() {
        given(mockBridge.get(anyInt())).willReturn(UP);

        bridge.move(Direction.UP);
        bridge.move(Direction.UP);
        assertThat(bridge).extracting(FILED_LOCATION).isEqualTo(2);

        bridge.restart();

        assertThat(bridge).extracting(FILED_LOCATION).isEqualTo(0);
    }

    @DisplayName("다리 길이 만큼 틀리지 않으면 도착")
    @Test
    void testIsArrive() {
        given(mockBridge.get(anyInt())).willReturn(UP);
        Direction direction = Direction.UP;

        for (int i = 0; i < bridgeSize; i++) {
            bridge.move(direction);
        }

        assertThat(bridge.isArrive()).isTrue();
        assertThat(bridge).extracting(FILED_LOCATION).isEqualTo(bridgeSize);
        then(mockBridge).should(times(bridgeSize)).get(anyInt());
    }

    @DisplayName("다리 길이 보다 덜 맞으면 도착하지 않음")
    @Test
    void testIsArriveFail() {
        given(mockBridge.get(anyInt())).willReturn(UP);
        Direction direction = Direction.UP;

        for (int i = 0; i < bridgeSize - 1; i++) {
            bridge.move(direction);
        }

        assertThat(bridge.isArrive()).isFalse();
        assertThat(bridge).extracting(FILED_LOCATION).isEqualTo(bridgeSize - 1);
        then(mockBridge).should(times(bridgeSize - 1)).get(anyInt());
    }

}
