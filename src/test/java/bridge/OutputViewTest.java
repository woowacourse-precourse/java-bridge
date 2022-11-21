package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void TsetPrintMap() {
        OutputView outputView=new OutputView();
        outputView.printMap("UDD", "OOO");
    }
}