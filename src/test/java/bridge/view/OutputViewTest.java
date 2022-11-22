package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.GameProgress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    OutputView outputView;

    @BeforeEach
    void beforeEach() throws Exception {
        outputView = new OutputView();
    }

    @Test
    void printWelcome() {
        outputView.printWelcome();
    }

    @Test
    void printGame() {
    }

    @Test
    void printMap_게임진행중() {
        List<String> list = List.of("U", "U", "U", "D", "D", "U", "D", "U", "D", "U", "D", "U", "D");
        Bridge bridge = new Bridge(list);
        String map = outputView.printMap(GameProgress.PLAYING, bridge);
        String answer =
                "[ O | O | O |   |   | O |   | O |   | O |   | O |   ]\n" +
                "[   |   |   | O | O |   | O |   | O |   | O |   | O ]";
        assertThat(map).isEqualTo(answer);
    }

    @Test
    void printMap_게임성공함() {
        List<String> list = List.of("U", "U", "U", "D", "D", "U", "D", "U", "D", "U", "D", "U", "D");
        Bridge bridge = new Bridge(list);
        String map = outputView.printMap(GameProgress.SUCCESS, bridge);
        String answer =
                "[ O | O | O |   |   | O |   | O |   | O |   | O |   ]\n" +
                "[   |   |   | O | O |   | O |   | O |   | O |   | O ]";
        assertThat(map).isEqualTo(answer);
    }

    @Test
    void printMap_중간에실패함() {
        List<String> list = List.of("U", "U", "U", "D", "D", "U", "D", "U", "D", "U", "D", "U", "D");
        Bridge bridge = new Bridge(list);
        String map = outputView.printMap(GameProgress.FAILURE, bridge);
        String answer =
                "[ O | O | O |   |   | O |   | O |   | O |   | O |   ]\n" +
                "[   |   |   | O | O |   | O |   | O |   | O |   | X ]";
        assertThat(map).isEqualTo(answer);
    }

    @Test
    void printResult() {
        outputView.printResult(GameProgress.SUCCESS, 30);
        outputView.printResult(GameProgress.FAILURE, 3);
    }
}
