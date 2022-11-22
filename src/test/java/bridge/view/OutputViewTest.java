package bridge.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {

    OutputView outputView = new OutputView();
    ByteArrayOutputStream outputStream;

    @BeforeEach
    void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("다리 건너기 결과가 알맞게 출력되는지 확인한다.")
    @Test
    void TestPrintingMap() {
        List<List<String>> map = List.of(
                List.of("O", " ", "X"),
                List.of(" ", "O", " ")
        );
        outputView.printMap(map);

        assertThat(outputStream.toString()).isEqualTo("[ O |   | X ]\n[   | O |   ]\n\n");
    }
}
