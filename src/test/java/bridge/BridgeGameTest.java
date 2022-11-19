package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private List<String> loggiingResult = new ArrayList<>();
    private StringBuilder upMovingLoggingResult = new StringBuilder("[");
    private StringBuilder downMovingLoggingResult = new StringBuilder("[");

    public boolean checkBridge(String userMoving, String targetBridge) {
        return userMoving.equals(targetBridge);
    }

    @DisplayName("유저가 건너고자하는 다리가 건널 수 있는지 검증한다.")
    @CsvSource({"U, U", "D, D"})
    @ParameterizedTest
    public void checkBridgeTrue(String userMoving, String targetBridge) {
        assertThat(checkBridge(userMoving, targetBridge)).isTrue();
    }

    @DisplayName("유저가 건너고자하는 다리가 건널 수 있는지 검증한다.")
    @CsvSource({"U, D", "D, U"})
    @ParameterizedTest
    public void checkBridgeFalse(String userMoving, String targetBridge) {
        assertThat(checkBridge(userMoving, targetBridge)).isFalse();
    }

    static Stream<Arguments> generateBridgeForUpMoving() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "D", "U")));
    }

    @DisplayName("위쪽으로 이동 했고, 그 다리가 건널 수 있을 때 결과값 검증")
    @MethodSource("generateBridgeForUpMoving")
    @ParameterizedTest
    public void upBridgeSuccessLogging(List<String> bridge) {
        String moving = "U";
        int index = 0;
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            upMovingLoggingResult.append(" O |");
            downMovingLoggingResult.append("   |");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[ O |");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[   |");
    }

    @DisplayName("위쪽으로 이동 했고, 그 위치가 다리의 끝자락 일때의 결과값 검증")
    @MethodSource("generateBridgeForUpMoving")
    @ParameterizedTest
    public void leftBridgeSuccessFinalLogging(List<String> bridge) {
        String moving = "U";
        int index = 2;
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
            upMovingLoggingResult.append(" O ]");
            downMovingLoggingResult.append("   ]");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[ O ]");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[   ]");
    }

    static Stream<Arguments> generateBridgeForDownMoving() {
        return Stream.of(
                Arguments.of(Arrays.asList("D", "U", "D")));
    }

    @DisplayName("아래쪽으로 이동 했고, 그 다리가 건널 수 있을 때 결과값 검증")
    @MethodSource("generateBridgeForDownMoving")
    @ParameterizedTest
    public void downBridgeSuccessLogging(List<String> bridge) {
        String moving = "D";
        int index = 0;
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
            upMovingLoggingResult.append("   |");
            downMovingLoggingResult.append(" O |");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[   |");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[ O |");
    }

    @DisplayName("아래쪽으로 이동 했고, 그 위치가 다리의 끝자락 일때의 결과값 검증")
    @MethodSource("generateBridgeForDownMoving")
    @ParameterizedTest
    public void downBridgeSuccessFinalLogging(List<String> bridge) {
        String moving = "D";
        int index = 2;
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" O ]");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[   ]");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[ O ]");
    }

    @DisplayName("위쪽으로 이동 했고, 그 위치가 건널 수 없을 다리일 때의 결과값 검증")
    @MethodSource("generateBridgeForDownMoving")
    @ParameterizedTest
    public void upBridgeFailLogging(List<String> bridge) {
        String moving = "U";
        int index = 0;
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
            upMovingLoggingResult.append(" X ]");
            downMovingLoggingResult.append("   ]");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[ X ]");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[   ]");
    }
}