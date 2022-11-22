package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest extends NsTest {
    OutputView outputView = new OutputView();
    @DisplayName("길이가 1인 map 출력")
    @Test
    void printShortMap() {
        List<List<String>> sample = List.of(List.of("O"), List.of(""));
        outputView.printMap(sample);
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }

    @DisplayName("길이가 3인 map 출력")
    @Test
    void printLongMap() {
        List<List<String>> sample = List.of(List.of(" ", "O", "X"), List.of("O", " ", " "));
        outputView.printMap(sample);
        assertThat(output()).contains(
                "[   | O | X ]",
                "[ O |   |   ]"
        );
    }


    @Override
    protected void runMain() {
    }

}
