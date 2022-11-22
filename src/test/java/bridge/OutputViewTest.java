package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void printMap() {
        List<List<String>> list = List.of(List.of("O"," ","O"),List.of(" ","O"," "));
        outputView.printMap(list);
    }

    @Test
    void printResult() {
        List<List<String>> list = List.of(List.of("O"," ","O"),List.of(" ","O"," "));
        outputView.printResult(true, list, 3);
    }
}