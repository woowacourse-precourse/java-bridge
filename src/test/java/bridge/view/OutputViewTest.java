package bridge.view;

import bridge.domain.GameBoard;
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
        GameBoard topGameBoard = new GameBoard(List.of(PASS,EMPTY,PASS));
        GameBoard bottomGameBoard = new GameBoard(List.of(EMPTY,PASS,EMPTY));
        String newLine = System.lineSeparator();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        printMap(topGameBoard, bottomGameBoard);
        String expect = "[ O |   | O ]"+newLine+"[   | O |   ]"+newLine;

        assertThat(output.toString()).contains(expect);
    }
}