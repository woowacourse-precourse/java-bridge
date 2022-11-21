package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeTest {

    List<String> testBridge = new ArrayList<>(List.of("U", "D", "D"));

    void initializeBridge() {
        Bridge.setBridge(testBridge);
    }

    @BeforeEach
    void resetBridgeFields() throws NoSuchFieldException, IllegalAccessException {
        resetBridge();
        resetBridgeCreated();
    }

    void resetBridge() throws NoSuchFieldException, IllegalAccessException {
        Bridge bridgeInstance = new Bridge();
        Field bridge = Bridge.class.getDeclaredField("bridge");

        bridge.setAccessible(true);
        bridge.set(bridgeInstance, new ArrayList<>());
        bridge.setAccessible(false);
    }

    void resetBridgeCreated() throws NoSuchFieldException, IllegalAccessException {
        Bridge bridgeInstance = new Bridge();
        Field bridgeCreated = Bridge.class.getDeclaredField("bridgeCreated");

        bridgeCreated.setAccessible(true);
        bridgeCreated.set(bridgeInstance, false);
        bridgeCreated.setAccessible(false);
    }

    @DisplayName("다리 초기화 - U와 D로만 구성되어 있지 않은 경우, 예외가 발생한다.")
    @Test
    void bridgeInitializeWithNoneUOrDTest() {
        List<String> notOnlyUOrD = new ArrayList<>(List.of("A", "D", "U"));

        assertThatThrownBy(() -> {
            Bridge.setBridge(notOnlyUOrD);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리 초기화 - 다리는 한번만 초기화 될 수 있으며, 초기화 되었는지 여부를 반환한다.")
    @Test
    void bridgeInitializeOnceWithTrueReturnTest() {
        assertThat(Bridge.setBridge(testBridge)).isTrue();

        List<String> otherBridge = new ArrayList<>(List.of("U", "U", "U"));
        assertThat(Bridge.setBridge(otherBridge)).isFalse();
    }

    @DisplayName("건널 수 있는지 확인 기능 - 건널 수 있는 위치와 문자가 전달되면 CAN_MOVE 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = 0)
    void canMovePossibleTest(int space) {
        initializeBridge();

        assertThat(Bridge.checkMovingPossibility(space, Direction.UP)).isEqualTo(
                MovingPossibility.CAN_MOVE);
    }

    @DisplayName("건널 수 있는지 확인 기능 - 건널 수 없는 위치와 문자가 전달되면 CAN_NOT_MOVE 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = 1)
    void canMoveImpossibleTest(int space) {
        initializeBridge();

        assertThat(Bridge.checkMovingPossibility(space, Direction.UP)).isEqualTo(
                MovingPossibility.CAN_NOT_MOVE);
    }

    @DisplayName("건널 수 있는지 확인 기능 - 아직 초기화 되지 않은 다리에 대해 메소드를 호출할 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = 0)
    void checkMovingPossibilityNotInitializedExceptionTest(int space) {
        checkMovingPossibilityExceptionTest(space);
    }

    @DisplayName("건널 수 있는지 확인 기능 - 마지막 인덱스보다 큰 값이나 0보다 작은 값이 전달될 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void checkMovingPossibilityOutOfRangeExceptionTest(int space) {
        checkMovingPossibilityExceptionTest(space);
    }

    void checkMovingPossibilityExceptionTest(int space) {
        assertThatThrownBy(() -> {
            Bridge.checkMovingPossibility(space, Direction.UP);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리 길이 반환 기능 - 아직 초기화 되지 않은 다리에 대해 메소드를 호출할 경우, 예외가 발생한다.")
    @Test
    void getBridgeSizeNotInitializedExceptionTest() {
        assertThatThrownBy(() -> {
            Bridge.getBridgeSize();
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리 길이 반환 기능 - 다리의 길이를 반환한다.")
    @Test
    void getBridgeSizeTest() {
        initializeBridge();
        int expectedSize = 3;

        assertThat(Bridge.getBridgeSize()).isEqualTo(expectedSize);
    }
}
