package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constants.Direction;
import bridge.constants.MovingPossibility;
import bridge.domain.model.Bridge;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BridgeTest {

    List<String> testBridge = new ArrayList<>(List.of("U", "D", "D"));

    void initializeBridge() {
        Bridge.setBridge(testBridge);
    }

    @DisplayName("다리 초기화 - 다리는 U와 D로만 구성되어야 한다.")
    @Test
    @Order(1)
    void bridgeInitializeWithNoneUOrDTest() {
        // 예외 처리 구현 과정에서 개발 예정
    }

    @DisplayName("다리 초기화 - 다리의 길이는 3~20 사이여야 한다.")
    @Test
    @Order(2)
    void bridgeInitializeWithOutOfRangeLengthTest() {
        // 예외 처리 구현 과정에서 개발 예정
    }

    @DisplayName("건널 수 있는지 확인 기능 - 아직 초기화 되지 않은 다리에 대해 메소드를 호출할 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = 0)
    @Order(3)
    void canCrossNotInitializedExceptionTest(int space) {
        assertThatThrownBy(() -> {
            Bridge.checkMovingPossibility(space, Direction.UP);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("다리 초기화 - 다리는 한번만 초기화 될 수 있으며, 초기화 되었는지 여부를 반환한다.")
    @Test
    @Order(4)
    void bridgeInitializeOnceWithTrueReturnTest() {
        assertThat(Bridge.setBridge(testBridge)).isTrue();

        List<String> otherBridge = new ArrayList<>(List.of("U", "U", "U"));
        assertThat(Bridge.setBridge(otherBridge)).isFalse();
    }

    @DisplayName("건널 수 있는지 확인 기능 - 건널 수 있는 위치와 문자가 전달되면 CAN_MOVE 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = 0)
    @Order(6)
    void canMovePossibleTest(int space) {
        initializeBridge();

        assertThat(Bridge.checkMovingPossibility(space, Direction.UP)).isEqualTo(
                MovingPossibility.CAN_MOVE);
    }

    @DisplayName("건널 수 있는지 확인 기능 - 건널 수 없는 위치와 문자가 전달되면 CAN_NOT_MOVE 를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = 1)
    @Order(7)
    void canMoveImpossibleTest(int space) {
        initializeBridge();

        assertThat(Bridge.checkMovingPossibility(space, Direction.UP)).isEqualTo(
                MovingPossibility.CAN_NOT_MOVE);
    }

    @DisplayName("다리 길이 반환 기능 - 다리의 길이를 반환한다.")
    @Test
    void getBridgeSizeTest() {
        initializeBridge();
        int expectedSize = 3;

        assertThat(Bridge.getBridgeSize()).isEqualTo(expectedSize);
    }
}
