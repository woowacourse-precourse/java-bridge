package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void TsetPrintMap() {
        OutputView outputView = new OutputView();
        outputView.printMap(List.of("U", "D", "D"), "OOO");
    }
}