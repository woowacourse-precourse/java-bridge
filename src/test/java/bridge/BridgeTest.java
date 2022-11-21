package bridge;

import bridge.controller.BridgeController;
import bridge.dto.BridgeDto;
import bridge.service.BridgeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeTest {
    private final BridgeController bridgeController = new BridgeController();
    private final BridgeService bridgeService = new BridgeService();

    @DisplayName("다리 사이즈가 올바른 형식이 아닌 경우")
    @ValueSource(strings = {"a", "가", "1", "-1", "21"})
    @ParameterizedTest
    void notNumericBridgeSize(String input) {
        final String ERROR_MESSAGE = "[ERROR]";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        byte[] bridgeSize = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(bridgeSize));

        try {
            bridgeController.generateBridge();
        } catch (NoSuchElementException ignore) {
        }

        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }

    @DisplayName("플레이어가 이동할 칸이 건널 수 있는 칸인지 확인")
    @Test
    void isBridgeBlockPassable() {
        bridgeService.initBridge(BridgeDto.from(List.of("U", "D")));
        assertThat(bridgeService.isPassable(0, "U")).isTrue();
        assertThat(bridgeService.isPassable(1, "U")).isFalse();
    }
}
