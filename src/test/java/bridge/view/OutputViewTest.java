package bridge.view;

import bridge.model.MoveRecord;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

class OutputViewTest {

    @DisplayName("양식에 맞게 기록을 출력한다")
    @Test
    void printMap() {
        String answer = "[ O |   | X ]" + System.lineSeparator() +
                "[   | O |   ]" + System.lineSeparator();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OutputView outputView = new OutputView();
        List<MoveRecord> record =
                Arrays.asList(
                        MoveRecord.addRecord("U", true)
                        , MoveRecord.addRecord("D", true)
                        , MoveRecord.addRecord("U", false));
        outputView.printMap(record);

        Assertions.assertThat(out.toString()).isEqualTo(answer);
    }
}