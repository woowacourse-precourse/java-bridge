package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import javax.swing.ImageIcon;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void printMap() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> userInput = List.of("U","D","D");
        List<Boolean> result = List.of(true,true,true);

        OutputView outputView = new OutputView();
        outputView.printUpLineMap(userInput,result);
        outputView.printDownLineMap(userInput,result);

        assertThat(out.toString()).isEqualTo("[ O |   |   ]\n[   | O | O ]");
    }

    @Test
    void printResult() {
    }
}