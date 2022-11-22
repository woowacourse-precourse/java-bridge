package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameServiceTest {
    private static final BridgeGameService bridgeGameService = new BridgeGameService();

    @Test
    @DisplayName("다리 생성 테스트")
    void makeBridge() {
        List<String> bridge = bridgeGameService.makeBridge(7);
        assertThat(bridge.size()).isEqualTo(7);
    }

    @Test
    @DisplayName("이동 가능 여부 테스트")
    void isMovable() {
        // 성공했거나 이동이 불가능한 경우 false, 그 외 true
        assertThat(bridgeGameService.isMovable(List.of("U", "U", "D", "D"), List.of("U", "U"))).isTrue();
        assertThat(bridgeGameService.isMovable(List.of("U", "U", "D", "D"), List.of("U", "U", "U"))).isFalse();
        assertThat(bridgeGameService.isMovable(List.of("U", "U", "D", "D"), List.of("U", "U", "D", "D"))).isFalse();
    }

    @Test
    @DisplayName("이동 결과 출력 형식 테스트")
    void printMapStatus() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        bridgeGameService.printMapStatus(List.of("U", "U", "D", "D"), List.of("U"));
        bridgeGameService.printMapStatus(List.of("U", "U", "D", "D"), List.of("U", "D"));
        bridgeGameService.printMapStatus(List.of("U", "U", "D", "D"), List.of("U", "U", "U"));
        bridgeGameService.printMapStatus(List.of("U", "U", "D", "D"), List.of("U", "U", "D"));
        bridgeGameService.printMapStatus(List.of("U", "U", "D", "U"), List.of("U", "U", "D", "U"));
        assertThat(outputStream.toString()).contains(
                "[ O ]",
                "[   ]",
                "[ O |   ]",
                "[   | X ]",
                "[ O | O | X ]",
                "[   |   |   ]",
                "[ O | O |   ]",
                "[   |   | O ]",
                "[ O | O |   | O ]",
                "[   |   | O |   ]"
        );
    }

    @Test
    @DisplayName("다시 시도 여부 테스트")
    void isRetry() {
        assertThat(bridgeGameService.isRetry("R")).isTrue();
        assertThat(bridgeGameService.isRetry("Q")).isFalse();
    }

    @Test
    @DisplayName("성공 여부 테스트")
    void isSuccess() {
        assertThat(bridgeGameService.isSuccess(List.of("U", "U", "D", "D"), List.of("U", "U"))).isFalse();
        assertThat(bridgeGameService.isSuccess(List.of("U", "U", "D", "D"), List.of("U", "U", "U"))).isFalse();
        assertThat(bridgeGameService.isSuccess(List.of("U", "U", "D", "D"), List.of("U", "U", "D", "D"))).isTrue();
    }

    @Test
    @DisplayName("게임 결과 출력문 테스트")
    void printResult() {
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        bridgeGameService.printResult(List.of("U", "U", "D"), List.of("U", "U", "D"), 3);
        bridgeGameService.printResult(List.of("U", "U", "D", "U"), List.of("U", "U", "U"), 4);
        assertThat(outputStream.toString()).contains(
                "게임 성공 여부: 성공", "총 시도한 횟수: 3",
                "게임 성공 여부: 실패", "총 시도한 횟수: 4"
        );
    }
}