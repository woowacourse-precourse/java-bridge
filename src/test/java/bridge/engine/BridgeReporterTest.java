package bridge.engine;

import bridge.engine.reporter.BridgeReporter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeReporterTest {

    @DisplayName("사용자가 입력한 경로와 맞게 화면에 출력이 되야한다.")
    @Test
    public void renderUserDirection() {
        BridgeReporter reporter = new BridgeReporter();

        String report1 = reporter.reportBridge(List.of("U", "U", "D"), List.of("U", "U", "D"));
        assertThat(report1).isEqualTo("[ O | O |   ]\n" + "[   |   | O ]");

        String report2 = reporter.reportBridge(List.of("U", "U", "U", "D"), List.of("U", "U", "D"));
        assertThat(report2).isEqualTo("[ O | O |   ]\n" + "[   |   | X ]");
    }
}