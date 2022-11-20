package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void printMap() {
        List<List<String>> list = List.of(List.of("O","X","O"),List.of("X","O","X"));
        outputView.printMap(list);
    }

    @Test
    void printResult() {
    }
}