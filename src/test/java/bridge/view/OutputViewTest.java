package bridge.view;

import static bridge.utils.Constant.START_MESSAGE;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputView outputView;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("시작 메세지 테스트")
    void printStartMessage() {
        outputView.printStartMessage();
        Assertions.assertThat(START_MESSAGE).isEqualTo(outputStreamCaptor.toString().trim());
    }

}
