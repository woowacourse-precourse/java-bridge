package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SuccessResultPrinterTest {

    @DisplayName("성공시 경로 출력")
    @Test
    void print() {
        SuccessResultPrinter upDownSuccessResultPrinter = new SuccessResultPrinter(List.of("U", "D"));
        assertThat(upDownSuccessResultPrinter.print()).isEqualTo("[ O |   ]\n[   | O ]\n");

        SuccessResultPrinter upUpSuccessResultPrinter = new SuccessResultPrinter(List.of("U", "U"));
        assertThat(upUpSuccessResultPrinter.print()).isEqualTo("[ O | O ]\n[   |   ]\n");
    }
}
