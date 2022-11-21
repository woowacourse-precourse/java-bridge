package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultPrinterTest {

    @DisplayName("boolean 값으로 SuccessResultPrint or FailureResultPrint 추가")
    @Test
    void create_result_printer() {
        assertThat(ResultPrinter.createResultPrinter(true, List.of("U", "D")))
                .isInstanceOf(SuccessResultPrinter.class);
        assertThat(ResultPrinter.createResultPrinter(false, List.of("U", "D")))
                .isInstanceOf(FailureResultPrinter.class);
    }
}
