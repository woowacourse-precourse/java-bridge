package bridge;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void 맵_변환_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        char[][] map = {{'O', 'O', 'O', ' '}, {' ', ' ', ' ', 'X'}};
        outputView.printMap(map);

        String output = out.toString();
        assertThat(output).contains("[ O | O | O |   ]",
                "[   |   |   | X ]"
        );
    }
}