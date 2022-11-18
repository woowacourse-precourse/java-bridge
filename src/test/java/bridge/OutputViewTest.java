package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void printGameStart() {
        OutputView outputView = new OutputView();

        outputView.printGameStart();
    }

    @Test
    void printMap() {
    }

    @Test
    void printResult() {
    }
}