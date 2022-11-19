package bridge;

import bridge.controller.PlayerController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTest {
    private final PlayerController playerController = new PlayerController();

    @DisplayName("이동할 칸이 올바른 형식이 아닌 경우")
    @ValueSource(strings = {"a", "u", "1", "ab"})
    @ParameterizedTest
    void notNumericBridgeSize(String input) {
        final String ERROR_MESSAGE = "[ERROR]";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        byte[] bridgeSize = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(bridgeSize));
        try {
            playerController.getMovingDirection();
        } catch (NoSuchElementException ignore) {}
        assertThat(out.toString()).contains(ERROR_MESSAGE);
    }
}
