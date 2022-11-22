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
    OutputView outputView = new OutputView();
    @Test
    void printMap() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> userInput = List.of("U","D","D");
        List<Boolean> result = List.of(true,true,true);


        outputView.printUpLineMap(userInput,result);
        outputView.printDownLineMap(userInput,result);

        assertThat(out.toString()).isEqualTo("[ O |   |   ]\n[   | O | O ]\n");

        OutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));

        List<String> userInput2 = List.of("U","U");
        List<Boolean> result2 = List.of(true,false);
        outputView.printUpLineMap(userInput2,result2);
        outputView.printDownLineMap(userInput2,result2);
        assertThat(out2.toString()).isEqualTo("[ O | X ]\n[   |   ]\n");
    }
    @Test
    void printShortMap(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<String> userInput = List.of("U");
        List<Boolean> result = List.of(true);
        outputView.printShortMap(userInput,result);

        assertThat(out.toString()).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    void printResult() {
    }
}