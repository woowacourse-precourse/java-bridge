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

    private List<String> loggingResult = new ArrayList<>();
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
    public void upBridgeSuccessFinalLogging(List<String> bridge) {
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

    @DisplayName("아래쪽으로 이동 했고, 그 위치가 건널 수 없을 다리일 때의 결과값 검증")
    @MethodSource("generateBridgeForUpMoving")
    @ParameterizedTest
    public void downBridgeFailLogging(List<String> bridge) {
        String moving = "D";
        int index = 0;
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" X ]");
        }
        assertThat(upMovingLoggingResult.toString()).isEqualTo("[   ]");
        assertThat(downMovingLoggingResult.toString()).isEqualTo("[ X ]");
    }


    // --------------------------------------------------- //

    public void upBridgeSuccessLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            upMovingLoggingResult.append(" O |");
            downMovingLoggingResult.append("   |");
        }
    }

    public void upBridgeSuccessFinalLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
            upMovingLoggingResult.append(" O ]");
            downMovingLoggingResult.append("   ]");
        }
    }

    public void downBridgeSuccessLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
            upMovingLoggingResult.append("   |");
            downMovingLoggingResult.append(" O |");
        }
    }

    public void downBridgeSuccessFinalLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" O ]");
        }
    }

    public void upBridgeFailLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
            upMovingLoggingResult.append(" X ]");
            downMovingLoggingResult.append("   ]");
        }
    }

    public void downBridgeFailLoggingForFinalTest(List<String> bridge, String moving, int index) {
        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
            upMovingLoggingResult.append("   ]");
            downMovingLoggingResult.append(" X ]");
        }
    }

    public List<String> loggingGameResult(List<String> bridge, String moving, int index) {
        upBridgeSuccessFinalLoggingForFinalTest(bridge, moving, index);
        downBridgeSuccessFinalLoggingForFinalTest(bridge, moving, index);
        upBridgeSuccessLoggingForFinalTest(bridge, moving, index);
        downBridgeSuccessLoggingForFinalTest(bridge, moving, index);
        upBridgeFailLoggingForFinalTest(bridge, moving, index);
        downBridgeFailLoggingForFinalTest(bridge, moving, index);
        List<String> result = new ArrayList<>();
        result.add(upMovingLoggingResult.toString());
        result.add(downMovingLoggingResult.toString());
        return result;
    }

    static Stream<Arguments> generateBridgeAndUserMovingForFinalTest() {
        return Stream.of(
                Arguments.of(Arrays.asList("D", "D", "D", "U", "U"), Arrays.asList("D", "D", "D", "U", "U"))
        );
    }

    @DisplayName("실제 유저의 이동 테스트")
    @MethodSource(value = {"generateBridgeAndUserMovingForFinalTest"})
    @ParameterizedTest
    public void move(List<String> bridge, List<String> moving) {
        for (int index = 0; index < bridge.size(); index++) {
            loggingResult = loggingGameResult(bridge, moving.get(index), index);
        }
        String upMovingLog = loggingResult.get(0);
        String downMovingLog = loggingResult.get(1);
        assertThat(upMovingLog).isEqualTo("[   |   |   | O | O ]");
        assertThat(downMovingLog).isEqualTo("[ O | O | O |   |   ]");

    }
}