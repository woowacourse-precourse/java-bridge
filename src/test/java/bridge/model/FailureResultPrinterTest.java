package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FailureResultPrinterTest {

    @DisplayName("실패시 경로 출력")
    @Test
    void print() {
        FailureResultPrinter downUpFailureResultPrinter = new FailureResultPrinter(List.of("U", "D"));
        assertThat(downUpFailureResultPrinter.print()).isEqualTo("[ O |   ]\n[   | X ]\n");

        FailureResultPrinter upUpFailureResultPrinter = new FailureResultPrinter(List.of("U", "U"));
        assertThat(upUpFailureResultPrinter.print()).isEqualTo("[ O | X ]\n[   |   ]\n");
    }
}
