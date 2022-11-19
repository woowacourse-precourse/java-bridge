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
    private StringBuilder upLoggingResult = new StringBuilder("[");
    private StringBuilder downLoggingResult = new StringBuilder("[");

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

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList("U", "D", "U")));
    }

    @DisplayName("위쪽으로 이동 했고, 그 다리가 건널 수 있을 때 결과값 검증")
    @MethodSource("generateData")
    @ParameterizedTest
    public void upBridgeSuccessLogging(List<String> bridge) {
        String moving = "U";
        int index = 0;
        System.out.println("bridge = " + bridge);
        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index < bridge.size() - 1) {
            upLoggingResult.append(" O |");
            downLoggingResult.append("   |");
        }
        assertThat(upLoggingResult.toString()).isEqualTo("[ O |");
        assertThat(downLoggingResult.toString()).isEqualTo("[   |");
    }
//
//    @Test
//    public void leftBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
//        if (checkBridge(moving, bridge.get(index)) && moving.equals("U") && index == bridge.size() - 1) {
//            leftLoggingResult.append(" O ]");
//            rightLoggingResult.append("   ]");
//        }
//    }
//
//    @Test
//    public void rightBridgeSuccessLogging(String moving, List<String> bridge, int index) {
//        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index < bridge.size() - 1) {
//            leftLoggingResult.append("   |");
//            rightLoggingResult.append(" O |");
//        }
//    }
//
//    @Test
//    public void rightBridgeSuccessFinalLogging(String moving, List<String> bridge, int index) {
//        if (checkBridge(moving, bridge.get(index)) && moving.equals("D") && index == bridge.size() - 1) {
//            leftLoggingResult.append("   ]");
//            rightLoggingResult.append(" O ]");
//        }
//    }
//
//    @Test
//    public void leftBridgeFailLogging(String moving, List<String> bridge, int index) {
//        if (!checkBridge(moving, bridge.get(index)) && moving.equals("U")) {
//            leftLoggingResult.append(" X ]");
//            rightLoggingResult.append("   ]");
//        }
//    }
//
//    @Test
//    public void rightBridgeFailLogging(String moving, List<String> bridge, int index) {
//        if (!checkBridge(moving, bridge.get(index)) && moving.equals("D")) {
//            leftLoggingResult.append("   ]");
//            rightLoggingResult.append(" X ]");
//        }
//    }
//
//    @Test
//    List<String> move(String moving, int index) {
//        return loggingGameResult(moving, index);
//    }
}