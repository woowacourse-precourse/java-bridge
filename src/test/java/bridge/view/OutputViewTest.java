package bridge.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static bridge.constant.Constants.BridgeSign.*;
import static bridge.view.OutputView.*;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void printMapTest() {
        List<String> topGameBoard = new ArrayList<>(List.of(PASS,EMPTY,PASS));
        List<String> bottomGameBoard = new ArrayList<>(List.of(EMPTY,PASS,EMPTY));
        String newLine = System.lineSeparator();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printMap(topGameBoard, bottomGameBoard);
        String expect = "[ O |   | O ]"+newLine+"[   | O |   ]"+newLine;

        assertThat(output.toString()).contains(expect);
    }
}