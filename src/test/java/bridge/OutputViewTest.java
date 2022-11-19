package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        OutputView outputView = new OutputView();

        List<String> bridgeMoved = List.of("U", "D", "U", "U");
        for (int curPos = 1; curPos <= bridgeMoved.size(); curPos++) {
            outputView.printMap(bridgeMoved, curPos);
            System.out.println();
        }
    }

    @Test
    void printResult() {
    }
}